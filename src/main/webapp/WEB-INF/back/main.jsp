<%--
  Created by IntelliJ IDEA.
  User: MPC
  Date: 2017/12/5
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String BasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="${BasePath}/back/top.do" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
    <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
        <frame src="${BasePath}/back/left.do" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
        <frame src="${BasePath}/back/index.do" name="rightFrame" id="rightFrame" title="rightFrame" />
    </frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>
