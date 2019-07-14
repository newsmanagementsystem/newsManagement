<%@ page language="java" import="java.util.*,entity.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 添加新闻导航栏 -->
  <div>
    <iframe src="<%=path %>/admin/console_element/top.jsp" scrolling="no" frameborder="0" width="100%"></iframe>
  </div>

<div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <iframe src="<%=path %>/admin/console_element/left.jsp" scrolling="no" frameborder="0" width="130px"></iframe>
  <div id="opt_area">
    <ul class="classlist">
     <c:forEach items="${requestScope.list}" var="topic">
      <li> &#160;&#160;&#160;&#160; ${topic.tname} &#160;&#160;&#160;&#160; <a href='../newspages/topic_modify.jsp?tid=${topic.tid}&tname=${topic.tname}'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/topics?opr=del&tid=${topic.tid}'>删除</a> </li>
     </c:forEach>
    </ul>
  </div>
</div>
<div id="footer">
  <%@ include file="console_element/bottom.jsp" %>
</div>
</body>
</html>
