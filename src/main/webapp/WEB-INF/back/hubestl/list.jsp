<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery-1.11.1.min.js"></script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">管理信息</a></li>
    <li><a href="#">社员管理</a></li>
    <li><a href="#">社员列表</a></li>
    </ul>
    </div>

    <div class="rightinfo">

    <div class="tools">

    	<ul class="toolbar">
            <form action="${pageContext.request.contextPath }/back/hubestl_list.do">
                <li><label>姓名：</label><input name="name" type="text" class="dfinput" value="${name}"  style="width:110px;"/></li>&nbsp;&nbsp;
                <li><label>所属部门：</label><input name="department" type="text" class="dfinput" value="${department}"  style="width:130px;"/></li>&nbsp;&nbsp;
                <!-- 隐藏域.当前页码 -->
                <input type="hidden" name="currentPage" value="${page.currentPage}" />
                <!-- 隐藏域.每页显示条数 -->
                <input type="hidden" name="pageSize" value="${page.pageSize}" />
                <li><label>&nbsp;</label><input type="submit" class="findbtn" value="查找"/></li>
            </form>

        </ul>

        <ul class="toolbar1">
            <li onclick="forAddPage()"><span><img src="${pageContext.request.contextPath }/back/images/t01.png" /></span>新增</li>
        </ul>

    </div>

<FORM id="pageForm" name="customerForm" action="${pageContext.request.contextPath }/back/hubestl_list.do" method=post>
    <!-- 隐藏域.当前页码 -->
    <input type="hidden" name="currentPage" id="currentPageInput" value="${page.totalPage}" />
    <!-- 隐藏域.每页显示条数 -->
    <input type="hidden" name="pageSize" id="pageSizeInput"       value="${page.pageSize}" />

    <table class="tablelist">
    	<thead>
    	<tr>
        <th>内部编号<i class="sort"><img src="${pageContext.request.contextPath }/back/images/px.gif" /></i></th>
        <th>姓名</th>
        <th>性别</th>
        <th>部门</th>
        <th>学院</th>
        <th>职位</th>
        <th>电话</th>
        <th>注册时间</th>
        <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${beans}" var="Hubestl">
            <tr>
                <td>${Hubestl.id}</td>
                <td>${Hubestl.name}</td>
                <td>${Hubestl.sex}</td>
                <td>${Hubestl.department}</td>
                <td>${Hubestl.faculty}</td>
                <td>${Hubestl.position}</td>
                <td>${Hubestl.mobile}</td>
                <td>${Hubestl.createtime}</td>
                <td><a href="${pageContext.request.contextPath }/back/hubestl_edit.do?user_id=${Hubestl.id}" class="tablelink">修改</a>     <a href="${pageContext.request.contextPath }/back/hubestl_delete.do?user_id=${Hubestl.id}" class="tablelink" > 删除</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</FORM>
        <DIV style="LINE-HEIGHT: 40px; HEIGHT: 40px; TEXT-ALIGN: right">
            共[<B>${page.totalCount}</B>]条记录，共[<B>${page.totalPage}</B>]页
            ；每页显示
            <select name="pageSize" onchange="changePageSize(jQuery('#pageSizeSelect option:selected').val())" id="pageSizeSelect" >
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




    </div>
    <script type="text/javascript">
        function changePage(pageNum){
            //1 将页码的值放入对应表单隐藏域中
            jQuery("#currentPageInput").val(pageNum);
            //2 提交表单
            jQuery("#pageForm").submit();
        };

        function changePageSize(pageSize){
            //1 将页码的值放入对应表单隐藏域中
            jQuery("#pageSizeInput").val(pageSize);
            //2 提交表单
            jQuery("#pageForm").submit();
        };

        function forAddPage(){
            window.location.href="${pageContext.request.contextPath }/back/dictToAddPage.do";
        };

    </script>

    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
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


</body>
</html>
