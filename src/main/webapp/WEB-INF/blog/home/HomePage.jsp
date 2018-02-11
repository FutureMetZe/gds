<%--
  Created by IntelliJ IDEA.
  User: Future
  Date: 2018/2/4
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>
    <!-- Basic Page Needs
    ================================================== -->
    <title>Home</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Mobile Specific Metas
    ================================================== -->
    <meta content="width=device-width,initial-scale=1" name="viewport">

    <!-- Favicons
    ================================================== -->
    <link rel="shortcut icon" href="images/favicon.png">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">

    <!--fonts
    ====================================================-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700%7cOswald:400,700" rel="stylesheet">
    <!--stylesheets
    ====================================================-->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/simpletextrotator.css">

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="js/jquery.min.js"></script> <!-- JQUERY -->
</head>
<body>

<!--FRONT PAGE/ SPLASH SCREEN SECTION-->

<div class="loading-screen"></div>

<div id="frontpage">
    <div class="shadow-img"></div>
    <img src="images/front-image.jpg" class="front-img img-responsive" alt ="Front-image"><!--IMAGE FOR FRONT SCREEN-->
    <h1>点击 <span class="invert">进入</span></h1><!--PROFILE NAME-->
    <h3 class="invert" style="margin-top: -10px; margin-bottom: 10px;">我的 <span class="rotate">主页</span></h3> <!--SUBTITLE IN PROFILE-->
    <div class="frontclick"><img src="images/click.png" alt="" class="img-responsive"><span class="pulse"></span></div>
