package com.gds.controller.back;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back")
public class BackController {
    private Logger logger = Logger.getLogger(BackController.class);

    @RequestMapping("/login.do")
    public String login(){
        return "back/login";
    }

    @RequestMapping("/main.do")
    public String main(){
        return "back/main";
    }
    @RequestMapping("/top.do")
    public String top(){
        return "back/top";
    }
    @RequestMapping("/left.do")
    public String left(){
        return "back/left";
    }
    @RequestMapping("/index.do")
    public String index(){
        return "back/index";
    }
    @RequestMapping("/right.do")
    public String right(){
        return "back/right";
    }






}
