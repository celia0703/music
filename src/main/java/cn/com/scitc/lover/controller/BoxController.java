package cn.com.scitc.lover.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/box")
public class BoxController {
//    主页
    @GetMapping("/index")
    private String index(){
        return "/box/index";
    }
//    音乐盒
    @GetMapping("/musicbox")
    private String musicbox(){
        return "/box/musicbox";
    }
}
