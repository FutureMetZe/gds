<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>

    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 345
            });
            $(".select2").uedSelect({
                width: 167
            });
            $(".select3").uedSelect({
                width: 100
            });
        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">社团信息</a></li>
        <li><a href="#">社团管理</a></li>
    </ul>
</div>

<div class="formbody">


    <div id="usual1" class="usual">

        <div class="itab">
            <ul>
                <li><a href="#tab1" class="selected">新增社团</a></li>
            </ul>
        </div>

        <div id="tab1" class="tabson">

            <div class="formtext">Hi，<b><%=session.getAttribute("AdminUsername")%>
            </b>，欢迎您试用信息发布功能！
            </div>

            <form action="/back/clubUpdate.do">
                <input type="hidden" name="club_id" value="${club.club_id}"/>
                <input type="hidden" name="club_createtime" value="${club.club_createtime}"/>
                <input type="hidden" name="club_status" value="${club.club_status}"/>

                <ul class="forminfo">
                    <li><label>社团名称<b>*</b></label><input name="club_name" type="text" class="dfinput" value="${club.club_name}"
                                                          style="width:350px;"/></li>

                    <li>
                        <label>社团类别<b>*</b></label>
                        <div class="vocation">
                            <select class="select1" id="club_type" name="club_type">
                                <option value="${club.club_type}">${club.club_type}</option>
                                <c:forEach items="${clubType}" var="club">
                                    <option value="${club.value}">${club.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </li>

                    <li>
                        <label>所属学院<b>*</b></label>
                        <div class="vocation">
                            <select class="select1" id="club_faculty" name="club_faculty">
                                <option value="${club.club_faculty}">${club.club_faculty}</option>
                                <c:forEach items="${facultys}" var="faculty">
                                    <option value="${faculty.value}">${faculty.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </li>


                    <li><label>负责人姓名<b>*</b></label><input name="club_standby001" type="text" class="dfinput" value="${club.club_standby001}"
                                                           style="width:350px;"/></li>
                    <li><label>负责人学号<b>*</b></label><input name="club_standby002" type="text" class="dfinput" value="${club.club_standby002}"
                                                           style="width:350px;"/></li>
                    <li><label>社团简介<b></b></label><textarea name="club_introduce" id="" cols="90" class="textinput"
                                                            rows="10">${club.club_introduce}</textarea></li>

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
</div>
</body>
</html>
