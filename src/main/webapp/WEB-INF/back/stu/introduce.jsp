<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>

    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 345
            });
            $(".select2").uedSelect({
                width: 167
            });
            $(".select3").uedSelect({
                width: 100
            });
        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">社团信息</a></li>
        <li><a href="#">社员管理</a></li>
    </ul>
</div>

<div class="formbody">


    <div id="usual1" class="usual">

        <div class="itab">
            <ul>
                <li><a href="#tab1" class="selected">查看社员详细信息</a></li>
            </ul>
        </div>

        <div id="tab1" class="tabson">

            <ul class="forminfo">
                <li>账&nbsp;&nbsp;&nbsp;&nbsp;号：<b></b>&nbsp;&nbsp;${student.username}</li>
                <li>密&nbsp;&nbsp;&nbsp;&nbsp;码：<b></b>&nbsp;&nbsp;${student.password}</li>
                <li>姓&nbsp;&nbsp;&nbsp;&nbsp;名：<b></b>&nbsp;&nbsp;${student.stuName}</li>
                <li>学&nbsp;&nbsp;&nbsp;&nbsp;号：<b></b>&nbsp;&nbsp;${student.stuNum}</li>
                <li>学&nbsp;&nbsp;&nbsp;&nbsp;院：<b></b>&nbsp;&nbsp;${student.standby001}</li>
                <li>电&nbsp;&nbsp;&nbsp;&nbsp;话：<b></b>&nbsp;&nbsp;${student.mobile}</li>
                <li>邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<b></b>&nbsp;&nbsp;${student.email}</li>
                <li>注册时间：<b></b></label>&nbsp;&nbsp;${student.registerTime}</li>
                <li>上次登录时间：<b></b></label>&nbsp;&nbsp;${student.lastLoginTime}</li>
                <c:forEach items="${clubs}" var="Club">
                    <li>加入的社团:<b></b>&nbsp;&nbsp;${Club.club_name}<a
                            href="/back/clubIntroduce.do?clubId=${Club.club_id}"><h5>点击查看社团详情</h5></a></li>
                </c:forEach>
                <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="修改并保存"/></li>

            </ul>


        </div>

        <script type="text/javascript">
            $("#usual1 ul").idTabs();
        </script>

        <script type="text/javascript">
            $('.tablelist tbody tr:odd').addClass('odd');
        </script>


    </div>
</div>
</body>
</html>
