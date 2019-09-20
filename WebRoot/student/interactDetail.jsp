<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<style type="text/css">
ul {
	list-style-type: none;
}

#star {
	position: relative;
	width: 600px;
	margin: 10px auto;
}

#star ul,#star span {
	float: left;
	display: inline;
	height: 20px;
	line-height: 19px;
}

#star ul {
	margin: 0 10px;
}

#pf li {
	float: left;
	height: 20px;
	width: 20px;
	text-indent: -9999px;
	background-image: url("../img/star.png");
	background-position: 1px 20px;
}

#star li {
	float: left;
	width: 30px;
	cursor: pointer;
	text-indent: -9999px;
	background: url(../img/star.png) no-repeat;
}

#star strong {
	color: #f60;
	padding-left: 10px;
}

#star li.on {
	background-position: 0 -28px;
}

#star p {
	position: absolute;
	top: 20px;
	width: 159px;
	height: 60px;
	display: none;
	background: url(../img/icon.gif) no-repeat;
	padding: 7px 10px 0;
}

#star p em {
	color: #f60;
	display: block;
	font-style: normal;
}
</style>
<title>互动详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script charset="utf-8" src="../lang/zh_CN.js"></script>
<script type="text/javascript" src="../js/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>

<link rel="stylesheet" type="text/css"
	href="../css/bootstrap-responsive.min.css">
<link rel="shortcut icon" href="../favicon.ico">



<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
	font-family: "微软雅黑" "楷体";
}
</style>
<script type="text/javascript">
	function sumbb() {
		var text = document.getElementById('textareas').value;
		if(text==''){
		alert("请您填好内容再提交");
		return false;}
		else {return true;}
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
						<li><a href="#" style="color: white;">欢迎：${sessionScope.user.username
								}</a>
						</li>
						<li><a href="#about">关于</a>
						</li>
						<li><a href="#contact">联系我们</a>
						</li>
						<li class="dropdown active"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown">功能菜单 <b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath}/student/queryAllTeacherAction">创建互动</a>
								</li>
								<li class="nav-header">其它功能</li>
								<li><a href="#">修改密码</a>
								</li>
								<li><a href="../logout">离开</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container" style="width: 800px">
		<h3>互动详情</h3>
		<form class="form-horizontal form-actions" action="#" method="post"
			id="for" onsubmit="">
			<table cellpadding="5px">
				<tr>
					<td>
						<div style="font-size: 18px; margin-left: 100px; ">互动标题:</div></td>
					<td>
						<div style="font-size: 15px;  margin-left: 25px">${it.interactName}</div>
					</td>
				</tr>

				<tr>
					<td>
						<div style="font-size: 18px; margin-left: 100px">创建时间:</div></td>
					<td>
						<div style="font-size: 15px; margin-left: 25px">${it.createDate}</div>
					</td>
				</tr>
				<tr>
					<td>
						<div style="font-size: 18px; margin-left: 100px">教师名称:</div></td>
					<td>
						<div style="font-size: 15px;margin-left: 25px">${it.teacherName}</div>
					</td>
				</tr>
				<tr>
					<td>
						<div style="font-size: 18px; margin-left: 100px">学生名称:</div></td>
					<td>
						<div style="font-size: 15px; margin-left: 25px">${it.studentName
							}</div></td>
				</tr>
				<tr>
					<td style="width: 230px">
						<div style="font-size: 18px; margin-left: 100px;">问题详情内容:</div></td>
					<td>
						<div style="font-size: 15px;margin-left: 25px" id="interactDe">
							<strong>${it.interactDetail }</strong>
						</div></td>
				</tr>


				<tr>
					<td style="width: 230px">
						<div style="font-size: 18px; margin-left: 100px;">教师回复内容:</div></td>
					<td>
						<div style="font-size: 15px; margin-left: 25px">${it.answerContent
							}</div>
					</td>
				</tr>

				<tr>
					<td style="width: 230px">
						<div style="font-size: 18px; margin-left: 100px;">互动评价:</div></td>
					<td>
						<div style="font-size: 15px; margin-left: 25px">
							<div id="jbnr">${it.estimateContent }</div>
						</div></td>
				</tr>
				<tr>
					<td style="width: 230px">
						<div style="font-size: 18px; margin-left: 100px;">举报原因:</div></td>
					<td>
						<div style="font-size: 15px; margin-left: 25px">${it.studentAccusationContent
							}</div>
					</td>
				</tr>
				<tr>
					<td style="width: 230px;">
						<div style="font-size: 18px; margin-left: 100px;">分数</div></td>
					<td>

						<div>
							<strong style="color: red; margin-left: 27px">${it.score
								}</strong>

						</div></td>
				</tr>
			</table>
		</form>
		<hr style="border-bottom-color: gray;">
		<form class="form-horizontal form-actions"
			action="${pageContext.request.contextPath}/student/estimateAccusationUpdateAction?interactId=${it.interactId}"
			onsubmit='return sumbb();' method="post" >
			<input name="interactId" value="${it.interactId}" id="score"
				type="hidden" /> <input type="radio"
				<c:if test='${it.flagAnswer=="n"||it.flagEstimate=="y"||it.flagStudentAccusation=="y"}'>disabled</c:if>
				style="margin-left:10%; margin-bottom:5px;" id="evaluate"
				name="select" value="estimate"></input> 评价 <input type="radio"
				<c:if test='${it.date<=7||it.flagAnswer=="y"||it.flagStudentAccusation=="y"}'>disabled</c:if>
				style="margin-left:5%;margin-bottom:5px;" id="accusaction"
				name="select" value="accusation"></input> 举报 <input type="radio"
				<c:if test='${it.flagAnswer=="y"||it.flagStudentAccusation=="y"}'>disabled</c:if>
				style="margin-left:5%;margin-bottom:5px;" id="update" name="select"
				value="update"></input> 修改

			<div style="margin-left: 10%;">
				<textarea id="textareas" name="content"
					style="width:66%; height:150px;"></textarea>
			</div>
			<input type="submit" value="提交" class="btn" id="submit"
				style="margin-left: 10%; width:15%;" /> <input type="reset"
				value="重置" class="btn" id="reset"
				style=" margin-left: 30%;width:15%" />
		</form>

		<div class="alert alert-error" id="error">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>错误! </strong><span id="erroSpan"> 错误信息提示</span>
		</div>

		<div class="alert alert-success" id="success">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>消息! </strong> 保存成功
		</div>
		<hr>
		<footer>
			<p>&copy; Company 2014</p>
		</footer>

	</div>
	<!-- /container -->
</body>
</html>

