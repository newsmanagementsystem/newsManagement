<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑新闻--管理后台</title>
<!-- 引入样式文件 -->
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<!-- 引入脚本文件 -->
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/wySilder.min.js" type="text/javascript"></script>
<script src="js/silder.js"></script>
</head>
<%
	String login = (String) session.getAttribute("login");
	if (login == null) {
		response.sendRedirect("../index.jsp");
	}
%>
<body>
	<div id="main">
		<%-- <%@ include file="admin/console_element/top.jsp" %>--%>
		<div id="header">
			<div id="welcome">
				欢迎管理员<%=session.getAttribute("login")%>使用新闻管理系统！&nbsp;&nbsp;<a
					href="/newsManagement/logoutServlet">退出</a>
			</div>
			<div id="silder" class="js-silder">
				<div class="silder-scroll">
					<div class="silder-main">
						<div class="silder-main-img">
							<img src="/newsManagement/images/d2.png" alt="">
						</div>
						<div class="silder-main-img">
							<img src="/newsManagement/images/d1.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="admin_bar">
			<div id="status"></div>
			<div id="channel"></div>
		</div>
		<div id="opt_list">
			<iframe src="<%=path%>/admin/console_element/left.jsp" scrolling="no"
				frameborder="0" width="160px" height="300px"></iframe>
		</div>
		<div id="opt_area">
			<ul class="classlist">
				<!-- 循环输出新闻列表 -->
				<c:choose>
					<c:when test="${sessionScope.newsList == null }">
						<p>当前暂无新闻</p>
					</c:when>
					<c:when test="${empty sessionScope.newsList  }">
						<p>当前暂无新闻</p>
					</c:when>
					<c:otherwise>
						<c:forEach items="${sessionScope.newsList }" var="aNew"
							varStatus="aNewStatus">
							<li>${aNew.newsTitle }<span>作者：${aNew.newsAuthor }
									&nbsp;&nbsp;<a
									href="ToNewsEditServlet?nid=${aNew.newsId }">修改</a>
									&nbsp;&nbsp;<a href="DeleteNewsServlet?nid=${aNew.newsId }">删除</a>
							</span></li>
							<c:if test="${aNewStatus.count % 5 == 0 }">
								<li><br></li>
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<li class='space'></li>
				<p align="right">
					当前页数:[1/3]&nbsp; <a href="#">下一页</a> <a href="#">末页</a>
				</p>
			</ul>
		</div>

		<!-- 引入页脚 -->
		<%@ include file="console_element/bottom.html"%>
	</div>
</body>
</html>
