<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
    function changePage(pageNum){
        //1 将页码的值放入对应表单隐藏域中
        $("#currentPageInput").val(pageNum);
        //2 提交表单
        $("#pageForm").submit();
    };

    function changePageSize(pageSize){
        //1 将页码的值放入对应表单隐藏域中
        $("#pageSizeInput").val(pageSize);
        //2 提交表单
        $("#pageForm").submit();
    };

    function selectCustomer(cust_id,cust_name){
        //获得添加页面的window对象
        var win = window.opener;
        //获得添加页面的document对象
        var doc = win.document;
        //获得隐藏域,和 文本框,并赋值
        doc.getElementById("cust_id").value=cust_id;
        doc.getElementById("cust_name").value=cust_name;
        //关闭当前窗口
        window.close();

    };

    function forAddPage(){
        window.location.href="${pageContext.request.contextPath }/back/stuAdd.do";
    };


</script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
            <form action="${pageContext.request.contextPath }/back/stuMag.do">
                <li><label>用户名：</label><input name="username" type="text" class="dfinput" value="${username}"  style="width:110px;"/></li>&nbsp;&nbsp;
                <li><label>姓名：</label><input name="stu_name" type="text" class="dfinput" value="${stu_name}"  style="width:110px;"/></li>&nbsp;&nbsp;
                <li><label>学院：</label><input name="standby001" type="text" class="dfinput" value="${standby001}"  style="width:130px;"/></li>&nbsp;&nbsp;
                <!-- 隐藏域.当前页码 -->
                <input type="hidden" name="currentPage" value="${page.totalPage}" />
                <!-- 隐藏域.每页显示条数 -->
                <input type="hidden" name="pageSize" value="${page.pageSize}" />
                <li><label>&nbsp;</label><input type="submit" class="findbtn" value="查找"/></li>
            </form>

        </ul>
        
        
        <ul class="toolbar1">
            <li onclick="forAddPage()"><span><img src="${pageContext.request.contextPath }/back/images/t01.png" /></span>新增</li>
        </ul>
    
    </div>

<FORM id="pageForm" name="customerForm" action="${pageContext.request.contextPath }/back/stuMag.do" method=post>
    <!-- 隐藏域.当前页码 -->
    <input type="hidden" name="currentPage" id="currentPageInput" value="${page.totalPage}" />
    <!-- 隐藏域.每页显示条数 -->
    <input type="hidden" name="pageSize" id="pageSizeInput"       value="${page.pageSize}" />

    <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户名<i class="sort"><img src="${pageContext.request.contextPath }/back/images/px.gif" /></i></th>
        <th>姓名</th>
        <th>学号</th>
        <th>学院</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>注册时间</th>
        <th>上次登录时间</th>
        <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${beans}" var="Student">
         <%--   <option value="${item.dict_id}"<c:if test="${item.dict_id == custSource}"> selected</c:if>>${item.dict_item_name }</option>--%>
            <tr>

                <td>${Student.username}</td>
                <td>${Student.stu_name}</td>
                <td>${Student.stu_num}</td>
                <td>${Student.standby001}</td>
                <td>${Student.mobile}</td>
                <td>${Student.email}</td>
                <td>${Student.register_time}</td>
                <td>${Student.last_login_time}</td>
                <td><a href="${pageContext.request.contextPath }/back/stuEdit.do?user_id=${Student.user_id}" class="tablelink">修改</a>     <a href="${pageContext.request.contextPath }/back/stuDelete.do?user_id=${Student.user_id}" class="tablelink" > 删除</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</FORM>
        <DIV style="LINE-HEIGHT: 40px; HEIGHT: 40px; TEXT-ALIGN: right">
            共[<B>${page.totalCount}</B>]条记录，共[<B>${page.totalPage}</B>]页
            ；每页显示
            <select name="pageSize" onchange="changePageSize($('#pageSizeSelect option:selected').val())" id="pageSizeSelect" >
                <option value="5" <c:if test="${page.pageSize==5}">selected</c:if> >5</option>
                <option value="10" <c:if test="${page.pageSize==10}">selected</c:if> >10</option>
                <option value="20" <c:if test="${page.pageSize==20}">selected</c:if> >20</option>
            </select>
            条
            [<A href="javaScript:void(0)" onclick="changePage(${page.currentPage-1})" >前一页</A>]
            <B>1</B>
            [<A href="javaScript:void(0)" onclick="changePage(${page.currentPage+1})"  >后一页</A>]
            到
            <input type="text" size="3" id="page" name="page" value="${page.currentPage}"/>
            页

            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="提交"/></li>
        </DIV>

    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的删除 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
</html>
