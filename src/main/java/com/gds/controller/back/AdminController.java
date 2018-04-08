package com.gds.controller.back;

import com.gds.entity.Student;
import com.gds.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class AdminController {

    @Resource(name = "StudentService")
    private StudentService studentService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/toLogin.do")
    public String toLogin(HttpSession session){

        return "back/login";
    }


    @RequestMapping(value = "/login.do")
    public String list(String username, String password, HttpSession session, Model model){
        Student Admin = studentService.selectByUsernameAndPassword(username,password);
        String message = "";
        //校验登录逻辑
        if (Admin != null){
            session.setAttribute("AdminName",Admin.getStuName());
            session.setAttribute("AdminUsername",Admin.getUsername());
            //用户存在
            return "redirect:/back/main.do;";
        }else {
            //用户不存在
            message = "帐号或密码不正确！";
            session.setAttribute("message",message);
            return "redirect:/user/toLogin.do;";
        }

    }

    @RequestMapping(value = "/exit.do")
    public String exit(String username, String password, HttpSession session, Model model){
        session.removeAttribute("AdminName");
        session.removeAttribute("AdminUsername");
        return "redirect:/back/main.do;";
    }
}
