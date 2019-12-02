<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>客户信息管理系统 - 角色管理</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>角色管理</h3>
	<div class="actions">
		<div>
			<a class="btn btn-primary" href="RoleShowServlet1?service=roleAdd">添加角色</a>
		</div>
	</div>

<c:if test="${empty rolelist }">
	          没有用户
</c:if>
 <c:if test="${!empty rolelist }">
	<table class="list">
		<tr>
			<th>序号</th>
			<th>角色ID</th>
			<th>角色名称</th>
			<th>角色描述</th>
			<th>更新时间</th>
			<th>操作</th>
		</tr>
		<c:forEach begin="0" end="${rolelist.size()-1 }" var="i" >
			<tr>
			 <td>${i+(page-1)*5+1 }</td>
			 <td>${rolelist[i].role_id }</td>
			 <td>${rolelist[i].role_name }</td>
			 <td>${rolelist[i].remark }</td>
			 <td>${userlist[i].update_time }</td>
			 <td>
				<a class="fa fa-pencil" title="编辑" href="RoleShowServlet1?service=roleUpdate&role_id=${rolelist[i].role_id }"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" href="RoleShowServlet1?service=roleDelete&role_id=${rolelist[i].role_id }" onclick="confirmDelete(1)"></a>
			</td>
		</tr>
</c:forEach>
	</table>
</c:if>
	<div class="pager-info">
		<c:if test="${count%5==0 }">
	       <c:set var="allpage" value="${count/5 }"></c:set>
	
	</c:if>
	<c:if test="${count%5!=0}">
	           <c:set var="allpage" value="${count/5+1 }"></c:set>
	           
	</c:if>
	<fmt:parseNumber var="allpage" value="${allpage }" integerOnly="true" ></fmt:parseNumber>
		<div>共有 ${count}条记录，第${page}页/共${allpage}页 </div>
		<div>
			<ul class="pagination">
			<c:if test="${page!=1 }">
				<li class="paginate_button previous disabled }">
				<a href="RoleShowServlet1?page=${page-1}&service=roleShow">上一页</a>
				</li>
			</c:if>
			
				<li class="paginate_button active"><a href="#">${page }</a></li>
			<c:if test="${page!=allpage }">
				<li class="paginate_button next disabled">
				<a href="RoleShowServlet1?page=${page+1}&service=roleShow">下一页</a>
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
</script>
</body>
</html>