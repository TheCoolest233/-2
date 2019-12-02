<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 客户信息更新添加</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>更新客户</h3>
	<form action="alterCustomer?service=alterCustomer&customer_id=${customer.customer_id }" method="post">
	<table class="form-table">
		<tr>
			<td>客户姓名</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_name" value="${customer.customer_name }" placeholder="请填写姓名">
			</td>
			<td>性别</td>
			<td colspan="3" class="control">
				<input type="radio" name="customer_is_male" value="${customer.customer_is_male }" checked />男
				<input type="radio" name="customer_is_male" value="${customer.customer_is_male }" />女
			</td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td colspan="3" class="control" >
				<input type="text" name="customer_birth" value="${customer.customer_birth }" placeholder="年/月/日" >
			</td>
			<td>地址</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_address" value="${customer.customer_address }" placeholder="请填写地址">
			</td>
		</tr>
		<tr>
			<td>客户手机</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_mobile" value="${customer.customer_mobile }" placeholder="请填写手机号">
			</td>
			<td>客户座机</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_tel" value="${customer.customer_tel }" placeholder="请填写固定电话">
			</td>
		</tr>
		<tr>
			<td>客户QQ</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_qq" value="${customer.customer_qq }" placeholder="请填写QQ">
			</td>
			<td>客户微博</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_blog" value="${customer.customer_blog }" placeholder="请填写微博">
			</td>
		</tr>
		<tr>
			<td>客户邮箱</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_email" value="${customer.customer_email }" placeholder="请填写电子邮箱">
			</td>
			<td>客户职位</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_position" value="${customer.customer_position}" placeholder="请填写职位">
			</td>
		</tr>
		<tr>
			<td>客户公司</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_company" value="${customer.customer_company }" placeholder="请填写公司名称">
			</td>
			<td>客户类型ID</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_category_id" value="${customer.customer_category_id }" placeholder="请填写客户类型">
			</td>
		</tr>
		<tr>
			<td>责任员工ID</td>
			<td colspan="3" class="control">
				<input type="text" name="user_id" value="${customer.user_id }" placeholder="请填写责任员工">
			</td>
			<td>客户来源ID</td>
			<td colspan="3" class="control">
				<input type="text" name="customer_source_id" value="${customer.customer_source_id }" placeholder="请填写客户来源">
			</td>
		</tr>
		<tr>
			<td>客户备注</td>
			<td colspan="9" class="control">
				<textarea class="p100" name="customer_remark"  placeholder="请填写备注">${customer.customer_remark }</textarea>
			</td>
		</tr>
	</table>
	<div class="buttons">
		<input type="hidden" value="alterCustomer" name="service">
		<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
		<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>
	</form>
</div>
</body>
</html>