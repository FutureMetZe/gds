<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual">

    <div class="itab">
  	<ul>
     <li><a href="#tab1" class="selected">修改社员信息</a></li>
  	</ul>
    </div>

  	<div id="tab1" class="tabson">

    <div class="formtext">Hi，<b><%=session.getAttribute("AdminUsername")%></b>，欢迎您试用信息发布功能！</div>

    <form action="/back/stuSave.do">

    <ul class="forminfo">
    <li><label>账&nbsp;&nbsp;&nbsp;&nbsp;号<b>*</b></label><input name="username" type="text" class="dfinput" value="${student.username}"  style="width:350px;"/></li>
    <li><label>密&nbsp;&nbsp;&nbsp;&nbsp;码<b>*</b></label><input name="password" type="text" class="dfinput" value="${student.password}"  style="width:350px;"/></li>
    <li><label>姓&nbsp;&nbsp;&nbsp;&nbsp;名<b>*</b></label><input name="stu_name" type="text" class="dfinput" value="${student.stu_name}"  style="width:350px;"/></li>
    <li><label>学&nbsp;&nbsp;&nbsp;&nbsp;号<b>*</b></label><input name="stu_num" type="text" class="dfinput" value="${student.stu_num}"  style="width:350px;"/></li>


    <li>
        <label>学&nbsp;&nbsp;&nbsp;&nbsp;院<b>*</b></label>
        <div class="vocation">
            <select	class="select1" id="standby001" name="standby001">
                <option value="">${student.standby001}</option>
                <c:forEach items="${facultys}" var="faculty">
                    <option value="${faculty.value}">${faculty.value}</option>
                </c:forEach>
            </select>
        </div>
    </li>

        <li><label>电&nbsp;&nbsp;&nbsp;&nbsp;话<b></b></label><input name="mobile" type="text" class="dfinput" value="${student.mobile}"  style="width:350px;"/></li>
        <li><label>邮&nbsp;&nbsp;&nbsp;&nbsp;箱<b></b></label><input name="email" type="text" class="dfinput" value="${student.email}"  style="width:350px;"/></li>

    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="修改并保存"/></li>

    </ul>

    </form>
    </div>

	<script type="text/javascript">
      $("#usual1 ul").idTabs();
    </script>

    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>





    </div>

</body>
</html>
