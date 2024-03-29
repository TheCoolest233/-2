<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<script src="Jquery/jquery.js"></script>
<script src="Jquery/jquery.validate.min.js"></script>
<script src="Jquery/messages_zh.js"></script>
	<title>客户管理系统 - 登录页面</title>
	<script type="text/javascript">
	$().ready(function () {
		$("#form").validate({
			rules:{
				username:{
					required:true,
					minlength:6,
					maxlength:12
				},
				password:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				messages:{
					username:{
						required:"请输入账号"
				},
				password:{
					required:"请输入密码"
				}  
				}
			}
		})
	})
	
	
	
	</script>
	<style type="text/css">
	.error{
	color: red;
	
	}
	
	
	</style>
	<link rel="stylesheet" href="css/index.css">
</head>
<body>
<div class="login">
	<img src="image/logo.png" alt="智游">
	<p>客户管理系统</p>
	<form action="login" name="for2" method="post" onsubmit="return check() ">
	<div>
		<input type="text" id="username" name="username" value="" placeholder="请输入用户名">
		
	</div>
	<c:if test="${!empty msg}">		
			${msg}
	</c:if>
	<div>
		<input type="password" id="password" name="password" value="" placeholder="请输入密码">
	</div>
	<div>
		<input type="submit" value="登录">
	</div>
	</form>
</div>
<script>
	if (window.top !== window) {
		window.top.location.reload();
	}
</script>
<script type="text/javascript">
		function check() {
			if(document.for2.username.value.length<1){
				alert("账号不能为空,请输入账号");
				return false;
			}
			if(document.for2.password.value.length<1){
				alert("密码不能为空,请输入密码");
				return false;
			}
			return true;
		}
	
	</script>
</body>
</html>