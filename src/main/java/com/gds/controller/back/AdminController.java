package com.gds.controller.back;

import com.gds.entity.Student;
import com.gds.entity.User;
import com.gds.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String toLogin(){
        return "back/login";
    }


    @RequestMapping(value = "/login.do")
    public String list(String username, String password, HttpSession session, Model model){
        Student Admin = studentService.selectByUsernameAndPassword(username,password);
//        HttpSession session = request.getSession(true);
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
            model.addAttribute("message",message);
            return "redirect:/back/main.do;";
        }

    }

    @RequestMapping(value = "/exit.do")
    public String exit(String username, String password, HttpSession session, Model model){
        session.removeAttribute("AdminName");
        session.removeAttribute("AdminUsername");
        return "redirect:/back/main.do;";
    }
}
