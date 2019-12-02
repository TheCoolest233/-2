<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<script src="Jquery/jquery.js"></script>
<script src="Jquery/jquery.validate.min.js"></script>
<script src="Jquery/messages_zh.js"></script>
	<title>客户信息管理系统 - 角色添加</title>
	<script type="text/javascript">
	$().ready(function () {
		$("#form").validate({
			rules:{
				role_name:{
					required:true,
					minlength:6,
					maxlength:12
				},
				remark:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				messages:{
					role_name:{
						required:"请输入账号"
				},
				remark:{
					required:"请输入密码"
				}
				}
			}
		})
	})
	
	
	
	</script>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>添加角色</h3>
	<form action="RoleShowServlet1?service=roleAlter" method="post" id="form">
	<table class="form-table">
		<tr>
			<td>角色名称</td>
			<td colspan="3" class="control">
				<input type="text" name="role_name" placeholder="填写角色名称">
			</td>
		</tr>

		<tr>
			<td>角色描述</td>
			<td colspan="3" class="control">
				<textarea class="p100" name="remark" placeholder="请填写角色描述"></textarea>
			</td>
		</tr>
	</table>
	<div class="buttons">
		<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
		<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>
	</form>
</div>
</body>
</html>
</body>
</html>