package com.gds.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录认证的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从request中获取session
        HttpSession session = request.getSession();
        // 从session中获取username
        Object username = session.getAttribute("AdminUsername");
        // 判断username是否为null
        if (username != null) {
            // 如果不为空则放行
            return true;
        } else {
            // 如果为空则跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/user/toLogin.do");
        }

        return false;

    }


    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    /**
     * Handler执行完成之后调用这个方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
