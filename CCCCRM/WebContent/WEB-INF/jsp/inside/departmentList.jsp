<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 内部信息</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>部门信息</h3>
	<table class="list">
		<tr>
			<th>序号</th>
			<th>部门名称</th>
			<th>部门描述</th>
			<th>更新时间</th>
		</tr>
		<c:if test="${list.size()>0 }">
		<c:forEach begin="0" end="${list.size()-1 }" var="i">
		<tr>
			<td>${ i+5*(page-1)+1 } </td>
			<td>${list[i].department_name }</td>
			<td>${list[i].department_desc }</td>
			<td>${list[i].update_time }</td>
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
				<a href="departmentShowB?page=${page-1 }&service=departmentShowB">上一页</a>
				</li>
				</c:if>
				<li class="paginate_button active"><a href="#">${page }</a></li>
				<c:if test="${page<zpage }">
				<li class="paginate_button next disabled">
				<a href="departmentShowB?page=${page+1 }&service=departmentShowB">下一页</a>
				</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<script src="lib/jquery/jquery.js"></script>
</body>
</html>