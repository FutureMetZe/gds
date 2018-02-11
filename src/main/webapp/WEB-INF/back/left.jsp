<%--
  Created by IntelliJ IDEA.
  User: MPC
  Date: 2017/12/5
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String BasePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="${BasePath}/back/css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="${BasePath}/back/js/jquery.js"></script>

    <script type="text/javascript">
        $(function(){
            //导航切换
            $(".menuson li").click(function(){
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function(){
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if($ul.is(':visible')){
                    $(this).next('ul').slideUp();
                }else{
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>目录</div>

<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="${BasePath}/back/images/leftico01.png" /></span>社联信息
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="${BasePath}/back/index.do" target="rightFrame">首页</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/hubestl_list.do" target="rightFrame">成员列表</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/goodsList.do" target="rightFrame">物资管理</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/activityList.do?plan003=0" target="rightFrame">活动管理</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/roomList.do" target="rightFrame">活动室管理</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/fileList.do" target="rightFrame">电子文件管理</a><i></i></li>
        </ul>
    </dd>

    <dd>
        <div class="title">
            <span><img src="${BasePath}/back/images/leftico02.png" /></span>社团信息
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="${BasePath}/back/stuMag.do" target="rightFrame">社员管理</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/clubList.do" target="rightFrame">社团管理</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/activityList.do?plan003=1" target="rightFrame">社团活动管理</a><i></i></li>
        </ul>
    </dd>


    <dd><div class="title"><span><img src="${BasePath}/back/images/leftico03.png" /></span>首页管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="${BasePath}/back/blogList.do" target="rightFrame">文章管理</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/postReviewList.do" target="rightFrame">留言管理</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/bannerList.do" target="rightFrame">首页轮播图</a><i></i></li>
            <li><cite></cite><a href="${BasePath}/back/dictList.do" target="rightFrame">字典管理</a><i></i></li>
        </ul>
    </dd>


    <dd><div class="title"><span><img src="${BasePath}/back/images/leftico04.png" /></span>日期管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="#">自定义</a><i></i></li>
            <li><cite></cite><a href="#">常用资料</a><i></i></li>
            <li><cite></cite><a href="#">信息列表</a><i></i></li>
            <li><cite></cite><a href="#">其他</a><i></i></li>
        </ul>

    </dd>

</dl>
</body>
</html>
