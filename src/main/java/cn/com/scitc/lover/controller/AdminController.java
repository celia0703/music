package cn.com.scitc.lover.controller;

import cn.com.scitc.lover.dao.*;
import cn.com.scitc.lover.model.*;
import cn.com.scitc.lover.myconfig.WebConfig;
import org.omg.PortableInterceptor.InterceptorOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private MusicDao musicDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RecDao recDao;
    @Autowired
    private CommentsDao commentsDao;
    @Autowired
    private AlbumDao albumDao;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    //    管理员登录
    @ResponseBody
    @GetMapping("/login")
    private String admin(@RequestParam("admin") String admin,
                         @RequestParam("adminpwd") String adminpwd,
                         Model model,
                         HttpSession session,
                         HttpServletRequest request) {
        Admin admin1 = adminDao.findByadmin(admin);
        if (admin1 == null) {
            return "null";
        } else {
            if (admin1.getAdminpwd().equals(adminpwd)) {
                model.addAttribute("admin", admin1.getAdmin());
                session.setAttribute("loginAdmin", admin);
                return "true";
            } else {
                return "false";
            }
        }
    }
    //   登出
    @GetMapping("/adminout")
    private String adminout(HttpSession session){
        session.removeAttribute(WebConfig.SESSION_KEY1);
        return "redirect:/music/musicindex";
    }
    //    管理员界面
    @GetMapping("/admin")
    private String adminPage(Model model) {
//        轮播图管理
        Iterable<Recommend> all = recDao.findAll();
        model.addAttribute("recommend",all);
        return "/admin/admin";
    }
 //    用户管理
    @GetMapping("/aduser")
    private String ad_user(Model model) {
        Iterable<Users> all = userDao.findAll();
        model.addAttribute("user",all);
        return "/admin/aduser";
    }
        //  删除用户
    @GetMapping("/delete")
    private String delete(Integer id){
        Users byUsername = userDao.findByUserId(id);
        userDao.delete(byUsername);
        return "redirect:/admin/aduser";
    }
    //  删除歌曲
    @GetMapping("/deleteMu")
    private String deleteMu(Integer id){
        Music bymusicId = musicDao.findBymusicId(id);
        musicDao.delete(bymusicId);
        return "redirect:/admin/music";
    }
    // 修改状态
    @PostMapping("/edit")
    private String edit(String status,Integer id){
        Users us = userDao.findByUserId(id);
        us.setStatus(status);
        userDao.save(us);
        return "redirect:/admin/aduser";
    }
    //评论管理
    @GetMapping("/member")
    private String admycomment(Model model){
        Iterable<Comments> all = commentsDao.findAll();
        model.addAttribute("comment",all);
        return "/admin/member";
    }
//    删除评论
    @GetMapping("/comdel")
    private String comdel(Integer id){
        Comments byCommentId = commentsDao.findByCommentId(id);
        commentsDao.delete(byCommentId);
        return "redirect:/admin/member";
    }
//    歌曲管理
    @GetMapping("/music")
    private String music(Model model,@RequestParam(defaultValue = "0")Integer pageNum){
        if(pageNum>1){
            pageNum -= 1;
        }
        Pageable pageable = PageRequest.of(pageNum,5);
        Page<Music> page = musicDao.findAll(pageable);
        model.addAttribute("music",page.getContent());
//        总页数
        model.addAttribute("pages",page.getTotalPages());
        Iterable<Album> all = albumDao.findAll();
        model.addAttribute("albumall",all);
        return "/admin/music";
    }
//    给歌曲添加专辑
    @PostMapping("/musicAl")
    private String musicAl(String albumAlbumname,Integer id){
        Music ms = musicDao.findBymusicId(id);
        ms.setAlbumAlbumname(albumAlbumname);
        musicDao.save(ms);
        return "redirect:/admin/music";
    }
//    专辑管理
    @GetMapping("/album")
    private String album(Model model){
        Iterable<Album> all = albumDao.findAll();
        model.addAttribute("album",all);
        return "/admin/album";
    }