</div>
<!--FRONT PAGE/ SPLASH SCREEN SECTION ENDS-->
<!--container-->
<div class="container">
    <div id="content" class="row hidden">
        <div class="col-sm-4">
            <!--namecard-->
            <div id="namecard" class="namecard">
                <div class="shadow-img"></div>
                <h1 class="maintitle">个人 <span class="invert">主页</span></h1><!--PROFILE NAME-->
                <h3 class="invert sub-maintitle">Web
                    <span class="rotate">Developer, Designer, Artist</span><!--SUBTITLE AFTET NAME-->
                </h3>
                <img id="profile-img" class="profile-img transparent" src="images/profile-thum.png" alt="profile-image"><!--PROFILE IMAGE-->
            </div><!--/#namecard-->
            <!--menu-->
            <div id="menu-container">
                <!--PAGE MENU-->
                <ul class="nav-menu no-padding">
                    <li class="nav-btn selected" title="Home" data-page="home">
                        <div class="hover-background"></div>
                        <span>基本信息</span><i class="fa fa-user fa-fw"></i>
                    </li>
                    <li class="nav-btn" id="resume-btn" title="Resume"  data-page="resume">
                        <div class="hover-background"></div>
                        <span>我的社团</span><i class="fa fa-file-text fa-fw"></i>
                    </li>
                    <li class="nav-btn folio-btn" data-filter="*" title="Portfolio" data-page="portfolio">
                        <div class="hover-background"></div>
                        <span>我的发布</span><i class="fa fa-suitcase fa-fw"></i>
                    </li>
                   <%-- <li class="nav-btn" title="Contact" id="contact-link" data-page="contact">
                        <div class="hover-background"></div>
                        <span>信息管理</span><i class="fa fa-paper-plane fa-fw"></i>
                    </li>--%>
                </ul><!--/.nav-menu __PAGE MENU ENDS-->

                <!--SOCIAL NAV MENU-->
                <div class="social-menu-container">
                    <ul >
                        <li></li>
                        <li></li>
                        <li></li>
                        <li><a href="">申请加入新社团</a></li>
                        <li><a href="">发布文章</a></li>
                    </ul>
                </div><!--/.social-menu-container-->
            </div><!--#menu-container-->
        </div>
        <div class="col-sm-8 page-segment">
            <ul class="page-container no-padding">
                <!--HOME/PROFILE PAGE-->
                <li id="home" class="selected">
                    <div class="title-container hidden">
                        <div class="shadow-img"></div>
                        <h2 class="rotate-out">Welcome To <span class="invert">My Profile</span></h2><!--HOME TITLE-->
                    </div>
                    <div class="description hidden">
                        <div class=""></div>

                        <div class="fade-text transparent">
                            <!--DESCRIPTION ON HOME-->
                            <div class="strong-text">Hello, I am <span>John Doe</span></div>
                            <div class="focus-text"><span>Web Developer & </span><span>Web Designer</span></div>
                            <p class="large-paragraph">I have ten years experience as a web/interface designer.I have a love of clean, elegant styling. I have lots of experience in the production of CSS and HTML for modern websites.</p>
                            <!--DESCRIPTION ON HOME ENDS-->
                        </div>

                        <!--ALL PERSONAL DETAILS-->
                        <h3 class="personal-info-title title">个人信息</h3>
                        <ul class="personal-info">
                            <li class="rotate-out rotated"><label>Email</label><span>${student.email}</span></li>
                            <li class="rotate-out rotated"><label>我的电话</label><span>${student.mobile}</span></li>
                            <li class="rotate-out rotated"><label>学院</label><span>${student.standby001}</span></li>
                            <li class="rotate-out rotated"><label>个性签名</label><span>${student.standby002}</span></li>
                        </ul><!--/ul.personal-info-->
                    </div>
                </li><!--/#home-->

                <!--RESUME PAGE-->
                <li id="resume" class="hidden">
                    <div class="title-container">
                        <div class="shadow-img"></div>
                        <h2 class="rotate-out rotated"><span class="invert">Resume Of</span> John Doe</h2> <!--RESUME TITLE-->
                    </div>
                    <div class="description" style="overflow: auto">

                        <div class='tabs tabs_animate'>
                            <!--RESUME TAB LISTS-->
                            <ul class='horizontal no-padding'>
                                <li><a href="#tab-1" class="icon-bg icon-skills"><div>我加入的社团</div></a></li>
                                <li><a href="#tab-2" class="icon-bg icon-education"><div>相关类型社团</div></a></li>
                                <li><a href="#tab-3" class="icon-bg icon-employment"><div>相关文章</div></a></li>
                            </ul><!--RESUME TAB LISTS ENDS-->

                            <!--RESUME FIRST TAB/SKILL TAB DETAILS-->
                            <div id='tab-1' >
                                <!--对我加入的社团遍历-->
                                <c:forEach items="${clubs}" var="Club">

                                <h3 class="title">${Club.club_name}</h3><!--SKILLS WITH BAR DISPLAY-->
                                <ul class="skills-list no-padding">
                                    <li class="row">
                                        <div class="col-xs-2"><div class="fw-mid"><h5>所属学院</h5></div></div>
                                        <div class="col-xs-9">
                                            <div cl  s="bar">
                                                <div class="percentage" id="badi" style="width: 100%;"><h5>${Club.club_faculty}</h5></div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="row">
                                        <div class="col-xs-2"><div class="fw-mid"><h5>社团类型</h5></div></div>
                                        <div class="col-xs-9">
                                            <div cl  s="bar">
                                                <div class="percentage" id="badi" style="width: 100%;"><h5>${Club.club_type}</h5></div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="row">
                                        <div class="col-xs-2"><div class="fw-mid"><h5>社团介绍</h5></div></div>
                                        <div class="col-xs-9">
                                            <div cl  s="bar">
                                                <div class="percentage" id="badi" style="width: 100%;"><h5>${Club.club_introduce}</h5></div>
                                            </div>
                                        </div>
                                    </li>
                                </ul><!--SKILLS WITH BAR DISPLAY ENDS-->
                                </c:forEach>
                            </div><!--RESUME FIRST TAB/SKILL TAB DETAILS ENDS-->

                            <!--RESUME SECOND TAB/EDUCATION TAB DETAILS-->
                            <div id='tab-2'>
                                <c:forEach items="${sameClub}" var="Club">
                                    <h3 class="title">${Club.club_name}</h3><!--SKILLS WITH BAR DISPLAY-->
                                    <ul class="skills-list no-padding">
                                        <li class="row">
                                            <div class="col-xs-2"><div class="fw-mid"><h5>所属学院</h5></div></div>
                                            <div class="col-xs-9">
                                                <div cl  s="bar">
                                                    <div class="percentage" id="badi" style="width: 100%;"><h5>${Club.club_faculty}</h5></div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="row">
                                            <div class="col-xs-2"><div class="fw-mid"><h5>社团类型</h5></div></div>
                                            <div class="col-xs-9">
                                                <div cl  s="bar">
                                                    <div class="percentage" id="badi" style="width: 100%;"><h5>${Club.club_type}</h5></div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="row">
                                            <div class="col-xs-2"><div class="fw-mid"><h5>社团介绍</h5></div></div>
                                            <div class="col-xs-9">
                                                <div cl  s="bar">
                                                    <div class="percentage" id="badi" style="width: 100%;"><h5>${Club.club_introduce}</h5></div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul><!--SKILLS WITH BAR DISPLAY ENDS-->
                                </c:forEach>
                            </div><!--RESUME SECOND TAB/EDUCATION TAB DETAILS ENDS-->
                            <!--RESUME THIRD TAB/EMPLYMENT TAB DETAILS ENDS-->
                            <div id='tab-3'>

                                <h3 class="title">EMPLOYMENT</h3>
                                <ul class="employment-class tab-cont">
                                    <c:forEach items="${samePosts}" var="Post">
                                    <li>
                                        <!-- -->
                                        <h4><a href="/blog/show.do?blogId=${Post.blogId}">${Post.blogTitle} </a><span class="year">${Post.blogCreatTime}</span></h4>
                                        <h5>${Post.blogAuthor}</h5>
                                        <p><a href="/blog/show.do?blogId=${Post.blogId}">${Post.standby003}</a></p><!--EMPLOYMENT LIST DETAILS-->
                                    </li>
                                    </c:forEach>

                                </ul>
                            </div><!--RESUME THIRD TAB/EMPLYMENT TAB DETAILS ENDS-->
                        </div>
                    </div>
                </li>
                <!--/#resume-->
                <!--PORTFOLIO PAGE-->
                <li id="portfolio" class="hidden">
                    <div class="title-container">
                        <div class="shadow-img"></div>
                        <h2 class="rotate-out rotated"><span class="invert">Resume Of</span> John Doe</h2> <!--RESUME TITLE-->
                    </div>
                    <div class="description">

                        <div class='tabs tabs_animate'>
                            <!--RESUME TAB LISTS-->
                            <ul class='horizontal no-padding'>
                                <%--<li><a href="#tab-1" class="icon-bg icon-skills"><div>Skills</div></a></li>--%>
                                <li><a href="#tab-1" class="icon-bg icon-skills"><div>我的评论</div></a></li>
                                <li><a href="#tab-3" class="icon-bg icon-employment"><div>我的文章</div></a></li>
                            </ul><!--RESUME TAB LISTS ENDS-->

                            <!--RESUME SECOND TAB/EDUCATION TAB DETAILS-->
                            <div id='tab-1'>
                                <h3 class="title">我发布的评论</h3>
                                <ul class="education-class">
                                    <c:forEach items="${myReviews}" var="Review">
                                        <li>
                                            <!--EDUCATION LIST ITEM-->
                                            <h4 class="title">文章题目:${Review.blogTitle} <i class="fa fa-sort-desc pull-right"></i></h4>
                                            <div class="list-content">
                                                <h5 class="title"><span class="list-year">${Review.reviewCreattime}}</span></h5>
                                                <p><a href="/blog/show.do?blogId=${Review.blogId}" target=”_blank">评论内容:${Review.reviewContent} </a></p>
                                            </div>
                                        </li>
                                    </c:forEach>


                                </ul>
                            </div><!--RESUME SECOND TAB/EDUCATION TAB DETAILS ENDS-->
                            <!--RESUME THIRD TAB/EMPLYMENT TAB DETAILS ENDS-->
                            <div id='tab-3'>
                                <h3 class="title">我发布的文章</h3>
                                <ul class="employment-class tab-cont">
                                    <c:forEach items="${myPosts}" var="Post">
                                        <li>
                                            <!-- -->
                                            <h4><a href="/blog/show.do?blogId=${Post.blogId}" target=”_blank">${Post.blogTitle} </a><span class="year">${Post.blogCreatTime}</span></h4>
                                            <h5>${Post.blogAuthor}</h5>
                                            <p><a href="/blog/show.do?blogId=${Post.blogId}" target=”_blank">${Post.standby003}</a></p><!--EMPLOYMENT LIST DETAILS-->
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div><!--RESUME THIRD TAB/EMPLYMENT TAB DETAILS ENDS-->

                            <!--RESUME FIRST TAB/SKILL TAB DETAILS-->
                            <div id='tab-2'>
                                <h3 class="title">OUR SKILLS</h3><!--SKILLS WITH BAR DISPLAY-->
                                <ul class="skills-list no-padding">

                                </ul><!--SKILLS WITH BAR DISPLAY ENDS-->

                                <!--SKILLS WITH CIRCLE DISPLAY-->
                                <div class="circle-skill-container">
                                    <h3 class="title">OTHER SKILLS</h3>
                                    <div class="row">
                                        <div class="col-xs-4 center-align">
                                            <div class="circle-bar" id="line-container1">
                                                <div class="progressbar-text" id="progress-text1">0</div>
                                            </div>
                                            <h5>Photoshop</h5>
                                        </div>
                                        <div class="col-xs-4 center-align">
                                            <div class="circle-bar" id="line-container2">
                                                <div class="progressbar-text" id="progress-text2">0</div>
                                            </div>
                                            <h5>Illustrator</h5>
                                        </div>
                                        <div class="col-xs-4 center-align">
                                            <div class="circle-bar" id="line-container3">
                                                <div class="progressbar-text" id="progress-text3">0</div>
                                            </div>
                                            <h5>After effect</h5>
                                        </div>
                                    </div>
                                </div><!--SKILLS WITH CIRCLE DISPLAY ENDS-->
                            </div><!--RESUME FIRST TAB/SKILL TAB DETAILS ENDS-->
                        </div>
                    </div>
                </li><!--/#portfolio-->


