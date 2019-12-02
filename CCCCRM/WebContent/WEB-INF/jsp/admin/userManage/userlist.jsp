<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 用户列表</title>
	<link rel="stylesheet" href="css/main.css">	
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

</head>
<body>
<div class="box">
	<h3>用户列表</h3>
	<tr>
	
<form action="show">
	<div>
		<td>搜索内容:</td>
		<td colspan="3" class="control">
			<input type="text" name="value" placeholder="请输入搜索关键词">
		</td>
		<td>搜索字段:</td>
		<td colspan="3" class="control">
			<select name="name">
				<option>用户名</option>
				<option>员工ID</option>
			</select>
		</td>
		<input type="hidden" value="like" name="service">
		<input  type="submit" value="搜索">
	</div>
</form>
	<div class="actions-right" >
		<div>
			<a class="btn btn-primary" href="#" onclick="add()" >添加用户</a>
		</div>
	</div>
	</tr>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>部门ID</th>
			<th>角色ID</th>
			<th>手机号</th>
			<th>邮箱</th>
			<th>更新时间</th>
			<th>操作</th>

	  </tr>
	  <c:if test="${list.size()>0 }">
	 <c:forEach begin="0" end="${list.size()-1}" var="i">
		<tr>
			<td>${ i+5*(page-1)+1 } </td>		
			<td>${list[i].username}</td>
			<td>${list[i].department_id }</td>
			<td>${list[i].role_id }</td>
			<td>${list[i].mobile }</td>
			<td>${list[i].email }</td>
			<td>${list[i].update_time }</td>
			<td>
				<a class="fa fa-pencil" title="编辑" href="UserServlet1?user_id=${list[i].user_id}&service=update"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" href="UserServlet1?user_id=${list[i].user_id}&service=delete" onclick="confirmDelete(1)"></a>
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
	</c:if>
	<fmt:parseNumber value="${zpage}" var="allpage" integerOnly="true"></fmt:parseNumber>
		页 / 共${allpage}页 </div>
		<div>
			<ul class="pagination">
			<c:if test="${page>1 }">
				<li class="paginate_button previous disabled }">
				<a href="UserServlet1?page=${page-1 }&service=show">上一页</a>
				</li>
				</c:if>
				<li class="paginate_button active"><a href="#">${page }</a></li>
				<c:if test="${page<zpage }">
				<li class="paginate_button next disabled">
				<a href="UserServlet1?page=${page+1 }&service=show">下一页</a>
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
	location.href="http://localhost:8080/Web/UserServlet1?service=add";
}
</script>

</body>
</html>