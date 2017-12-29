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
    <li><a href="#">组织架构</a></li>
    <li><a href="#">增加社团</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual">

    <div class="itab">
  	<ul>
     <li><a href="#tab1" class="selected">新增物资</a></li>
  	</ul>
    </div>

  	<div id="tab1" class="tabson">

    <div class="formtext">Hi，<b>admin</b>，欢迎您试用信息发布功能！</div>

    <form action="/back/goodsSave.do">
<%--
    private String activityTitle;
    private String activityType;
    private Date begintime;
    private Date overtime;
    private Integer peoplenum;
    private String forecastnum;
    //主办
    private String sponsor;
    private String site;
    private String activityIntroduce;
--%>
    <ul class="forminfo">
    <li><label>活动主题<b>*</b></label><input name="activityTitle" type="text" class="dfinput" value=""  style="width:350px;"/></li>
    <li><label>主办方<b>*</b></label><input name="sponsor" type="text" class="dfinput" value=""  style="width:350px;"/></li>
    <li><label>活动场地<b>*</b></label><input name="site" type="text" class="dfinput" value=""  style="width:350px;"/></li>

    <li><label>活动开始时间<b>*</b></label><input name="site" type="text" class="dfinput" value=""  style="width:350px;"/></li>
    <li><label>活动结束时间<b>*</b></label><input name="site" type="text" class="dfinput" value=""  style="width:350px;"/></li>

    <li>
        <label>预计人数<b>*</b></label>
        <div class="vocation">
            <select	class="select1" id="forecastnum" name="forecastnum">
                <option value="">--请选择--</option>
                <c:forEach items="${activityTypes}" var="Dict">
                    <option value="${Dict.value}">${Dict.value}</option>
                </c:forEach>
            </select>
        </div>
    </li>
    <li>
        <label>活动类型<b>*</b></label>
        <div class="vocation">
            <select	class="select1" id="activityType" name="activityType">
                <option value="">--请选择--</option>
                <c:forEach items="${activityTypes}" var="Dict">
                    <option value="${Dict.value}">${Dict.value}</option>
                </c:forEach>
            </select>
        </div>
    </li>
        <li><label>活动介绍<b></b></label><textarea name="standby001" id="" cols="90" class="textinput" rows="10" ></textarea></li>

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