<!------------------------------------------以下部分不修改----------------------------------------->

                <li id="contact" class="hidden">
                    <div class="title-container" >
                        <div class="shadow-img"></div>
                        <h2 class="rotate-out rotated">Contact</h2><!--CONTACT PAGE TITLE-->
                    </div>
                    <div class="description">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="map-container">
                                    <div id="map" style="width:0%;height:0px;">

                                    </div><!--GOOGLE MAP-->
                                </div>
                            </div>
                            <div class="col-sm-5">

                            </div>
                            <div class="col-sm-7" style="width:100%;height: 1000px">
                                <div class="mail-container">
                                    <div class="cnmail result">
                                        <div class="msg success-msg"><i class="icon svg-check"><!--?xml version="1.0" encoding="utf-8"?-->  <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="32" height="32" viewBox="0 0 32 32"> <path d="M16 2.688c-7.375 0-13.313 5.938-13.313 13.313s5.938 13.313 13.313 13.313c7.375 0 13.313-5.938 13.313-13.313s-5.938-13.313-13.313-13.313zM16 28.25c-6.75 0-12.25-5.5-12.25-12.25s5.5-12.25 12.25-12.25c6.75 0 12.25 5.5 12.25 12.25s-5.5 12.25-12.25 12.25zM22.688 11.25l-8.563 8.313-3-3c-0.313-0.313-0.813-0.313-1.125 0s-0.313 0.813 0 1.125l3.563 3.563c0.125 0.125 0.313 0.188 0.563 0.188 0.188 0 0.375-0.063 0.5-0.188l9.125-8.875c0.375-0.313 0.375-0.813 0.063-1.125s-0.813-0.313-1.125 0z"></path> </svg> </i><span> You email has been stored!</span></div>
                                        <div class="msg error-msg"><i class="icon svg-close-circle"><!--?xml version="1.0" encoding="utf-8"?-->  <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="32" height="32" viewBox="0 0 32 32"> <path d="M6.563 6.563c-5.188 5.188-5.188 13.688 0 18.875s13.688 5.188 18.875 0c5.188-5.188 5.188-13.625 0-18.875-5.188-5.188-13.625-5.188-18.875 0zM24.688 24.688c-4.813 4.75-12.563 4.75-17.375 0-4.75-4.813-4.75-12.563 0-17.375 4.813-4.75 12.563-4.75 17.375 0 4.75 4.813 4.75 12.563 0 17.375zM10.75 10l-0.813 0.75 5.313 5.25-5.25 5.25 0.75 0.75 5.25-5.25 5.25 5.25 0.75-0.75-5.25-5.25 5.313-5.25-0.813-0.75-5.25 5.25z"></path> </svg> </i><span> Sorry! Something went wrong!</span></div>
                                    </div>
                                    <h3 class="title invert">Don't Forget To Mail Me</h3>
                                    <!--CONTACT FORM-->
                                    <form action="sendmail.php" class="form-horizontal" id="contact-form">

                                    </form><!--/#contact-form-->
                                </div>
                            </div>

                        </div>
                    </div>
                </li><!--/#contact-->
            </ul>

            <div class="row mobile-nav-container">
                <!--SOCIAL NAV FOR MOBILE-->
                <ul class="mobile-social no-padding">
                    <li>Connect With Me</li>
                    <li><a href="">加入社团</a></li>
                    <li><a href=""><i class="fa fa-google-plus"></i></a></li>
                    <li><a href=""><i class="fa fa-youtube"></i></a></li>
                    <li><a href=""><i class="fa fa-pinterest-p"></i></a></li>
                    <li><a href=""><i class="fa fa-linkedin"></i></a></li>
                </ul><!--/.mobile-social-->
            </div>
        </div><!--/.page-segment -->
        <!--  <h6 class="copyright-text">Copyright © 2015 John Doe</h6> --> <!--if anyone wants copyright Texts-->
    </div>
