<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 部门管理</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>部门管理</h3>
	<div class="actions">
		<div>
			<a class="btn btn-primary" href="#" onclick="add()">添加部门</a>
		</div>
	</div>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>部门名称</th>
			<th>部门描述</th>
			<th>更新时间</th>
			<th>操作</th>
		</tr>
		<c:if test="${list.size()>0 }">
		<c:forEach begin="0" end="${list.size()-1 }" var="i">
		<tr>
			<td>${ i+5*(page-1)+1 } </td>
			<td>${list[i].department_name }</td>
			<td>${list[i].department_desc }</td>
			<td>${list[i].update_time }</td>
			<td>
				<a class="fa fa-pencil" title="编辑" href="DepartmentServlet1?department_id=${list[i].department_id}&service=updateDepartment"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" href="DepartmentServlet1?department_id=${list[i].department_id}&service=deleteDepartment" onclick="confirmDelete(1)"></a>
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
				<a href="DepartmentServlet1?page=${page-1 }&service=alterDepartment">上一页</a>
				</li>
				</c:if>
				<li class="paginate_button active"><a href="#">${page }</a></li>
				<c:if test="${page<zpage }">
				<li class="paginate_button next disabled">
				<a href="DepartmentServlet1?page=${page+1 }&service=alterDepartment">下一页</a>
				</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<script src="lib/jquery/jquery.js"></script>
<script>
function confirmDelete(id){
	if (confirm("确定要删除码？")) {
		alert('发送删除请求，刷新页面（不要异步）');
	}
	return false;
}
function add(){
	location.href="http://localhost:8080/Web/DepartmentServlet1?service=addDepartment";
}
</script>
</body>
</html>