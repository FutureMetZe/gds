<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />

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

    function forAddPage(){
        window.location.href="${pageContext.request.contextPath }/back/activityAdd.do";
    };

</script>

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">社联信息</a></li>
    <li><a href="#">活动管理</a></li>
    <li><a href="#">活动列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
            <form action="${pageContext.request.contextPath }/back/goodsList.do">
                <li><label>活动主题：</label><input name="activityTitle" type="text" class="dfinput" value="${activityTitle}"  style="width:110px;"/></li>&nbsp;&nbsp;
                <li><label>主办方：</label><input name="sponsor" type="text" class="dfinput" value="${sponsor}"  style="width:130px;"/></li>&nbsp;&nbsp;
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

<FORM id="pageForm" name="customerForm" action="${pageContext.request.contextPath }/back/goodsList.do" method=post>
    <!-- 隐藏域.当前页码 -->
    <input type="hidden" name="currentPage" id="currentPageInput" value="${page.totalPage}" />
    <!-- 隐藏域.每页显示条数 -->
    <input type="hidden" name="pageSize" id="pageSizeInput"       value="${page.pageSize}" />

    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号<i class="sort"><img src="${pageContext.request.contextPath }/back/images/px.gif" /></i></th>

        <th>活动主题</th>
        <th>主办方</th>
        <th>参与人数</th>
        <th>活动类型</th>
        <th>活动地点</th>
        <th>开始时间</th>
        <th>结束时间</th>

        <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${beans}" var="Activity">
            <tr>
                <td>${Activity.activityId}</td>
                <td>${Activity.activityTitle}</td>
                <td>${Activity.sponsor}</td>
                <td>${Activity.peoplenum}</td>
                <td>${Activity.activityType}</td>
                <td>${Activity.site}</td>
                <td>${Activity.begintime}</td>
                <td>${Activity.overtime}</td>
                <td>
                    <a href="${pageContext.request.contextPath }/back/goodEdit.do?goodsId=${Activity.activityId}" class="tablelink">修改</a>
                    <a href="${pageContext.request.contextPath }/back/goodDelete.do?goodsId=${Activity.activityId}" class="tablelink" >删除</a>
                </td>
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




    </div>


</body>
</html>
