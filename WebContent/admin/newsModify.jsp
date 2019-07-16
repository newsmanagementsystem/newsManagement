<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<script type="text/javascript">
	function check(){
		var ntitle = document.getElementById("ntitle");
		var nauthor = document.getElementById("nauthor");
		var nsummary = document.getElementById("nsummary");
		var ncontent = document.getElementById("ncontent");
		
		if(ntitle.value == ""){
			alert("标题不能为空！！");
			ntitle.focus();
			return false;
		}else if(nauthor.value == ""){
			alert("作者不能为空！！");
			nauthor.focus();
			return false;
		}else if(nsummary.value == ""){
			alert("摘要不能为空！！");
			nsummary.focus();
			return false;
		}else if(ncontent.value == ""){
			alert("内容不能为空！！");
			ncontent.focus();
			return false;
		}		
		return true;
	}
</script>
<html>
<head>
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
<body>
	<!-- 添加新闻导航栏 -->
	<div id="main">
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
			<iframe src="<%=path %>/admin/console_element/left.jsp" scrolling="no" frameborder="0" width="160px" height = "300px"></iframe>
			<%-- <ul>
				<li><a href="<%=basePath %>ToNewsAddServlet" target="_parent">添加新闻</a></li>
				<li><a href="<%=basePath %>listNewsServlet" target="_parent">编辑新闻</a></li>
				<li><a href="<%=basePath %>admin/themeAdd.jsp" target="_parent">添加主题</a></li>
				<li><a href="<%=basePath %>listThemeServlet" target="_parent">编辑主题</a></li>
			</ul>--%>
		</div>
		<div id="opt_area">
			<h1 id="opt_type">编辑新闻：</h1>
			<form action="UpdateNewsServlet?nid=${news.newsId}" method="post"
				onsubmit="return check()">
				<p>
					<label> 主题 </label> <select name="ntid">
						<c:forEach items="${requestScope.themeList}" var="topic">
							<c:choose>
								<c:when test="${news.themeId == topic.themeID}">
									<option value="${topic.themeID}" selected="selected">${topic.themeName}</option>
								</c:when>
								<c:otherwise>
									<option value='${topic.themeID}'>${topic.themeName}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</p>
				<p>
					<label> 标题 </label> <input name="ntitle" id="ntitle" type="text"
						class="opt_input" value="${news.newsTitle}" />
				</p>
				<p>
					<label> 作者 </label> <input name="nauthor" id="nauthor" type="text"
						class="opt_input" value="${news.newsAuthor}" />
				</p>
				<p>
					<label> 摘要 </label>
					<textarea name="nsummary" id="nsummary" cols="40" rows="3">${news.newsSummary}</textarea>
				</p>
				<p>
					<label> 内容 </label>
					<textarea name="ncontent" id="ncontent" cols="70" rows="10">${news.newsContent}</textarea>
				</p>
				<p>
					<label> 上传图片 </label> <input name="file" id="file" type="file"
						class="opt_input" />
				</p>
				<input type="submit" value="提交" class="opt_sub" /> <input
					type="reset" value="重置" class="opt_sub" />
			</form>

		</div>
	</div>
	<%--
	request.removeAttribute("news");
	request.removeAttribute("topics");
--%>
	<%@ include file="console_element/bottom.html"%>
</body>
</html>