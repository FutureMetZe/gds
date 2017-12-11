package com.gds.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接口工具类
 */
public class InterfaceUtils {

    public static void errors(HttpServletRequest request, HttpServletResponse response, int code, String msg){
        response.setCharacterEncoding("UTF-8");
        JSONObject obj = new JSONObject();

        obj.put("code", code);
        obj.put("message", msg);
        //obj.put("data", "");
        try {
            response.getWriter().println(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void success(HttpServletRequest request, HttpServletResponse response, int code,String msg,JSONObject obj){
        response.setCharacterEncoding("UTF-8");
        obj.put("code", code);
        obj.put("message", msg);
        try {
            response.getWriter().println(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
