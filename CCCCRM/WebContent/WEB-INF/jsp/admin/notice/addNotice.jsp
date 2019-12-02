<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
<script src="Jquery/jquery.js"></script>
<script src="Jquery/jquery.validate.min.js"></script>
<script src="Jquery/messages_zh.js"></script>
	<title>客户信息管理系统 - 公告管理</title>
	<script type="text/javascript">
	$().ready(function () {
		$("#form").validate({
			rules:{
				pub_time:{
					required:true,
					minlength:6,
					maxlength:12
				},
				expire_time:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				subject:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				text:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				messages:{
					pub_time:{
						required:"请输入账号"
				},
				expire_time:{
					required:"请输入密码"
				}, 
				subject:{
					required:"请输入密码"
				},
				text:{
					required:"请输入密码"
				},
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
	<h3>发布公告</h3>
	<form action="NoticeServlet1?service=alterNotice" method="post" id="form">
		<table class="form-table">
			<tr>
				<td>发布时间</td>
				<td colspan="3" class="control">
					<input type="date"  name="pub_time" placeholder="年/月/日">
				</td>
				<td>截止时间</td>
				<td colspan="3" class="control">
					<input type="date" name="expire_time" placeholder="年/月/日">
				</td>
			</tr>

			<tr>
				<td>主题</td>
				<td colspan="3" class="control">
					<input type="text" name="subject" placeholder="填写公告主题">
				</td>
				<td>通知范围</td>
				<td colspan="3" class="control" >
					<select name="receive_id">
						<option value="0">全部</option>
						<option value="1">部分</option>
					</select>
				</td>
			</tr>

			<tr>
				<td>内容</td>
				<td colspan="3" class="control">
					<textarea class="p100" name="text" placeholder="请填写公告内容"></textarea>
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