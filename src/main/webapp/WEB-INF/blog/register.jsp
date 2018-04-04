<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/blog/heima/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/blog/heima/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/blog/heima/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/blog/heima/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/blog/heima/css/style.css" type="text/css" />

<script type="text/javascript">


	$(function(){
	    $("#myForm").validate({
			rules:{
				"username":{
				    "required":true
				},
				"password":{
                    "required":true,
					"rangelength":[6,12]
				},
				"repassword":{
                    "required":true,
                    "rangelength":[6,12],
                    "equalTo":"#password"
				},
				"email":{
                    "required":true,
                    email:true
				},
                "sex":{
                    "required":true
                },
                "stu_name":{
                    "required":true,
                    maxlength:10
                },
                "stu_num":{
                    "required":true,
                    digits:true,
                    rangelength:[10,12]
                },
				"mobile":{
                    "required":true,
                    digits:true,
                    range:[10000000000,20000000000]
                }

			},
			messages:{
                "username":{
                    "required":"用户名不能为空！",
                    "checkUsername":"用户名已存在"
                },
                "password":{
                    "required":"密码不能为空！",
					"rangelength":"密码长度6-12位！"
                },
                "repassword":{
                    "required":"确认密码不能为空！",
                    "rangelength":"确认密码长度6-12位！",
					"equalTo":"两次密码不一致！"
                },
                "email":{
                    "required":"邮箱不能为空！",
                    email:"非法邮箱！"
                },
                /*sex不加错误会自己找label*/
                "stu_name":{
                    "required":"姓名不能为空！",
                    maxlength:"超出长度范围！"
                },
                "stu_num":{
                    "required":"学号不能为空！",
                    digits:"学号必须是10-12位的数字！",
                    rangelength:"学号必须是10-12位的数字！"
                },
                "mobile":{
                    "required":"手机号不能为空！",
                    digits:"手机号必须为11位数字！",
                    range:"手机号必须为11位数字！"
                }
			}
        });
	});
</script>
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
				<font>会员注册</font>USER REGISTER
				<form id="myForm" class="form-horizontal" action="/blog/registerUser.do" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名" value="">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password"	name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="repassword" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="repassword" name="repassword"
								placeholder="请输入确认密码" value="">
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="stu_name" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="stu_name" name="stuName"
								placeholder="请输入姓名">
						</div>
					</div>

					<div class="form-group">
						<label for="stu_num" class="col-sm-2 control-label">学号</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="stu_num" name="stuNum"
								   placeholder="请输入学号">
						</div>
					</div>

					<div class="form-group">
						<label for="mobile" class="col-sm-2 control-label">手机</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="mobile" name="mobile"
								   placeholder="请输入手机号">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">已加入的社团：<b></b></label>
						<div class="col-sm-6">
							<select	class="form-control" id="clubId" name="clubId">
								<option value="">--请选择--  (如未加入任何社团此项可不填)</option>
								<c:forEach items="${Clubs}" var="Club">
									<option value="${Club.club_id}">${Club.club_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline">
								<input type="radio" name="sex" id="sex1" value="male" >男
							</label>
							<label class="radio-inline">
								<input type="radio" name="sex" id="sex2" value="female">女
							</label>
							<label class="error" for="sex" style="display:none ">您没有第三种选择</label>

						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control">

						</div>
						<div class="col-sm-2">
							<img src="./image/captcha.jhtml" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
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




