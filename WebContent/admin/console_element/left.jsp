<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../css/admin.css" rel="stylesheet" type="text/css" />
</head>	
<body>
 <ul>
    <li><a href="<%=basePath %>ToNewsAddServlet" target="_parent">添加新闻</a></li>
    <li><a href="<%=basePath %>listNewsServlet" target="_parent">编辑新闻</a></li>
    <li><a href="<%=basePath %>admin/themeAdd.jsp" target="_parent">添加主题</a></li>
    <li><a href="<%=basePath %>listThemeServlet" target="_parent">编辑主题</a></li>
  </ul>
</body>
</html>
