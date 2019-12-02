<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 更新邮件</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>更新邮件</h3>
	<form action="MessageServlet1?service=alterMessage&message_id=${message1.message_id }" method="post">
	<table class="form-table">
		<tr>
			<td>邮件主题</td>
			<td colspan="3" class="control">
				<input type="text" name="subject" value="${message1.subject }" placeholder="填写邮件主题">
			</td>
		</tr>

		<tr>
			<td>邮件内容</td>
			<td colspan="3" class="control">
				<textarea class="p100" name="content" placeholder="请填写邮件内容">${message1.content }</textarea>
			</td>
		</tr>
		<tr>
			<td>发件人</td>
			<td colspan="3" class="control">
			<input type="text" name="sender" value="${message1.sender}" placeholder="填写发件人">
			</td>
			<td>收件人</td>
			<td colspan="3" class="control">
			<input type="text" name="receiver" value="${message1.receiver }"  placeholder="填写收件人">
			</td>
		</tr>
	</table>
	<div class="buttons">
	<input type="hidden" value="alterMessage" name="service">
		<input class="btn btn-primary va-bottom" type="submit" value="发送" name="sub">&nbsp;&nbsp;
		<input class="btn btn-primary va-bottom" type="submit" value="保存草稿" name="sub">&nbsp;&nbsp;
		<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>
	</form>
</div>
</body>
</html>