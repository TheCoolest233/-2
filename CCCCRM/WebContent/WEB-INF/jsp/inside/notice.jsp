<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h3>通知公告</h3>
<c:if test="${list.size()<=0 }">
	          没有公告
</c:if>
 <c:if test="${list.size()>0 }">
	<table class="list">
		<tr>
			<th>序号</th>
			<th>公告人</th>
			<th>公告主题</th>
			<th>通知范围</th>
			<th>公告内容</th>
			<th>发布时间</th>
			<th>截止时间</th>

		</tr>
		<c:forEach begin="0" end="${list.size()-1 }" var="i">
		<tr>
			<td>${i+5*(page-1)+1  }</td>
			<td>${adminUser.username}</td>
			<td>${list[i].subject }</td>
			<td>${list[i].receive_id }</td>
			<td>${list[i].text }.</td>
			<td>${list[i].pub_time }</td>
			<td>${list[i].expire_time }</td>
		</tr>
		</c:forEach>
	</table>
</c:if>
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
				<a href="NoticeServlet1?page=${page-1 }&service=notice">上一页</a>
				</li>
				</c:if>
				<li class="paginate_button active"><a href="#">${page }</a></li>
				<c:if test="${page<zpage }">
				<li class="paginate_button next disabled">
				<a href="NoticeServlet1?page=${page+1 }&service=notice">下一页</a>
				</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>

<script src="lib/jquery/jquery.js"></script>
</body>
</html>