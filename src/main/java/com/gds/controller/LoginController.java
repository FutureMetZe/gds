package com.gds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
//http://blog.csdn.net/u014427391/article/details/51419521
    /**
     * 登录
     * @param session
     *          HttpSession
     * @param username
     *          用户名
     * @param password
     *          密码
     * @return
     */
    @RequestMapping(value="/login")
    public String login(HttpSession session,String username,String password) throws Exception{
        //在Session里保存信息
        session.setAttribute("username", username);
        //重定向
        return "redirect:hello.action";
    }

    /**
     * 退出系统
     * @param session
     *          Session
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) throws Exception{
        //清除Session
        session.invalidate();

        return "redirect:hello.action";
    }




}
