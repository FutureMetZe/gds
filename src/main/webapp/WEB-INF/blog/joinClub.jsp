<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>申请加入新社团</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/blog/heima/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/blog/heima/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/blog/heima/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/blog/heima/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/blog/heima/css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}
.error{
	color:red;
}
.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>



	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>申请加入新社团</font>USER REGISTER
				<form id="myForm" class="form-horizontal" action="/blog/home/sendJoin.do"  style="margin-top: 5px;">

					<input type="hidden" name="studentNum" value="${Student.stuNum}">

					<label style="color: red"><%=request.getSession().getAttribute("joinMessage")==null?"":request.getSession().getAttribute("joinMessage")%></label>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">申请加入社团：<b></b></label>
						<div class="col-sm-6">
							<select	class="form-control" id="clubId" name="clubId">
								<option value="">--请选择--</option>
								<c:forEach items="${Clubs}" var="Club">
									<option value="${Club.club_id}">${Club.club_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>


					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control">

						</div>
						<div class="col-sm-2">
							<img src="/blog/image/captcha.jhtml" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="提交申请" name="submit"
								style="background: url('http://localhost:8080/blog/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>



</body>
</html>




