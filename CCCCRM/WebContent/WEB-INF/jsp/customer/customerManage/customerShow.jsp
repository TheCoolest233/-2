<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 客户列表</title>
	<link rel="stylesheet" href="css/main.css">	
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

</head>
<body>
<div class="box">
	<h3>客户列表</h3>
	<tr>
		<td>搜索内容:</td>
		<td colspan="3" class="control">
			<input type="text" name="" placeholder="请输入搜索关键词">
		</td>
		<td>搜索字段:</td>
		<td colspan="3" class="control">
			<select>
				<option>客户姓名</option>
				<option>责任员工ID</option>
				<option>客户来源ID</option>
			</select>
		</td>
		<div class="actions-right" >
			<div>
				<a class="btn btn-primary" href="#" onclick="add()" >添加客户</a>
			</div>
		</div>
	</tr>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>客户类型ID</th>
			<th>客户姓名</th>
			<th>地址</th>
			<th>客户手机</th>
			<th>客户座机</th>
			<th>客户QQ</th>
			<th>客户微博</th>
			<th>客户邮箱</th>
			<th>客户职位</th>
			<th>客户公司</th>
			<th>客户备注</th>
			<th>更新时间</th>
			<th>操作</th>

	  </tr>
	  <c:if test="${list.size()>0 }">
	 <c:forEach begin="0" end="${list.size()-1}" var="i">
		<tr>
			<td>${ i+5*(page-1)+1 } </td>		
			<td>${list[i].customer_category_id}</td>
			<td>${list[i].customer_name }</td>
			<td>${list[i].customer_address }</td>
			<td>${list[i].customer_mobile }</td>
			<td>${list[i].customer_tel }</td>
			<td>${list[i].customer_qq}</td>
			<td>${list[i].customer_blog }</td>
			<td>${list[i].customer_email}</td>
			<td>${list[i].customer_position }</td>
			<td>${list[i].customer_company }</td>
			<td>${list[i].customer_remark }</td>
			<td>${list[i].update_time }</td>
			<td>
				<a class="fa fa-pencil" title="编辑" href="updateCustomer?customer_id=${list[i].customer_id}&service=updateCustomer"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" href="deleteCustomer?customer_id=${list[i].customer_id}&service=deleteCustomer" onclick="confirmDelete(1)"></a>
			</td>
		</tr>
</c:forEach>
</c:if>
</table>
	<div class="pager-info">
	
	
		<div>共有 ${count}条记录，第 ${page }
		<c:if test="${count %5==0}">
		<c:set value="${count/5}" var="zpage"></c:set>
	</c:if>
	<c:if test="${count %5!=0}">
		<c:set value="${count/5+1}" var="zpage"></c:set>
		<fmt:parseNumber value="${count/5+1}" var="zpage" integerOnly="true"></fmt:parseNumber>
	</c:if>
		页 / 共${zpage}页 </div>
		<div>
			<ul class="pagination">
			<c:if test="${page>1 }">
				<li class="paginate_button previous disabled }">
				<a href="customerShow?page=${page-1 }&service=customerShow">上一页</a>
				</li>
				</c:if>
				<li class="paginate_button active"><a href="#">${page }</a></li>
				<c:if test="${page<zpage }">
				<li class="paginate_button next disabled">
				<a href="customerShow?page=${page+1 }&service=customerShow">下一页</a>
				</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<script src="lib/jquery/jquery.js"></script>
 <script>
function confirmDelete(user_id){
	if (confirm("确定要删除码？")) {
		alert('发送删除请求，刷新页面（不要异步）');
	}
	return false;
}
function add(){
	location.href="http://localhost:8080/Web/CustomerServlet1?service=addCustomer";
}
</script>

</body>
</html>