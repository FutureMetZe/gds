package com.gds.controller.back;

import com.gds.entity.Student;
import com.gds.service.StudentService;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/back")
public class PageController {
    private Logger logger = Logger.getLogger(PageController.class);

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
