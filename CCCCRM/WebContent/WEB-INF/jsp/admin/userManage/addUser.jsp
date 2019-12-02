<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
<script src="Jquery/jquery.js"></script>
<script src="Jquery/jquery.validate.min.js"></script>
<script src="Jquery/messages_zh.js"></script>
	<title>客户信息管理系统 - 用户信息添加</title>
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
				mobile:{
					required:true,
					minlength:6,
					maxlength:12
				},
				address:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				age:{
					required:true,
					minlength:6,
					maxlength:12
				},
				tel:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				email:{
					required:true,
					minlength:6,
					maxlength:12
				},
				hobby:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				card_num:{
					required:true,
					minlength:6,
					maxlength:12
				},
				id_num:{
					required:true,
					minlength:6,
					maxlength:12					
				},
				nation:{
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
					username:{
						required:"请输入"
					},
					password:{
						required:"请输入"					
					},
					mobile:{
						required:"请输入"
					},
					address:{
						required:"请输入"					
					},
					age:{
						required:"请输入"
					},
					tel:{
						required:"请输入"					
					},
					email:{
						required:"请输入"
					},
					hobby:{
						required:"请输入"					
					},
					card_num:{
						required:"请输入"
					},
					id_num:{
						required:"请输入"				
					},
					nation:{
						required:"请输入备注"
					},
					remark:{
						required:"请输入备注"
											
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
	<h3>新增用户</h3>
	<form action="UserServlet1?service=alter" method="post" id="form">
	<table class="form-table">
		<tr>
			<td>用户名</td>
			<td colspan="3" class="control">
				<input type="text" name="username" placeholder="请填写用户名">
			</td>
			<td>密码</td>
			<td colspan="3" class="control">
				<input type="password" name="password" placeholder="请填写密码">
			</td>
		</tr>
		<tr>
			<td>部门ID</td>
			<td colspan="3" class="control" >
				<select name="department_id">
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
				<input type="radio" name="is_male" value="1" checked />男
				<input type="radio" name="is_male" value="0" />女
			</td>
			<td>手机号</td>
			<td colspan="3" class="control">
				<input type="text" name="mobile" placeholder="请填写手机号">
			</td>
		</tr>
		<tr>
			<td>地址</td>
			<td colspan="3" class="control">
				<input type="text" name="address" placeholder="请填写地址">
			</td>
			<td>年龄</td>
			<td colspan="3" class="control">
				<input type="text" name="age" placeholder="请填写年龄">
			</td>
		</tr>
		<tr>
			<td>固定电话</td>
			<td colspan="3" class="control">
				<input type="text" name="tel" placeholder="请填写固定电话">
			</td>
			<td>身份证号</td>
			<td colspan="3" class="control">
				<input type="text" name="id_num" placeholder="请填写身份证号">
			</td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td colspan="3" class="control">
				<input type="text" name="email" placeholder="请填写电子邮箱">
			</td>
			<td>爱好</td>
			<td colspan="3" class="control">
				<input type="text" name="hobby" placeholder="请填写爱好">
			</td>
		</tr>
		<tr>
			<td>学历</td>
			<td colspan="3" class="control">
				<select name="education">
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
				<input type="text" name="card_num" placeholder="请填写工资卡号">
			</td>
		</tr>
		<tr>
			<td>民族</td>
			<td colspan="3" class="control">
				<input type="text" name="nation" placeholder="请填写民族">
			</td>
			<td>婚姻状况</td>
			<td colspan="3" class="control">
				<select name="marry">
					<option value="0">未婚</option>
					<option value="1">已婚</option>
					<option value="-1">离异</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="9" class="control">
				<textarea class="p100" name="remark" placeholder="请填写备注"></textarea>
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