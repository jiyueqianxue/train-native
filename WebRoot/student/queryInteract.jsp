<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>

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
<meta name="content-type" content="text/html; charset=UTF-8">
<head>
<title>我的全部互动</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
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
	href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css">
<link rel="shortcut icon" href="../favicon.ico">
<script type="text/javascript">
function dete(project,flag,inId){
	var a=confirm("确认删除本条互动？");
	if(a){
		if(flag=='n'){
			location.href=project+"/student/deleteInteractByIdAction?interactId="+inId;
		}else{
			alert('已回复,不能删除');
		}
	}else{
	 	alert('取消删除');
	}
}
</script>
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
						<li class="active"><a href="#">欢迎：${sessionScope.user.username}</a></li>
						<li><a href="#about">关于</a></li>
						<li><a href="#contact">联系我们</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">功能菜单 <b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/student/queryAllTeacherAction">创建互动</a></li>
								<li class="nav-header">其它功能</li>
								<li><a href="#">离开</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
		<form
			action='${pageContext.request.contextPath}/student/vagueQueryInteractAction'
			method="post" id="queryForm">
			<div class="input-append" style="padding-left:40px">
				<select class="span3" id="sele"
					style="width: 150px; margin-left: 10px; border-radius:4px;"
					name="flagAnswer">
					<option value="n" selected="selected">未回复</option>
					<option value="y">已回复</option>
				</select> <select class="span3" id="sele"
					style="width: 150px;margin-left: 10px; border-radius:4px;"
					name="information">
					<option value="department" selected="selected">院系名称</option>
					<option value="teacher">教师姓名</option>
				</select> <input value="" class="span2" type="text" placeholder="请输入姓名"
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
						style="text-decoration: none; text-align: c">互动标题</a></th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">教师名称</a></th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">学生名称</a></th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">是否回复</a></th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">是否被举报</a></th>
					<th style="text-align: center;"><a href="javascript:void(0)"
						style="text-decoration: none;">操作</a></th>
				</tr>
			</thead>
			<!-- 展示数据 -->
			<tbody id="tbody">

				<c:if test='${!empty(requestScope.list)}'>
					<tr style="display: none;">
						<th colspan="8">
				</c:if>
				<div id="null">
					<div style="margin-top: 50px">亲～没有找到符合条件的互动～</div>
					<div style="font-size: 15px; margin-top: 6px">
						<a href="#" style="text-decoration: none; margin-left: 100px;">那我创建一条</a>
					</div>

				</div>
				</th>
				<tr height="10px;">
					<c:forEach var='it' items='${requestScope.list}'>
						<tr>
							<th style="text-align: center;">${it.interactName}</th>
							<th style="text-align: center;">${it.teacherName}</th>
							<th style="text-align: center;">${it.studentName}</th>
							<c:if test='${it.flagAnswer=="y"}'>
								<th style="text-align: center;">是</th>
							</c:if>
							<c:if test='${it.flagAnswer=="n"}'>
								<th style="text-align: center;">否</th>
							</c:if>
							<c:choose>
								<c:when test='${it.flagStudentAccusation=="y"}'>
									<th style="text-align: center;">是</th>
								</c:when>
								<c:when test='${it.flagStudentAccusation=="n"||empty(it.flagStudentAccusation)}'>
									<th style="text-align: center;">否</th>
								</c:when>
							</c:choose>
							<th style="text-align: center; ">
							<a href=" ${pageContext.request.contextPath}/student/queryInteractDetailAction?interactId=${it.interactId}" style="text-decoration: none;">查看详情</a> &nbsp;&nbsp;&nbsp;
						
								<a href='#'  onclick="dete('${pageContext.request.contextPath}','${it.flagAnswer}','${it.interactId}');">删除</a>
							
						
							</th>
						</tr>
					</c:forEach>
			</tbody>
		</table>

		<div class="row">
			<div class="pagination" style="text-align: center;">
				<ul>
					<li class="disabled"><a href="javascript:void(0)">上一页</a></li>
					<li><a href="#">1</a><a href="#">2</a><a href="#">3</a><a
						href="#">4</a><a href="#">5</a></li>
					<li><a href="javascript:void(0)">下一页</a></li>
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
