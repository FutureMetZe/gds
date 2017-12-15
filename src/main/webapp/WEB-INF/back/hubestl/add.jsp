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
     <li><a href="#tab1" class="selected">新增会员</a></li>
  	</ul>
    </div>

  	<div id="tab1" class="tabson">

    <div class="formtext">Hi，<b>admin</b>，欢迎您试用信息发布功能！</div>

    <form action="/back/hubestl_save.do">

    <ul class="forminfo">
    <li><label>姓&nbsp;&nbsp;&nbsp;&nbsp;名<b>*</b></label><input name="name" type="text" class="dfinput" value=""  style="width:350px;"/></li>
    <li><label>电&nbsp;&nbsp;&nbsp;&nbsp;话<b>*</b></label><input name="mobile" type="text" class="dfinput" value=""  style="width:350px;"/></li>
    <li><label>学&nbsp;&nbsp;&nbsp;&nbsp;号<b>*</b></label><input name="stunum" type="text" class="dfinput" value=""  style="width:350px;"/></li>
    <li><label>职&nbsp;&nbsp;&nbsp;&nbsp;位<b>*</b></label><input name="position" type="text" class="dfinput" value=""  style="width:350px;"/></li>

    <li>
        <label>性&nbsp;&nbsp;&nbsp;&nbsp;别<b>*</b></label>
        <div class="vocation">
            <select	class="select1" id="sex" name="sex">
                <option value="">--请选择--</option>
                <c:forEach items="${sexs}" var="sex">
                    <option value="${sex.value}">${sex.value}</option>
                </c:forEach>
            </select>
        </div>
    </li>

    <li>
        <label>部&nbsp;&nbsp;&nbsp;&nbsp;门<b>*</b></label>
        <div class="vocation">
            <select	class="select1" id="department" name="department">
                <option value="">--请选择--</option>
                <c:forEach items="${departments}" var="department">
                    <option value="${department.value}">${department.value}</option>
                </c:forEach>
            </select>
        </div>
    </li>

    <li>
        <label>所属学院<b>*</b></label>
        <div class="vocation">
            <select	class="select1" id="faculty" name="faculty">
                <option value="">--请选择--</option>
                <c:forEach items="${facultys}" var="faculty">
                    <option value="${faculty.value}">${faculty.value}</option>
                </c:forEach>
            </select>
        </div>
    </li>


    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="提交"/></li>

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
