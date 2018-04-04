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
<body class="user-select single">
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
            <header class="article-header">
                <h1 class="article-title"><a href="#" title="${POST.blogTitle}">${POST.blogTitle}</a></h1>
                <div class="article-meta"> <span class="item article-meta-time">
          <time class="time" data-toggle="tooltip" data-placement="bottom" title=""
                data-original-title="${POST.blogCreatTime}"><i
                  class="glyphicon glyphicon-time"></i> ${POST.blogCreatTime}</time>
          </span> <span class="item article-meta-source" data-toggle="tooltip" data-placement="bottom" title=""
                        data-original-title="来源：${POST.blogAuthor}"><i
                        class="glyphicon glyphicon-globe"></i> ${POST.blogAuthor}</span>
                    <span class="item article-meta-views" data-toggle="tooltip" data-placement="bottom" title=""
                          data-original-title="浏览量：${POST.view}"><i
                            class="glyphicon glyphicon-eye-open"></i> ${POST.view}</span>
                    <span class="item article-meta-comment" data-toggle="tooltip" data-placement="bottom" title=""
                          data-original-title="评论量"><i class="glyphicon glyphicon-comment"></i> 99999999</span></div>
            </header>
            <article class="article-content">
                <p><img data-original="${BasePath}/upload/201610/18/201610181557196870.jpg" src=""
                        alt="${POST.standby003}"/></p>
                <p>
                    ${POST.blogContent}
                </p>
                <%--<pre class="prettyprint lang-cs">代码示例：
        public static double JieCheng(int number)
        {
            if (number == 0)
            {
                return 0;
            }

            //初始值必须设置为1
            double result = 1;

            for (int i = number; i &gt;= 1; i--)
            {
                result = result*i;
            }
            return result;
        }</pre>--%>
                <div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#"
                                                                                                  class="bds_qzone"
                                                                                                  data-cmd="qzone"
                                                                                                  title="分享到QQ空间"></a><a
                        href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq"
                                                                                           data-cmd="tqq"
                                                                                           title="分享到腾讯微博"></a><a
                        href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_tieba"
                                                                                           data-cmd="tieba"
                                                                                           title="分享到百度贴吧"></a><a
                        href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a></div>

                <script>                  window._bd_share_config = {
                    "common": {
                        "bdSnsKey": {},
                        "bdText": "",
                        "bdMini": "2",
                        "bdMiniList": false,
                        "bdPic": "",
                        "bdStyle": "1",
                        "bdSize": "32"
                    }, "share": {}
                };
                with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];</script>
            </article>
            <div class="article-tags">
                标签：<a href="#" rel="tag">DTcms博客</a>
            </div>
            <div class="relates">
                <div class="title">
                    <h3>推荐文章</h3>
                </div>
                <ul>
                    <c:forEach items="${levelPosts}" var="Post">
                        <li><a href="#" title="">${Post.blogTitle}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="title" id="comment">
                <h3>评论</h3>
            </div>
            <div id="respond">
                <form id="comment-form" name="comment-form" action="/blog/submitReview.do">
                    <div class="comment">
                        <input type="hidden" name="standby002" id="pageSizeInput" value="${POST.blogAuthor}"/>
                        <input type="hidden" name="standby001" id="standby001" value="${POST.blogSort}"/>
                        <input type="hidden" name="blogTitle" id="blogTitle" value="${POST.blogTitle}"/>
                        <input type="hidden" name="blogId" id="blogId" value="${POST.blogId}"/>
                        <div class="comment-box">
                            <textarea placeholder="您的评论或留言（必填）" name="reviewContent" id="reviewContent" cols="100%"
                                      rows="5" tabindex="3"></textarea>
                            <div class="comment-ctrl">

                                <button type="submit" name="submit" id="submit" tabindex="5">评 论</button>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
            <!--留言板-->
            <div id="postcomments">
                <ol id="comment_list" class="commentlist">
                    <c:forEach items="${Reviews}" var="Review">
                        <li class="comment-content"><span class="comment-f"></span>
                            <div class="comment-main"><p><a class="address" href="${BasePath}/" rel="nofollow"
                                                            target="_blank">${Review.reviewUserName}</a><span
                                    class="time">${Review.reviewCreattime}</span><br>${Review.reviewContent}</p></div>
                        </li>
                    </c:forEach>

                    <li class="comment-content"><span class="comment-f"></span>
                        <div class="comment-main"><p><a class="address" href="${BasePath}/" rel="nofollow"
                                                        target="_blank">木庄网络博客</a><span class="time">(2016/10/28 11:41:03)</span><br>不错的网站主题，看着相当舒服
                        </p></div>
                    </li>
                    <li class="comment-content"><span class="comment-f"></span>
                        <div class="comment-main"><p><a class="address" href="${BasePath}/" rel="nofollow"
                                                        target="_blank">木庄网络博客</a><span class="time">(2016/10/14 21:02:39)</span><br>博客做得好漂亮哦！
                        </p></div>
                    </li>
                </ol>
            </div>
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
                <form class="navbar-form" action="/Search" method="post">
                    <div class="input-group">
                        <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字"
                               maxlength="15" autocomplete="off">
                        <span class="input-group-btn">
            <button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
            </span></div>
                </form>
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
                </span><span class="muted"><i
                        class="glyphicon glyphicon-eye-open"></i>${Review.reviewUserName}</span></a></li>
            </c:forEach>

            </ul>
        </div>
        <div class="widget widget_sentence">

            <a href="#" target="_blank" rel="nofollow" title=社团招新">
                <img style="width: 100%" src="/blog/image/24ea.png" alt="社团招新"></a>

        </div>
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
