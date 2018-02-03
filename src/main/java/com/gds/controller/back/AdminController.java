package com.gds.controller.back;

import com.gds.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/back")
public class AdminController {

    @RequestMapping("/adminLogin.do")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                      /* @RequestParam(value = "pageSize", required = false)Integer pageSize,
                       @RequestParam(value = "currentPage", required = false)Integer currentPage,
                       @RequestParam(value = "name", required = false)String name,
                       @RequestParam(value = "department", required = false)String department*/
                      User user){
        System.out.print(user);
        //校验登录逻辑
        if(user.getUsername().equals("admin")){
            request.getSession().setAttribute("username",user.getUsername());
            return "back/main";
        }else{
            return "back/login";
        }

    }
}
