package com.gds.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back")
public class AdminController {

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


}
