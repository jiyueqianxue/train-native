<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
<meta name="content-type" content="text/html; charset=utf-8">

<head>
<title>查询教师</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
	font-family: "微软雅黑" "楷体";
}

#null {
	height: 200px;
	font-size: 20px;
	color: gray;
	text-align: center;
}
</style>
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap-responsive.min.css">
<link rel="shortcut icon" href="../favicon.ico">
</head>



<body>
	<hr />
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#"><font color="Orange">zpark
						教学互动系统</font> </a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">欢迎：${sessionScope.user.username}</a>
						</li>
						<li><a href="#about">关于</a>
						</li>
						<li><a href="#contact">联系我们</a>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">功能菜单 <b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/student/queryAllTeacherAction">创建互动</a>
								</li>
								<li class="divider">ro</li>
								<li class="nav-header">其它功能</li>
								<li><a href="#">离开</a>
								</li>
							</ul></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
		<form action="${pageContext.request.contextPath}/student/vagueQueryTeacherAction" method="post" id="queryForm">

			<div class="input-append" style="padding-left:40px">
				<select class="span3" id="sele" name="choice"
					style="width: 150px;margin-left: 10px; border-radius:4px;">
					<option value="department" selected="selected">院系名称</option>
					<option value="teacher">教师姓名</option>
				</select> 
				<input value="" class="span2" type="text" placeholder="请输入名称"
					name="name"
					style="width: 250px; height: 30px;margin-left: 10px; border-radius:4px;">&nbsp;
				<button class="btn" type="submit"
					style="margin-left: 10px; border-radius:10px;">搜索</button>
			</div>
		</form>

		<table class="table table-hover" style="height: 250px;">
			<thead>

				<tr>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none; text-align: center;">教师用户名</a>
					</th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">教师姓名</a>
					</th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">所属院系</a>
					</th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">课程名称</a>
					</th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</th>

				</tr>

			</thead>

			<tbody id="tbody">
				<tr style="display: none;">
					<th colspan="8">
						<div id="null">
							<div style="margin-top: 50px">亲～没有找到符合条件的联系人呦～</div>
							<div style="font-size: 15px; margin-top: 6px">
								<a href="#" style="text-decoration: none; margin-left: 100px;">那我添加一条</a>
							</div>

						</div></th>
				<tr height="10px;">
				<tr>
					<th style="text-align: center;">yangddd</th>
					<th style="text-align: center;">杨冬冬</th>
					<th style="text-align: center;">电子信息工程学院</th>
					<th style="text-align: center;">JavaWeb</th>
					<th style="text-align: center;"><a href=" createInteract.html"
						style="text-decoration: none;">发起提问</a> &nbsp;&nbsp;&nbsp;</th>
				</tr>
				<c:forEach var='user' items='${requestScope.list}'>
					<tr height="10px;">
					<tr>
						<th style="text-align:center;">${user.username}</th>
						<th style="text-align:center,">${user.realname}</th>
						<th style="text-align:center,">${user.department}</th>
						<th style="text-align:center,">
						<c:forEach var='c' items='${user.courses}' varStatus="vs">
								${c.courseName}<c:if test="${!vs.last }">,</c:if>
							</c:forEach>
						</th>
						<th style="text-align: center;"><a
							href=" ${pageContext.request.contextPath}/student/createInteract.jsp?teacherId=${user.userId}&teacherName=${user.realname}&department=${user.department}"
							style="text-decoration: none;">发起提问</a> &nbsp;&nbsp;&nbsp;</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="row">
			<div class="pagination" style="text-align: center;">
				<ul>
					<li class="disabled"><a href="javascript:void(0)">上一页</a>
					</li>
					<li><a href="#">1</a><a href="#">2</a><a href="#">3</a><a
						href="#">4</a><a href="#">5</a>
					</li>
					<li><a href="javascript:void(0)">下一页</a>
					</li>
				</ul>
			</div>
		</div>
		<hr>
		<footer>
		<p>&copy; Company 2014</p>
		</footer>

	</div>
	<!-- /container -->
	<script type="text/javascript" src="../js/jquery-1.5.2.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.js"></script>
</body>
</html>