<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 角色管理更新</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>更新角色</h3>
	<form action="RoleShowServlet1?role_id=${role.role_id }&service=roleAlter" method="post">
		<table class="form-table">
			<tr>
				<td>角色名称</td>
				<td colspan="3" class="control">
					<input type="text" name="role_name" value="${role.role_name }">
				</td>
			</tr>

			<tr>
				<td>角色描述</td>
				<td colspan="3" class="control">
					<textarea class="p100" name="remark" >${role.remark }
					       
					</textarea>
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