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
                <li>社团名称：<b></b>&nbsp;&nbsp;${club.club_name}</li>
                <li>社团类型：<b></b>&nbsp;&nbsp;${club.club_type}</li>
                <li>所属学院：<b></b>&nbsp;&nbsp;${club.club_faculty}</li>
                <li>成立时间：<b></b>&nbsp;&nbsp;${club.club_createtime}</li>
                <li>社团状态：<b></b>&nbsp;&nbsp;${club.club_status}</li>
                <li>负责人姓名：<b></b>&nbsp;&nbsp;${club.club_standby001}</li>
                <li>负责人学号：<b></b>&nbsp;&nbsp;${club.club_standby002}</li>
                <li>社团介绍：<b></b></label>&nbsp;&nbsp;${club.club_introduce}</li>
                <li>社团现有人数：<b></b></label>&nbsp;&nbsp;${stuCount}</li>
                <c:forEach items="${students}" var="student">
                    <li>成员:<b></b>&nbsp;&nbsp;${student.stuName}<a
                            href="/back/stuIntroduce.do?user_id=${student.userId}"><h5>点击查看学生详情</h5></a></li>
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