//    专辑上传
    @GetMapping("/albumup")
    private String albumup(){
        return "/admin/albumup";
    }
    @PostMapping("/albumupon")
    private String albumupon(Model model,
                             @RequestParam("albumimg")MultipartFile albumimg,
                             @RequestParam("imgUrl")String imgUrl,
                             String albumname,
                             String singerSingername){
        Album al = new Album();
        String albumimgName = albumimg.getOriginalFilename();
        List<String> fileSuffix = new ArrayList<>();
        fileSuffix.add(".jpeg");
        fileSuffix.add(".png");
        fileSuffix.add(".jpg");
        fileSuffix.forEach(f ->{
            if(albumimgName.endsWith(f)){
                File dest1 = new File(imgUrl,albumimgName);
                try{
                    albumimg.transferTo(dest1);
//                上传成功
//                    return "yse3";
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        al.setAlbumtime(new java.sql.Date(new Date().getTime()));
        al.setAlbumimg("/music/album/"+albumimgName);
        al.setAlbumname(albumname);
        al.setSingerSingername(singerSingername);
        albumDao.save(al);
        return "redirect:/admin/albumup";
    }
    //删除专辑
    @GetMapping("/albumdel")
    private String albumdel(Integer id){
        albumDao.deleteById(id);
        return "redirect:/admin/album";
    }
//    订单管理
//    @GetMapping("member")
//    private String member(){
//        return "/admin/member";
//    }
    //上传歌曲
    @GetMapping("/musicup")
    private String admusicup(){
        return "admin/musicup";
    }
    @PostMapping("/upload")
    public  String upload(HttpSession session,
                          @RequestParam("file")MultipartFile file,
                          @RequestParam("lrc")MultipartFile lrc,
                          @RequestParam("musicimg") MultipartFile musicimg,
                          @RequestParam("targetUriMp3") String targetUriMp3,
                          @RequestParam("targetUriImage") String targetUriImage,
                          @RequestParam("targetUriText") String targetUriText,
                          String singerSingername,
                          String musicname,
                          String tag
                          ){
        Music ms = new Music();
        if(file.isEmpty()){
        //上传失败
//            return "error";
        }
        String fileName = file.getOriginalFilename();
        String lrcName = lrc.getOriginalFilename();
        String muiscimgName = musicimg.getOriginalFilename();
            if(fileName.endsWith(".mp3")){
                File dest1 = new File(targetUriMp3,fileName);
                String dest = dest1.getName();
                if(dest.endsWith(".mp3")){
                    try{
                    file.transferTo(dest1);
//                    上传成功
//                    return "yse2";
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            if(lrcName.endsWith(".txt")){
                log.error("1111",targetUriText);
                File dest1 = new File(targetUriText,lrcName);
                String dest = dest1.getName();
                if (dest.endsWith(".txt")) {
                    try {
                        lrc.transferTo(dest1);
//                        return "yse2";
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            List<String> fileSuffix = new ArrayList<>();
            fileSuffix.add(".jpeg");
            fileSuffix.add(".png");
            fileSuffix.add(".jpg");
            fileSuffix.forEach(f ->{
                if(muiscimgName.endsWith(f)){
                    File dest1 = new File(targetUriImage,muiscimgName);
                    try{
                    musicimg.transferTo(dest1);
//                上传成功
//                    return "yse3";
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            ms.setMusicname(musicname);
            ms.setSingerSingername(singerSingername);
            ms.setTag(tag);
            ms.setMusicimg("/music/imgbook/"+muiscimgName);
            ms.setMusicurl("/music/songbook/"+fileName);
            ms.setLrc("/music/lrcbook"+lrcName);
            musicDao.save(ms);
        return "redirect:/admin/musicup";
    }
//    上传轮播图
    @PostMapping("/lunboup")
    public String lunboup(Model model,
                          @RequestParam("targetlunbo") String targetlunbo,
                          @RequestParam("lunboimg")MultipartFile lunboimg,
                          Integer recommendId){
        Recommend rec = new Recommend();
        String lunbo  = lunboimg.getOriginalFilename();
        List<String> fileSuffix = new ArrayList<>();
        fileSuffix.add(".jpeg");
        fileSuffix.add(".png");
        fileSuffix.add(".jpg");
        fileSuffix.forEach(f ->{
            if(lunbo.endsWith(f)){
                File dest1 = new File(targetlunbo,lunbo);
                try{
                    lunboimg.transferTo(dest1);
//                上传成功
//                    return "yse3";
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        String recimg = "/music/imgindex/"+lunbo;
        recDao.update(recimg,recommendId);
        return "redirect:/admin/admin";
    }
//    修改密码
    @ResponseBody
    @GetMapping("/editPassword")
    private Integer editPassword(String password,String password1,String password2,HttpSession session){
        String name = (String) session.getAttribute("loginAdmin");
        Admin byadmin = adminDao.findByadmin(name);
        if(byadmin.getAdminpwd().equals(password)){
            if(password1 == password2){
                byadmin.setAdminpwd(password);
                adminDao.save(byadmin);
                return 1;
            }else{
                return 2;
            }
        }else{
            return 3;
        }
    }
}

