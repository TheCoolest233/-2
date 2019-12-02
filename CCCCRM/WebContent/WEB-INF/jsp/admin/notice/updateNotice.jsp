<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 公告管理</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>更新公告</h3>
	<form action="NoticeServlet1?service=alterNotice&notice_id=${notice.notice_id }" method="post">
		<table class="form-table">
			<tr>
				<td>发布时间</td>
				<td colspan="3" class="control">
					<input type="date"  name="pub_time" value="${notice.pub_time }" placeholder="年/月/日">
				</td>
				<td>截止时间</td>
				<td colspan="3" class="control">
					<input type="date" name="expire_time" value="${notice.expire_time }" placeholder="年/月/日">
				</td>
			</tr>

			<tr>
				<td>主题</td>
				<td colspan="3" class="control">
					<input type="text" name="subject" value="${notice.subject }" placeholder="填写公告主题">
				</td>
				<td>通知范围</td>
				<td colspan="3" class="control" >
					<select name="receive_id">
						<option value="${notice.receive_id }">${notice.receive_id }</option>
						<option value="0">全部</option>
						<option value="1">部分</option>
					</select>
				</td>
			</tr>

			<tr>
				<td>内容</td>
				<td colspan="3" class="control">
					<textarea class="p100" name="text" placeholder="请填写公告内容">${notice.text }</textarea>
				</td>
			</tr>
		</table>
		<div class="buttons">
			<input type="hidden" value="alterNotice" name="service">
			<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
			<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
		</div>
	</form>
</div>
</body>
</html>