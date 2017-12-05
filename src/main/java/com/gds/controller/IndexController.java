package com.gds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/front/index.do")
    public String index(){
        return "front/index";
    }

    @RequestMapping("/front/about.do")
    public String about(){
        return "front/about";
    }

    @RequestMapping("/front/contact.do")
    public String contact(){
        return "front/contact";
    }

    @RequestMapping("/front/gallery.do")
    public String gallery(){
        return "front/gallery";
    }

    @RequestMapping("/front/icons.do")
    public String icons(){
        return "front/icons";
    }

    @RequestMapping("/front/service.do")
    public String service(){
        return "front/service";
    }

    @RequestMapping("/front/team.do")
    public String team(){
        return "front/team";
    }

    @RequestMapping("/front/typography.do")
    public String typography(){
        return "front/typography";
    }




}
