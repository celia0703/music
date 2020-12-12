package cn.com.scitc.lover.controller;

import cn.com.scitc.lover.dao.CollectionDao;
import cn.com.scitc.lover.dao.MusicDao;
import cn.com.scitc.lover.dao.UserDao;
import cn.com.scitc.lover.model.Category;
import cn.com.scitc.lover.model.Collections;
import cn.com.scitc.lover.model.Music;
import cn.com.scitc.lover.model.Users;
import cn.com.scitc.lover.myconfig.WebConfig;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private UserDao userDao;
    @Autowired private CollectionDao collectionDao;
    @Autowired private MusicDao musicDao;
    @ResponseBody
    @GetMapping("/login")
    private  String login(@RequestParam("username")String username,
                             @RequestParam("userpwd")String userpwd,
                             Model model,
                             HttpSession session){
                Users users = userDao.findByUsername(username);
//        如果数据库中未查到该账号
        if(users == null){
            return "null";
        }else {
            if (users.getUsername().equals(username)&users.getUserpwd().equals(userpwd)) {
                //如果密码于用户匹配成功
                //登录成功，防止表单重复提 交
                //拦截器，只要登录就可以存在Session里面
                model.addAttribute("username", users.getUsername());
                session.setAttribute("loginUser", username);
                session.setAttribute("stutas",users.getStatus());
                return "true";
            }else{
                return "flase";
            }
        }
    }

//   登出
    @GetMapping("/loginout")
    private String loginout(HttpSession session){
        session.removeAttribute(WebConfig.SESSION_KEY);
        return "redirect:/music/musicindex";
    }
//    注册
    @ResponseBody
    @GetMapping("/register")
    private Boolean register(Users inputUs,Model model,HttpSession session){
        inputUs.setRegtime(new java.sql.Date(new Date().getTime()));
        userDao.save(inputUs);
        model.addAttribute("username",inputUs.getUsername());
        return true;
    }
//   我喜欢
    @GetMapping("/mylike")
    private String mylike(HttpSession session,Model model){
        String username=(String)session.getAttribute("loginUser");
        List<Music> allByUsername = musicDao.findAllByUsername(username);
        Users byUsername = userDao.findByUsername(username);
        Object ms = JSON.toJSON(allByUsername);
        model.addAttribute("mylike",ms);
        model.addAttribute("user",byUsername);
        return "/user/mylike";
    }
//    移除我喜欢
    @GetMapping("/deleteLike")
    private String delete(String name){
        collectionDao.deleteByMusicMusicname(name);
        return "redirect:/user/mylike";
    }
//    收藏
    @ResponseBody
    @GetMapping("collect")
    private String collect(@RequestParam("musicname") String musicname,
                           HttpSession session){
        String username=(String)session.getAttribute("loginUser");
        Collections collections = new Collections();
        List<Collections> cate = collectionDao.findAllByMusicMusicnameAndUsersUsername(musicname, username);
        if(username==null){
            return "null";
        }
        if(cate.size()==0){
            collections.setUsersUsername(username);
            collections.setMusicMusicname(musicname);
            collectionDao.save(collections);
            return "have";
        }else{
            return "has";
        }
    }
//    我的支付
//    @GetMapping("/mycomment")
//    private String mycomment(HttpSession session){
//        String username=(String)session.getAttribute("loginUser");
//        Users us = userDao.findByUsername(username);
//        us.setStatus("会员");
//        session.setAttribute("stutas",us.getStatus());
//        userDao.save(us);
//        return "/user/mycomment";
//    }
//   个人信息
    @GetMapping("/mine")
    private String mine(Model model, HttpSession session){
        String username=(String)session.getAttribute("loginUser");
        String stutas = (String)session.getAttribute("stutas");
        Users byUsername = userDao.findByUsername(username);
        model.addAttribute("user",byUsername);
        return "/user/mine";
    }
    @PostMapping("/mined")
    private String mined(Model model,
                         HttpSession Session,
                         @RequestParam("touxiang")String touxiang,
                         @RequestParam("userimg")MultipartFile userimg,
                         String username,
                         String gender,
                         Integer age,
                         String number,
                         String status,
                         Integer userId
                         ){
        Users us = new Users();
        String userimgName = userimg.getOriginalFilename();
        List<String> fileSuffix = new ArrayList<>();
            fileSuffix.add(".jpeg");
            fileSuffix.add(".png");
            fileSuffix.add(".jpg");
        fileSuffix.forEach(f ->{
            if(userimgName.endsWith(f)){
                File dest1 = new File(touxiang,userimgName);
                try{
                    userimg.transferTo(dest1);
//                上传成功
//                    return "yse3";
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        us.setUserimg("/music/touxiang/"+userimgName);
        userDao.update(username,age,gender,number,us.getUserimg(),userId);
        return "redirect:/user/mine";
    }
}
