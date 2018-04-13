<%--
  Created by IntelliJ IDEA.
  User: Future
  Date: 2018/1/28
  Time: 16:12
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
    <link rel="stylesheet" href="/blog/css/index.css" />
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
    <script src="/blog/js/wySilder.min.js" type="text/javascript"></script>
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
                                "<li><a href=\"home/goHome.do\" target=\"_blank\">个人主页</a></li>" +
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
                <h1 class="logo hvr-bounce-in"><a href="/blog/show.do?blogId=14" title="湖北二师社团之家"><img src="/blog/image/24ea.png" height="100"
                                                                                 width="100" alt="湖北二师社团之家"></a></h1>
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
            <div id="focusslide" class="carousel slide" data-ride="carousel">
                <div class="js-silder">
                    <div class="silder-scroll">
                        <div class="silder-main">
                            <c:forEach items="${banners}" var="Banner">
                                <div class="silder-main-img" >
                                   <a href="${Banner.standby002}"> <img src="${Banner.bannersImgUrl}"></a>

                                </div>
                            </c:forEach>
                            <%--<div class="silder-main-img">--%>
                                <%--<img src="/blog/images/2-1.jpg" alt="">--%>
                            <%--</div>--%>

                        </div>
                    </div>
                </div>
            </div>

            <article class="excerpt-minic excerpt-minic-index">
                <c:forEach items="${levelPosts}" var="Post">
                    <h2><span class="red">【推荐】</span><a target="_blank" href="/blog/show.do?blogId=${Post.blogId}"
                                                        title="${Post.blogTitle}">${Post.blogTitle}</a>
                    </h2>
                    <p class="note"> ${Post.standby003}</p>
                </c:forEach>
            </article>

            <!--导航-->
            <div class="title">
                <h3>最新发布</h3>
                <div class="more">
                    <c:forEach items="${blogPostType}" var="DictType">
                        <a href="#" title="${DictType.value}">${DictType.value}</a>
                    </c:forEach>
                </div>
            </div>
            <!--最新发布-->
            <c:forEach items="${newPosts}" var="Post">
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

            <!--最新文章列表分页-->
            <nav class="pagination" style="display: none;">
                <ul>
                    <li class="prev-page"></li>
                    <li class="active"><span>1</span></li>
                    <li><a href="?page=2">2</a></li>
                    <li class="next-page"><a href="?page=2">下一页</a></li>
                    <li><span>共 2 页</span></li>
                </ul>
            </nav>

        </div>
    </div>

    <aside class="sidebar">
        <div class="fixed">
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

        </div>
        <div class="widget widget_hot">

            <!--最新发布-->
            <h3>最新评论文章</h3>
            <ul>
                <c:forEach items="${newReviews}" var="Review">
                    <li><a title="${Review.blogTitle}" href="/blog/show.do?blogId=${Review.blogId}"><span
                            class="thumbnail">
                    <img class="thumb" data-original="" src="" alt="${Review.reviewContent}" style="display: block;">
                </span><span class="text">${Review.blogTitle}</span><span class="muted"><i
                            class="glyphicon glyphicon-time"></i>
                    ${Review.reviewCreattime}
                </span><span class="muted"><i
                            class="glyphicon glyphicon-eye-open"></i>${Review.reviewUserName}</span></a></li>
                </c:forEach>

                <li><a title="用DTcms做一个独立博客网站（响应式模板）" href="${BasePath}/show/269.html"><span class="thumbnail">
                    <img class="thumb" data-original="${BasePath}/upload/201610/18/201610181739277776.jpg"
                         src="${BasePath}/upload/201610/18/201610181739277776.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"
                         style="display: block;">
                </span><span class="text">用DTcms做一个独立博客网站（响应式模板）</span><span class="muted"><i
                        class="glyphicon glyphicon-time"></i>
                    2016-11-01
                </span><span class="muted"><i class="glyphicon glyphicon-eye-open"></i>88</span></a></li>

            </ul>
        </div>

        <div class="widget widget_search">
            <form class="navbar-form" action="/back/main.do" method="post" target="_blank">
                <div class="input-group">
                    <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">管理员登录</button>
            </span></div>
            </form>
        </div>
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
<script>
    $(function (){
        $(".js-silder").silder({
            auto: true,//自动播放，传入任何可以转化为true的值都会自动轮播
            speed: 20,//轮播图运动速度
            sideCtrl: true,//是否需要侧边控制按钮
            bottomCtrl: true,//是否需要底部控制按钮
            defaultView: 0,//默认显示的索引
            interval: 3000,//自动轮播的时间，以毫秒为单位，默认3000毫秒
            activeClass: "active",//小的控制按钮激活的样式，不包括作用两边，默认active
        });
    });
</script>
</body>
</html>

