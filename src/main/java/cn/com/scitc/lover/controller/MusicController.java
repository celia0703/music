package cn.com.scitc.lover.controller;


import cn.com.scitc.lover.dao.*;
import cn.com.scitc.lover.model.*;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private RecDao recDao;
    @Autowired
    private MusicDao musicDao;
    @Autowired
    private CommentsDao commentsDao;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private UserDao userDao;
    @GetMapping("/musicindex")
    private  String index(Model model,@RequestParam(defaultValue = "0") Integer pageNum){
//      推荐的轮播图
        Recommend byRecId1 = recDao.findByRecId(1);
        Recommend byRecId2 = recDao.findByRecId(2);
        Recommend byRecId3 = recDao.findByRecId(3);
        Recommend byRecId4 = recDao.findByRecId(4);
        model.addAttribute("lunbo1",byRecId1);
        model.addAttribute("lunbo2",byRecId2);
        model.addAttribute("lunbo3",byRecId3);
        model.addAttribute("lunbo4",byRecId4);
//        歌曲推荐
        Pageable pageable =  PageRequest.of(pageNum,5);
        Page<Music> page = musicDao.findAll(pageable);
//        Iterable<Music> all = musicDao.findAll();
        Object music = JSON.toJSON(page.getContent());
        model.addAttribute("musiclist",music);
//        歌单推荐
        List<Album> limit = albumDao.findLimit();
        model.addAttribute("albumlist",limit);
        return "/music/musicindex";
    }
//    歌单
    @GetMapping("/musicList")
    private String musicList(){
        return "/music/musicList";
    }
//   动态
    @GetMapping("/comment")
    private String comment(){
        return "/music/comment";
    }
//   专辑
    @GetMapping("/album")
    private String album(Model model){
        List<Album> limit = albumDao.findLimit();
        model.addAttribute("albumlist",limit);
        return "/music/album";
    }

//   搜索框
    @GetMapping("/musicsearch")
    private String musicsearch(){
        return "/music/musicsearch";
    }
    @GetMapping("/searching")
    private String searching(String musicname,Model model){
        List<Music> search = musicDao.findByMusicnameLike('%'+musicname+'%');
        Object music = JSON.toJSON(search);
        model.addAttribute("searchlist",music);
        return "/music/musicsearch";
    }

//  根据歌曲评论
    @ResponseBody
    @GetMapping("/userComment")
private Boolean userComment(Comments comInp, Model model, HttpSession session, String date, String musicname){
    String username=(String)session.getAttribute("loginUser");
    if(username != null){
        Comments com=new Comments();
        com.setUsersUsername(username);
        com.setText(comInp.getText());
        com.setMusicMusicname(musicname);
        com.setTime(date);
        commentsDao.save(com);
        return true;
    }else {
        return false;
    }

}
//查找歌曲
    @GetMapping("/com")
    private String com(String musicname,Model model,@RequestParam(defaultValue = "0")Integer pageNum){
        Music byMusicname = musicDao.findByMusicname(musicname);

        if (pageNum != 0){
            pageNum = pageNum - 1;
        }
        Pageable pageable = PageRequest.of(pageNum,2);
        Page<Comments> page = commentsDao.findByMusicname(musicname,pageable);
        for (Comments comments : page){
            Users byUsername = userDao.findByUsername(comments.getUsersUsername());
            comments.setUsers(byUsername);
        }
        Object music = JSON.toJSON(byMusicname);
        model.addAttribute("music",music);
//        model.addAttribute("music",byMusicname);
        model.addAttribute("pages",page.getTotalPages());
//        System.out.println(page.getTotalPages());
        model.addAttribute("comment",page);
        return "/music/comment";
    }
//    查找歌单
    @GetMapping("/albumMusic")
    private String albumMusic(String albumAlbumname,Model model){
        List<Music> byalbumAlbumname = musicDao.findByalbumAlbumname(albumAlbumname);
        Object album = JSON.toJSON(byalbumAlbumname);
        model.addAttribute("album",album);
        return "/music/musicAl";
    }
    @GetMapping("/musicAl")
    private String musicAl(){
        return "/music/musicAl";
    }
//    文件下载
    @RequestMapping("/download")
    public String download(HttpServletResponse response,
                           String url){
        String filename = url;
        String filePath = "//Users/mac/Desktop";
        File file = new File(filePath+filename);
//        if(file.exists()){
//            判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition","attachment;fileName="+filename);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null;//输出流
            try{
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i=bis.read(buffer);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("-----------file download"+filename);
            try{
                bis.close();
                fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
//        }else{
//            System.out.println("下载失败");
//        }
        return null;
    }
}
