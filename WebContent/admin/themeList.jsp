<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑主题--管理后台</title>
<!-- 引入样式文件 -->
<link href="./css/admin.css" rel="stylesheet" type="text/css" />
<link href="./css/index.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div id="main">
		<!-- 引入页首 -->
		<div>
			<%@ include file="console_element/top.jsp"%>
		</div>
		<!-- 插入左边栏 -->
		<div id="opt_list">
			<iframe src="admin/console_element/left.html" scrolling="no"
				frameborder="0" width="160px" height="300px"></iframe>
		</div>
		<!-- 插入中间部分 -->
		<div id="opt_area">
			<ul class="classlist">
				<c:forEach items="${requestScope.themeList}" var="theme">
					<li>${theme.themeName} &nbsp;<a
						href='./admin/themeModify.jsp?tid=${theme.themeID}&tname=${theme.themeName}'>修改</a>
						&nbsp; <a
						href='<%= basePath %>deleteThemeServlet?tid=${theme.themeID}'>删除</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div id="footer">
			<%@ include file="console_element/bottom.html"%>
		</div>
	</div>
</body>
</html>