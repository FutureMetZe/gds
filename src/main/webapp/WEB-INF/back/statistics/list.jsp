<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${pageContext.request.contextPath }/back/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery-1.11.3.min.js"></script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">管理信息</a></li>
    <li><a href="#">数据统计</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">


<FORM id="pageForm" name="customerForm" action="${pageContext.request.contextPath }/back/dictList.do" >
    <!-- 隐藏域.当前页码 -->
    <input type="hidden" name="currentPage" id="currentPageInput" value="${page.currentPage}" />
    <!-- 隐藏域.每页显示条数 -->
    <input type="hidden" name="pageSize" id="pageSizeInput"       value="${page.pageSize}" />

    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号<i class="sort"><img src="${pageContext.request.contextPath }/back/images/px.gif" /></i></th>
        <th>类型</th>
        <th>数量</th>

        <th>操作</th>
        </tr>
        </thead>

        <tbody>

            <tr>
                <td>1</td>
                <td>社联成员数量</td>
                <td>${map.get("社联成员数量")}</td>

                <td><a href="/back/hubestl_list.do" class="tablelink">查看详情</a></td>
            </tr>
            <tr>
                <td>2</td>
                <td>物资数量</td>
                <td>${map.get("物资数量")}</td>

                <td><a href="/back/goodsList.do" class="tablelink">查看详情</a></td>
            </tr>
            <tr>
                <td>3</td>
                <td>活动数量</td>
                <td>${map.get("活动数量")}</td>

                <td><a href="/back/activityList.do" class="tablelink">查看详情</a></td>
            </tr>
            <tr>
                <td>4</td>
                <td>活动室数量</td>
                <td>${map.get("活动室数量")}</td>

                <td><a href="/back/roomList.do" class="tablelink">查看详情</a></td>
            </tr>
            <tr>
                <td>5</td>
                <td>电子文件数量</td>
                <td>${map.get("电子文件数量")}</td>

                <td><a href="/back/fileList.do" class="tablelink">查看详情</a></td>
            </tr>
            <tr>
                <td>6</td>
                <td>社团成员数量</td>
                <td>${map.get("社团成员数量")}</td>

                <td><a href="/back/stuMag.do" class="tablelink">查看详情</a></td>
            </tr>
            <tr>
                <td>7</td>
                <td>社团数量</td>
                <td>${map.get("社团数量")}</td>

                <td><a href="/back/clubList.do" class="tablelink">查看详情</a></td>
            </tr>
            <tr>
                <td>8</td>
                <td>发布文章数量</td>
                <td>${map.get("发布文章数量")}</td>

                <td><a href="/back/blogList.do" class="tablelink">查看详情</a></td>
            </tr>
            <tr>
                <td>9</td>
                <td>总留言数</td>
                <td>${map.get("总留言数")}</td>

                <td><a href="/back/postReviewList.do" class="tablelink">查看详情</a></td>
            </tr>
        </tbody>

    </table>
</FORM>





    </div>

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
