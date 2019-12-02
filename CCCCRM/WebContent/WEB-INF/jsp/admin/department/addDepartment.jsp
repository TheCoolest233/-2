<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
<script src="Jquery/jquery.js"></script>
<script src="Jquery/jquery.validate.min.js"></script>
<script src="Jquery/messages_zh.js"></script>
	<title>客户信息管理系统 - 部门添加</title>
	<script type="text/javascript">
	$().ready(function () {
		$("#form").validate({
			rules:{
				department_name:{
					required:true,
					minlength:6,
					maxlength:12
				},
				department_desc:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				messages:{
					department_name:{
						required:"请输入账号"
				},
				department_desc:{
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
	<h3>添加部门</h3>
	<form action="DepartmentServlet1?service=alterDepartment" method="post" id="form">
	<table class="form-table">
		<tr>
			<td>部门名称</td>
			<td colspan="3" class="control">
				<input type="text" name="department_name" placeholder="填写部门名称">
			</td>
		</tr>

		<tr>
			<td>部门描述</td>
			<td colspan="3" class="control">
				<textarea class="p100" name="department_desc" placeholder="请填写部门描述"></textarea>
			</td>
		</tr>
	</table>
	<div class="buttons">
	<input type="hidden" value="alterDepartment" name="service">
		<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
		<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>
	</form>
</div>
</body>
</html>