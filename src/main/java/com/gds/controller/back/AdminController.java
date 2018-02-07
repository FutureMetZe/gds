package com.gds.controller.back;

import com.gds.entity.Student;
import com.gds.entity.User;
import com.gds.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/back")
public class AdminController {

    @Resource(name = "StudentService")
    private StudentService studentService;

    @RequestMapping("/adminLogin.do")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "username", required = false)String username,
                       @RequestParam(value = "password", required = false)String password){
        Student Admin = studentService.selectByUsernameAndPassword(username,password);
        HttpSession session = request.getSession(true);
        String message = "";
        //校验登录逻辑
        if (Admin != null){
            session.setAttribute("AdminName",Admin.getStu_name());
            session.setAttribute("Admin",Admin);
            //用户存在
            return "back/main";
        }else {
            //用户不存在
            message = "帐号或密码不正确！";
            model.addAttribute("message",message);
            return "back/main";
        }

    }
}
