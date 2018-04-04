<%--
  Created by IntelliJ IDEA.
  User: Future
  Date: 2018/1/28
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>湖北二师社团之家</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="images/icon.png">
    <link rel="shortcut icon" href="images/favicon.ico">
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/nprogress.js"></script>
    <script src="js/jquery.lazyload.min.js"></script>
    <!--[if gte IE 9]>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href = 'upgrade-browser.html';</script>
    <![endif]-->
</head>
<body class="user-select">
<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <ul class="site-nav topmenu">
                    <% if (session.getAttribute("UserName") == null || session.getAttribute("UserName").equals("")) {
                        out.write(" <li><a href=\"toRegisterPage.do\" >注册</a></li>" +
                                "<li><a href=\"toLoginPage.do\" >登录</a></li>");
                    } else {
                        out.write("<li>欢迎你，" + session.getAttribute("UserName").toString() + "！</li>" +
                                "<li><a href=\"home/goHome.do\" >个人主页</a></li>" +
                                "<li><a href=\"userExit.do\" >退出</a></li>"
                        );
                    }
                    %>
                </ul>
                勤记录 懂分享
            </div>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#header-navbar" aria-expanded="false"><span class="sr-only"></span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
                <h1 class="logo hvr-bounce-in"><a href="#" title="湖北二师社团之家"><img src="#" alt="湖北二师社团之家"></a></h1>
            </div>
            <div class="collapse navbar-collapse" id="header-navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a data-cont="首页" title="首页" href="index.do">首页</a></li>
                    <c:forEach items="${blogPostType}" var="DictType">
                        <li><a data-cont="${DictType.value}" title="${DictType.value}"
                               href="list.do?postType=${DictType.value}">${DictType.value}</a></li>
                    </c:forEach>
                    <li><a data-cont="团委资讯" title="团委资讯" href="http://tw.hue.edu.cn/">团委资讯</a></li>
                    <li><a data-cont="二师官网" title="二师官网" href="http://www.hue.edu.cn/static/">二师官网</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<section class="container">
    <div class="content-wrap">
        <div class="content">
            <div class="title">
                <h3 style="line-height: 1.3">${PageType}</h3>
            </div>
            <!--posts-->
            <c:forEach items="${posts}" var="Post">
                <article class="excerpt excerpt-1" style="">
                    <a class="focus" href="/blog/show.do?blogId=${Post.blogId}" title="${Post.blogTitle}"
                       target="_blank"><img class="thumb" data-original="${Post.imgUrl}" src="${Post.imgUrl}"
                                            alt="${Post.blogTitle}" style="display: inline;"></a>
                    <header><a class="cat" href="/blog/show.do?blogId=${Post.blogId}"
                               title="${Post.blogSort}">${Post.blogSort}<i></i></a>
                        <h2><a href="/blog/show.do?blogId=${Post.blogId}" title="${Post.blogTitle}"
                               target="_blank">${Post.blogTitle}</a>
                        </h2>
                    </header>
                    <p class="meta">
                        <time class="time"><i class="glyphicon glyphicon-time"></i> ${Post.blogCreatTime}</time>
                        <span class="views"><i class="glyphicon glyphicon-eye-open"></i> ${Post.view}</span> <a
                            class="comment" href="/blog/show.do?blogId=${Post.blogId}" title="评论" target="_blank"><i
                            class="glyphicon glyphicon-comment"></i> 点击查看评论</a>
                    </p>
                    <p class="note">${Post.standby003}</p>
                </article>
            </c:forEach>

            <%--<nav class="pagination" style="display: none;">--%>
            <%--<ul>--%>
            <%--<li class="prev-page"></li>--%>
            <%--<li class="active"><span>1</span></li>--%>
            <%--<li><a href="?page=2">2</a></li>--%>
            <%--<li class="next-page"><a href="?page=2&postType=${postType}">下一页</a></li>--%>
            <%--<li><span>共 2 页</span></li>--%>
            <%--</ul>--%>
            <%--</nav>--%>
        </div>
    </div>
    <aside class="sidebar">
        <div class="fixed">
            <div class="widget widget_search">
                <form class="navbar-form" action="/blog/list.do" >
                    <div class="input-group">
                        <input type="hidden" name="search" value="search">
                        <input type="text" name="postType" class="form-control" size="35" placeholder="请输入关键字"
                               maxlength="15" autocomplete="off">
                        <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span></div>
                </form>
            </div>
            <div class="widget widget-tabs">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#notice" aria-controls="notice" role="tab"
                                                              data-toggle="tab">统计信息</a></li>
                    <li role="presentation"><a href="#contact" aria-controls="contact" role="tab"
                                               data-toggle="tab">联系站长</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane contact active" id="notice">
                        <h2>日志总数:
                            ${postCount}篇
                        </h2>
                        <h2>已注册人数:
                            <span id="sitetime">${userCount}人 </span></h2>
                    </div>
                    <div role="tabpanel" class="tab-pane contact" id="contact">
                        <h2>QQ:
                            <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=513598006&amp;site=qq&amp;menu=yes"
                               target="_blank" rel="nofollow" data-toggle="tooltip" data-placement="bottom" title=""
                               data-original-title="QQ:513598006">513598006</a>
                        </h2>
                        <h2>Email:
                            <a href="mailto:513598006@qq.com" target="_blank" data-toggle="tooltip" rel="nofollow"
                               data-placement="bottom" title="" data-original-title="Email:513598006@qq.com">513598006@qq.com</a>
                        </h2>
                    </div>
                </div>
            </div>
        </div>
        <div class="widget widget_hot">
            <h3>最新评论文章</h3>
            <ul>
                <c:forEach items="${newReviews}" var="Review">
                    <li><a title="${Review.blogTitle}" href="/blog/show.do?blogId=${Review.blogId}"><span
                            class="thumbnail">
                    <img class="thumb" data-original="" src="" alt="${Review.reviewContent}" style="display: block;">
                </span><span class="text">${Review.blogTitle}</span><span class="muted"><i
                            class="glyphicon glyphicon-time"></i>
                    ${Review.reviewCreattime}
                </span><span
                            class="muted"><%--<i class="glyphicon glyphicon-eye-open"></i>--%>${Review.reviewUserName}</span></a>
                    </li>
                </c:forEach>

            </ul>
        </div>
        <%--<div class="widget widget_sentence">--%>

        <%--<a href="${BasePath}/show/269.html" target="_blank" rel="nofollow" title="MZ-NetBlog主题" >--%>
        <%--<img style="width: 100%" src="images/ad.jpg" alt="MZ-NetBlog主题" ></a>--%>

        <%--</div>--%>
        <div class="widget widget_sentence">


        </div>
    </aside>
</section>
<footer style="padding: 30px 0; line-height: 30px; text-align: center; background-color: #eee; color: #666; font-weight: 300;}
body .layui-layout-admin .footer-demo{height: auto; padding: 15px 0; line-height: 26px;">
    <div class="container">
        <p>版权所有©湖北第二师范学院 李正杰&nbsp;
            联系邮箱：513598006@qq.com &nbsp;
            本系统仅供学习交流，请勿用于商业用途，谢谢！&nbsp;</p>
    </div>

</footer>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ias.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>
