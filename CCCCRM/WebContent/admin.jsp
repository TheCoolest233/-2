<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页--客户关系管理系统</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
     
</head>
<body>

  <!--  导航 -->   
 <div class="header">
     <h1><a href="index.jsp">智游客户关系管理系统</a></h1>
      <div class="nav">
     
         <a href="#" target="">工作台</a> 
         <a href="#" target="">报表</a>
         <a href="#" target="">客户信息</a>
         <a href="#" target="">员工信息</a>
         <a href="#" target="">公告信息</a>
         <a href="#" target="">发件箱</a>
     
      </div>
     
    <div class="user">
    <a href="#">${adminUser.username}</a>
    <a href="login.jsp">退出</a>
     </div>
   
     
     
 </div>
 
 <!--左半部分  -->
 <!--页面的主体内容  -->
 <div class="main">
     <ul class="left-side">
     <!-- 菜单标题 -->
         <li class="menu-title">
         <a href="#"><i class="fa fa-users"></i>&nbsp;&nbsp;客户管理</a> 
         </li>
         <!--子列表内容  -->
         <li class="sub-menu">
         
            <ul>
               <li>
               <a target="pageBox" href="customerShow?service=customerShow" ><i class="fa fa-circle-thin">&nbsp;&nbsp;客户信息</i></a>
               </li>
               
               <li>
               <a target="pageBox" href="#" ><i class="fa fa-circle-thin">&nbsp;&nbsp;客户分配</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="#" ><i class="fa fa-circle-thin">&nbsp;&nbsp;客户关怀</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="#" ><i class="fa fa-circle-thin">&nbsp;&nbsp;客户分类</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="#" ><i class="fa fa-circle-thin">&nbsp;&nbsp;客户状态</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="#" ><i class="fa fa-circle-thin">&nbsp;&nbsp;客户来源</i></a>
               </li>
            
            </ul>
         
         </li>
         
         <!-- 第二个标题 -->
         <li class="menu-title">
         <a href="#"><i class="fa fa-file-text"></i>&nbsp;&nbsp;内部信息</a> 
         </li>
         <!--子列表内容  -->
         <li class="sub-menu">
         
            <ul>
               <li>
               <a target="pageBox" href="NoticeServlet1?service=noticeShow" ><i class="fa fa-circle-thin">&nbsp;&nbsp;通知公告</i></a>
               </li>
               
               <li>
               <a target="pageBox" href="UserServlet1?service=show" ><i class="fa fa-circle-thin">&nbsp;&nbsp;员工信息</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="#" ><i class="fa fa-circle-thin">&nbsp;&nbsp;客户关怀</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="DepartmentServlet1?service=departmentShowB" ><i class="fa fa-circle-thin">&nbsp;&nbsp;部门信息</i></a>
               </li>
               
               
            
            </ul>
         
         </li>
      <!-- 第三个标题 -->
         <li class="menu-title">
         <a href="#"><i class="fa fa-envelope"></i>&nbsp;&nbsp;站内邮件</a> 
         </li>
         <!--子列表内容  -->
         <li class="sub-menu">
         
            <ul>
               <li>
               <a target="pageBox" href="MessageServlet1?service=addMessage" ><i class="fa fa-circle-thin">&nbsp;&nbsp;写邮件</i></a>
               </li>
               
               <li>
               <a target="pageBox" href="MessageServlet1?service=messageShow" ><i class="fa fa-circle-thin">&nbsp;&nbsp;收件箱</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="MessageServlet1?service=outShow" ><i class="fa fa-circle-thin">&nbsp;&nbsp;发件箱</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="MessageServlet1?service=draftShow" ><i class="fa fa-circle-thin">&nbsp;&nbsp;草稿箱</i></a>
               </li>
               
               <li>
               <a target="pageBox" href="MessageServlet1?service=dustbinShow" ><i class="fa fa-circle-thin">&nbsp;&nbsp;垃圾箱</i></a>
               </li>
            </ul>
         
         </li>
         
         <!-- 第四个标题 -->
         <li class="menu-title">
         <a href="#"><i class="fa fa-sitemap"></i>&nbsp;&nbsp;管理员</a> 
         </li>
         <!--子列表内容  -->
         <li class="sub-menu">
         
            <ul>
               <li>
               <a target="pageBox"  href="NoticeServlet1?service=noticeShow" ><i class="fa fa-circle-thin">&nbsp;&nbsp;公告管理</i></a>
               </li>
               
               <li>
               <a target="pageBox" href= "DepartmentServlet1?service=departmentShow"><i class="fa fa-circle-thin">&nbsp;&nbsp;部门管理</i></a>
               </li>
               
                <li>
               <a target="pageBox" href="RoleShowServlet1?service=roleShow" ><i class="fa fa-circle-thin">&nbsp;&nbsp;角色管理</i></a>
               </li>
               
                <li>
               <a  target="pageBox" href="UserServlet1?service=show" >
                    <i class="fa fa-circle-thin">&nbsp;&nbsp;用户管理</i>
               </a>
               </li>
            </ul>
         
         </li>
     </ul>
     
 <!--  右半部分-->
 <div class="right-side">
 <!--内部框架标签  -->
    <iframe name="pageBox" src="welcome.jsp"></iframe>
 </div>
 
 </div>
<script type="text/javascript" src="js/admin.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.js"></script>

</body>
</html>