</div><!--/.container -->

<!--PORTFOLIO IMAGE MODAL LIST-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4><!--PORTFOLIO IMAGE TITLE-->
            </div>
            <div class="modal-body">
                <img src="images/folio/logs.jpg" class="img-responsive" alt="modal-image"><!--PORTFOLIO MODAL IMAGE-->
            </div>
            <div class="modal-footer">
                <div class="mf-content">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Officiis temporibus fuga sit explicabo blanditiis voluptate iste vero quia impedit? Iusto illo voluptas est praesentium veritatis magni, pariatur laboriosam voluptatem inventore.</p>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">Hover Style</h4><!--PORTFOLIO IMAGE TITLE-->
            </div>
            <div class="modal-body">
                <img src="images/folio/book.jpg" class="img-responsive" alt="modal-image"><!--PORTFOLIO MODAL IMAGE-->
            </div>
            <div class="modal-footer">
                <div class="mf-content">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel sapiente, odit, illo saepe voluptate eos enim eius autem cumque ab, soluta dolor tempore inventore eligendi maxime voluptas pariatur explicabo blanditiis?</p>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel3">Hover Style</h4><!--PORTFOLIO IMAGE TITLE-->
            </div>
            <div class="modal-body">
                <img src="images/folio/guy.jpg" class="img-responsive" alt="modal-image"><!--PORTFOLIO MODAL IMAGE-->
            </div>
            <div class="modal-footer">
                <div class="mf-content">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequuntur ratione quae, alias at. Reprehenderit, ut quis corporis laudantium, laborum sed omnis qui perspiciatis explicabo. Ipsum culpa aspernatur dolorem. Amet, quis.</p>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel4" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel4">Hover Style</h4><!--PORTFOLIO IMAGE TITLE-->
            </div>
            <div class="modal-body">
                <img src="images/folio/illustration.jpg" class="img-responsive" alt="modal-image"><!--PORTFOLIO MODAL IMAGE-->
            </div>
            <div class="modal-footer">
                <div class="mf-content">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus ab id unde veniam error et iste ut aspernatur accusantium porro molestiae voluptatibus rem, tempore inventore ad minus soluta praesentium magni?</p>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel5" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel5">Hover Style</h4><!--PORTFOLIO IMAGE TITLE-->
            </div>
            <div class="modal-body">
                <img src="images/folio/beach.jpg" class="img-responsive" alt="modal-image"><!--PORTFOLIO MODAL IMAGE-->
            </div>
            <div class="modal-footer">
                <div class="mf-content">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Numquam amet placeat porro, maxime corrupti laboriosam, quod nulla perferendis esse ipsa atque deleniti. Magni molestias, nemo illum eos, exercitationem neque incidunt.</p>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="subscribe_modal_1" tabindex="-1" role="dialog" aria-labelledby="subscribe_modal_1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h2 class="modal-title">Thank You</h2><!--PORTFOLIO IMAGE TITLE-->
            </div>
            <div class="modal-body">
                <div class="text-center mail-sucsess"><h3> <span>your mail has been sent</span></h3></div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!--javascript files
=============================================================-->
<script type="text/javascript" src="js/jQueryTween-aio-min.js"></script> <!-- JQUERY Tween Plugin -->
<script type="text/javascript" src="js/jquery.tabslet.min.js"></script> <!-- JQUERY Tab plugin-->
<script type="text/javascript" src="js/progressbar.min.js"></script> <!-- JQUERY Progressbar Plugin-->
<script type="text/javascript" src="js/jquery.simple-text-rotator.min.js"></script> <!-- JQUERY Text Rotator-->
<script type="text/javascript" src="js/bootstrap.min.js"></script> <!-- Bootstrap file-->
<script src="http://ditu.google.cn/maps/api/js?key=AIzaSyBPNkCVoBW_Jzl6x-hgGU6e7QW1QMwKles"></script>
<script type="text/javascript" src='js/isotope.pkgd.min.js'></script>
<script type="text/javascript" src="js/custom.js"></script>
</body>
</html>

