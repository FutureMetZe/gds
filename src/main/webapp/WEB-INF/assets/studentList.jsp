<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>社团后台管理系统</title>
    <meta name="description" content="这是一个 table 页面">
    <meta name="keywords" content="table">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <small>后台管理系统</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">

            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span
                    class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main">
    <!-- sidebar start -->
    <div class="admin-sidebar">
        <ul class="am-list admin-sidebar-list">
            <li><a href="admin-index.do"><span class="am-icon-home"></span> 首页</a></li>

            <li><a href="studentList.do"><span class="am-icon-table"></span> 成员列表</a></li>
            <li><a href="studentJoinList.do"><span class="am-icon-sign-out"></span> 入社申请</a></li>

            <li><a href="studentGoods.do"><span class="am-icon-puzzle-piece"></span> 物资管理</a></li>

            <li><a href="studentRooms.do"><span class="am-icon-pencil-square-o"></span> 活动室管理</a></li>
            <li><a href="studentNotice.do"><span class="am-icon-sign-out"></span> 公告管理</a></li>

        </ul>

        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-bookmark"></span> ${notice.standby001}</p>
                <p>${notice.noticeContent}</p>
            </div>
        </div>

        <div class="am-panel am-panel-default admin-sidebar-panel">
            <div class="am-panel-bd">
                <p><span class="am-icon-tag"></span> ${club.club_name}</p>
                <p>欢迎访问社团后台管理系统!</p>
            </div>
        </div>


    </div>
    <!-- sidebar end -->

    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">成员</strong> /
                <small>列表</small>
            </div>
        </div>

        <div class="am-g">
            <div class="am-u-md-6 am-cf">
                <div class="am-fl am-cf">
                    <div class="am-btn-toolbar am-fl">


                    </div>
                </div>
            </div>

        </div>

        <div class="am-g">
            <div class="am-u-sm-12">
                <form class="am-form">
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-check"><input type="checkbox"/></th>
                            <th class="table-id">ID</th>
                            <th class="table-title">学号</th>
                            <th class="table-title">帐号</th>
                            <th class="table-type">姓名</th>
                            <th class="table-author">学院</th>
                            <th class="table-date">注册日期</th>
                            <th class="table-set">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${students}" var="Student">
                            <tr>
                                <td><input type="checkbox"/></td>
                                <td>${Student.userId}</td>
                                <td>${Student.stuNum}</td>
                                <td>${Student.username}</td>
                                <td>${Student.stuName}</td>
                                <td>${Student.standby001}</td>
                                <td>${Student.registerTime}</td>
                                <td>
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">


                                            <button class="am-btn am-btn-default am-btn-xs am-text-danger"><span
                                                    class="am-icon-trash-o"></span><a href="/assets/deleteStudent.do?stuNum=${Student.stuNum}" onClick="return confirm('确定解除此用户与社团的关联?');"> 注销此用户</a>
                                            </button>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    <div class="am-cf">
                        共 ${stuCount} 条记录
                        <%--<div class="am-fr">--%>
                        <%--<ul class="am-pagination">--%>
                        <%--<li class="am-disabled"><a href="#">«</a></li>--%>
                        <%--<li class="am-active"><a href="#">1</a></li>--%>
                        <%--<li><a href="#">2</a></li>--%>
                        <%--<li><a href="#">3</a></li>--%>
                        <%--<li><a href="#">4</a></li>--%>
                        <%--<li><a href="#">5</a></li>--%>
                        <%--<li><a href="#">»</a></li>--%>
                        <%--</ul>--%>
                        <%--</div>--%>
                    </div>
                    <hr/>

                </form>
            </div>

        </div>
    </div>
    <!-- content end -->
</div>

<footer>
    <hr>
    <p class="am-padding-left">© <%= new Date()%>.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="/assets/js/polyfill/rem.min.js"></script>
<script src="/assets/js/polyfill/respond.min.js"></script>
<script src="/assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="/assets/js/app.js"></script>
</body>
</html>
