<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 更新用户信息</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>更新用户</h3>
	<form action="UserServlet1?user_id=${user.user_id }&service=alter" method="post">
	<table class="form-table">
		<tr>
			<td>用户名</td>
			<td colspan="3" class="control">
				<input type="text" name="username" value="${user.username }" placeholder="请填写用户名">
			</td>
			<td>密码</td>
			<td colspan="3" class="control">
				<input type="password" name="password" value="${user.password }" placeholder="请填写密码">
			</td>
		</tr>
		<tr>
			<td>部门ID</td>
			<td colspan="3" class="control" >
				<select name="department_id">
					<option value="${user. department_id}">${user. department_id}</option>
					<option value="10">董事会</option>
					<option value="20">行政部</option>
					<option value="30">财务部</option>
					<option value="40">人事部</option>
					<option value="50">技术部</option>
				</select>
			</td>
			<td>角色ID</td>
			<td colspan="3" class="control" >
				<select name="role_id">
					<option value="${user. role_id}">${user. role_id}</option>
					<option value="1110">董事长</option>
					<option value="1120">总经理</option>
					<option value="1210">行政总监</option>
					<option value="1300">财务总监</option>
					<option value="1410">人事部主任</option>
					<option value="1510">技术总监</option>
					<option value="1530">高级软件工程师</option>
					<option value="1531">中级软件工程师</option>
					<option value="1532">初级软件工程师</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td colspan="3" class="control">
				<input type="radio" name="is_male" value="${user.is_male}" checked />男
				<input type="radio" name="is_male" value="${user.is_male}" />女
			</td>
			<td>手机号</td>
			<td colspan="3" class="control">
				<input type="text" name="mobile" value="${user.mobile}" placeholder="请填写手机号">
			</td>
		</tr>
		<tr>
			<td>地址</td>
			<td colspan="3" class="control">
				<input type="text" name="address" value="${user.address }" placeholder="请填写地址">
			</td>
			<td>年龄</td>
			<td colspan="3" class="control">
				<input type="text" name="age" value="${user.age }" placeholder="请填写年龄">
			</td>
		</tr>
		<tr>
			<td>固定电话</td>
			<td colspan="3" class="control">
				<input type="text" name="tel" value="${user.tel }" placeholder="请填写固定电话">
			</td>
			<td>身份证号</td>
			<td colspan="3" class="control">
				<input type="text" name="id_num" value="${user.id_num }" placeholder="请填写身份证号">
			</td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td colspan="3" class="control">
				<input type="text" name="email" value="${user.email }" placeholder="请填写电子邮箱">
			</td>
			<td>爱好</td>
			<td colspan="3" class="control">
				<input type="text" name="hobby" value="${user.hobby }" placeholder="请填写爱好">
			</td>
		</tr>
		<tr>
			<td>学历</td>
			<td colspan="3" class="control">
				<select name="education">
					<option value="${user.education }">${user.education }</option>
					<option value="1">小学</option>
					<option value="2">初中</option>
					<option value="3">高中</option>
					<option value="4">专科</option>
					<option value="5">本科</option>
					<option value="6">硕士</option>
					<option value="7">博士</option>
				</select>
			</td>
			<td>工资卡号</td>
			<td colspan="3" class="control">
				<input type="text" name="card_num" value="${user.card_num }" placeholder="请填写工资卡号">
			</td>
		</tr>
		<tr>
			<td>民族</td>
			<td colspan="3" class="control">
				<input type="text" name="nation" value="${user.nation }" placeholder="请填写民族">
			</td>
			<td>婚姻状况</td>
			<td colspan="3" class="control">
				<select name="marry">
					<option value="${user.marry }">${user.marry }</option>
					<option value="0">未婚</option>
					<option value="1">已婚</option>
					<option value="-1">离异</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="9" class="control">
				<textarea class="p100" name="remark" value="${user.remark }" placeholder="请填写备注"></textarea>
			</td>
		</tr>
	</table>
	<div class="buttons">
		<input type="hidden" value="alter" name="service">
		<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
		<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>
	</form>
</div>
</body>
</html>