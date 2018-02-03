<%--
  Created by IntelliJ IDEA.
  User: Future
  Date: 2018/1/28
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>木庄网络博客MZ-NetBlog主题源码</title>
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
    <script>window.location.href='upgrade-browser.html';</script>
    <![endif]-->
</head>
<body class="user-select">
<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <ul class="site-nav topmenu">
                    <% if(session.getAttribute("UserName") == null || session.getAttribute("UserName").equals("")){
                        out.write(" <li><a href=\"toRegisterPage.do\" >注册</a></li>" +
                                "<li><a href=\"toLoginPage.do\" >登录</a></li>" );
                    }else {
                        out.write("<li>欢迎你，"+session.getAttribute("UserName").toString()+"！</li>"+
                                "<li><a href=\"userExit.do\" >退出</a></li>");
                    }
                    %>
                    <%--<li><a href="${BasePath}/blog/toRegisterPage.do" >注册</a></li>
                    <li><a href="${BasePath}/blog/toLoginPage.do" >登录</a></li>
                    <%="欢迎您，"+session.getAttribute("UserName").toString()+"！"%>--%>
                </ul>
                勤记录 懂分享</div>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <h1 class="logo hvr-bounce-in"><a href="#" title="木庄网络博客"><img src="#" alt="湖北二师社团之家"></a></h1>
            </div>
            <div class="collapse navbar-collapse" id="header-navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a data-cont="木庄网络博客" title="木庄网络博客" href="index.do">首页</a></li>
                    <li><a data-cont="列表页" title="列表页" href="list.do">列表页</a></li>
                    <c:forEach items="${blogPostType}" var="DictType">
                        <li><a data-cont="${DictType.value}" title="${DictType.value}" href="${BasePath}/list/share/" >${DictType.value}</a></li>
                    </c:forEach>

                    <li><a data-cont="靠谱网赚" title="靠谱网赚" href="${BasePath}/list/money/" >靠谱网赚</a></li>
                    <li><a data-cont="资讯分享" title="资讯分享" href="${BasePath}/list/news/" >资讯分享</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<section class="container">
    <div class="content-wrap">
        <div class="content">
            <div class="title">
                <h3 style="line-height: 1.3">MZ-NetBlog主题</h3>
            </div>
            <!--posts-->
            <c:forEach items="${posts}" var="Post">
                <article class="excerpt excerpt-1" style="">
                    <a class="focus" href="/blog/show.do?blogId=${Post.blogId}" title="${Post.blogTitle}" target="_blank" >
                        <img class="thumb" data-original="${BasePath}/upload/201610/18/201610181739277776.jpg" src="${BasePath}/upload/201610/18/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: inline;"></a>
                    <header><a class="cat" href="#" title="${Post.blogSort}" >${Post.blogSort}<i></i></a>
                        <h2><a href="#" title="${Post.blogTitle}" target="_blank" >${Post.blogTitle}</a>
                        </h2>
                    </header>
                    <p class="meta">
                        <time class="time"><i class="glyphicon glyphicon-time"></i> ${Post.blogCreatTime}</time>
                        <span class="views"><i class="glyphicon glyphicon-eye-open"></i> ${Post.view}</span>
                       <%-- <a class="comment" href="${BasePath}/show/269.html#comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i> 4</a>--%>
                    </p>
                    <p class="note">${Post.standby003}</p>
                </article>
            </c:forEach>

            <nav class="pagination" style="display: none;">
                <ul>
                    <li class="prev-page"></li>
                    <li class="active"><span>1</span></li>
                    <li><a href="?page=2">2</a></li>
                    <li class="next-page"><a href="?page=2&postType=${postType}">下一页</a></li>
                    <li><span>共 2 页</span></li>
                </ul>
            </nav>
        </div>
    </div>
    <aside class="sidebar">
        <div class="fixed">
            <div class="widget widget_search">
                <form class="navbar-form" action="/Search" method="post">
                    <div class="input-group">
                        <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
                        <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span> </div>
                </form>
            </div>
            <div class="widget widget_sentence">
                <h3>标签云</h3>
                <div class="widget-sentence-content">
                    <ul class="plinks ptags">
                        <li><a href="${BasePath}/tags/list/67/" title="移动统计" draggable="false">移动统计 <span class="badge">1</span></a></li>
                        <li><a href="${BasePath}/tags/list/256/" title="404" draggable="false">404 <span class="badge">1</span></a></li>
                        <li><a href="${BasePath}/tags/list/252/" title="VS2010" draggable="false">VS2010 <span class="badge">1</span></a></li>
                        <li><a href="${BasePath}/tags/list/162/" title="杀毒软件" draggable="false">杀毒软件 <span class="badge">1</span></a></li>
                        <li><a href="${BasePath}/tags/list/133/" title="html标签" draggable="false">html标签 <span class="badge">1</span></a></li>
                        <li><a href="${BasePath}/tags/list/49/" title="循环" draggable="false">循环 <span class="badge">2</span></a></li>
                        <li><a href="${BasePath}/tags/list/22/" title="百度统计" draggable="false">百度统计 <span class="badge">2</span></a></li>
                        <li><a href="${BasePath}/tags/list/132/" title="sql" draggable="false">sql <span class="badge">6</span></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="widget widget_hot">
            <h3>最新评论文章</h3>
            <ul>
                <c:forEach items="${newReviews}" var="Review">
                    <li><a title="${Review.blogTitle}" href="#" ><span class="thumbnail">
                    <img class="thumb" data-original="" src="" alt="${Review.reviewContent}"  style="display: block;">
                </span><span class="text">${Review.blogTitle}</span><span class="muted"><i class="glyphicon glyphicon-time"></i>
                    ${Review.reviewCreattime}
                </span><span class="muted"><%--<i class="glyphicon glyphicon-eye-open"></i>--%>${Review.reviewUserName}</span></a></li>
                </c:forEach>

            </ul>
        </div>
        <div class="widget widget_sentence">

            <a href="${BasePath}/show/269.html" target="_blank" rel="nofollow" title="MZ-NetBlog主题" >
                <img style="width: 100%" src="images/ad.jpg" alt="MZ-NetBlog主题" ></a>

        </div>
        <div class="widget widget_sentence">

            <a href="http://web.muzhuangnet.com/" target="_blank" rel="nofollow" title="专业网站建设" >
                <img style="width: 100%" src="${BasePath}/upload/201610/24/201610241224221511.jpg" alt="专业网站建设" ></a>

        </div>
    </aside>
</section>
<footer class="footer">
    <div class="container">
        <p>本站[<a href="${BasePath}/" >木庄网络博客</a>]的部分内容来源于网络，若侵犯到您的利益，请联系站长删除！谢谢！Powered By [<a href="http://www.dtcms.net/" target="_blank" rel="nofollow" >DTcms</a>] Version 4.0 </p>
    </div>
    <div id="gotop"><a class="gotop"></a></div>
</footer>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ias.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>
