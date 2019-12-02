<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 更新部门</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>更新部门</h3>
	<form action="DepartmentServlet1?department_id=${department.department_id }&service=alterDepartment" method="post">
		<table class="form-table">
			<tr>
				<td>部门名称</td>
				<td colspan="3" class="control">
					<input type="text" name="department_name" value="${department.department_name}" placeholder="请输入部门名称">
				</td>
			</tr>

			<tr>
				<td>部门描述</td>
				<td colspan="3" class="control">
					<textarea class="p100" name="department_desc"  placeholder="请输入部门职责">${department.department_desc}</textarea>
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