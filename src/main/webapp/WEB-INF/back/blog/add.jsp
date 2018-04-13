<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>wangEditor DEMO</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <!--引入 fontawesom-4.2.0-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/back/editor2/fontawesome-4.2.0/css/font-awesome.min.css">
    <!--[if IE]>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/back/editor2/fontawesome-4.2.0/css/font-awesome-ie7.min.css">
    <![endif]-->

    <!--引入wangEditor.css-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/back/editor2/css/wangEditor-1.1.0-min.css">

    <style type="text/css">
        body {
            padding: 0px 10px 0px 10px;
            color: #333333;
        }
    </style>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页配置</a></li>
        <li><a href="#">文章管理</a></li>
        <li><a href="#">文章发布</a></li>
    </ul>
</div>



    <div class="formbody">


        <div id="usual1" class="usual">


            <div class="formtext">Hi，<b><%=session.getAttribute("AdminUsername")%></b>，欢迎您试用信息发布功能！</div>


            <ul class="forminfo">

                <form action="/back/imgUpload.do" method="post" enctype="multipart/form-data">
                    <li><label>选择标题图:</label>
                        <input name="file" type="file"  /><input type="submit" value="上传" ></li>

                </form>

                <form action="/back/postSave.do" id="myform">
                    <!-- 作者姓名，作者账户 -->
                    <input type="hidden" name="blogAuthor" value="<%=session.getAttribute("AdminName")%>" />
                    <input type="hidden" name="standby001" value="<%=session.getAttribute("AdminUsername")%>" />
                    <li><label>图片地址<b>*</b></label><input name="imgUrl" type="text" class="dfinput" value="${filePath}"
                                                        style="width:350px;"/></li>
                <li><label>文章题目<b>*</b></label><input name="blogTitle" type="text" class="dfinput" value=""
                                                      style="width:350px;"/></li>
                <li><label>主题<b>*</b></label><input name="standby003" type="text" class="dfinput" value=""
                                                    style="width:350px;"/></li>
                <li><label>文章推荐级别<b>*</b></label><input name="blogLevel" type="text" class="dfinput" value="0"
                                                        style="width:350px;"/></li>
                <li>
                    <label>文章所属分类<b>*</b></label>
                    <div class="vocation">
                        <select class="dfinput" id="blogSort" name="blogSort">
                            <option value="">-- 请选择 --</option>
                            <c:forEach items="${postType}" var="club">
                                <option value="${club.value}">${club.value}</option>
                            </c:forEach>
                        </select>
                    </div>
                </li>

                <li>
                    <label>相关社团类型<b>*</b></label>
                    <div class="vocation">
                        <select class="dfinput" id="standby002" name="standby002">
                            <option value="">-- 请选择 --</option>
                            <c:forEach items="${clubType}" var="faculty">
                                <option value="${faculty.value}">${faculty.value}</option>
                            </c:forEach>
                        </select>
                    </div>
                </li>

            </ul>


            <script type="text/javascript">
                $("#usual1 ul").idTabs();
            </script>

            <script type="text/javascript">
                $('.tablelist tbody tr:odd').addClass('odd');
            </script>


        </div>
    </div>

    <div id='txtDiv' style='border:1px solid #cccccc; height:240px;'>
        <p>请输入内容...</p>
    </div>


    <div style='margin-top:10px;'>
        <%--<button id='btnHtml'>查看html</button>--%>
        <%--<button id='btnText'>查看text</button>--%>
        <%--<button id='btnHide'>隐藏</button>--%>
        <textarea id='textarea' name='blogContent' style='width:100%; height:100px; margin-top:10px;' type="hidden"></textarea>
    </div>
    <li><label>&nbsp;</label><input id="btnHtml" type="submit" class="btn" value="提交"/></li>
</form>
<!--引入 jquery.js-->
<script src="${pageContext.request.contextPath }/back/editor2/js/jquery-1.10.2.min.js" type="text/javascript"></script>

<!--引入 wangEditor.js-->
<script type="text/javascript"
        src='${pageContext.request.contextPath }/back/editor2/js/wangEditor-1.1.0-min.js'></script>
<script type="text/javascript">
    $(function () {
        $('#spanTime').text((new Date()).toString());

        //一句话，即可把一个div 变为一个富文本框！o(∩_∩)o
        var $editor = $('#txtDiv').wangEditor();

        //显示 html / text
        var $textarea = $('#textarea'),
            $btnHtml = $('#btnHtml'),
            $btnText = $('#btnText'),
            $btnHide = $('#btnHide');
        $textarea.hide();
        $btnHtml.click(function () {
            $textarea.show();
            $textarea.val($editor.html());
            $("#myform").submit();    //提交ID为myform的表单
        });
        $btnText.click(function () {
            $textarea.show();
            $textarea.val($editor.text());
        });
        $btnHide.click(function () {
            $textarea.hide();
        });
    });
</script>
</body>
</html>