<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
  <div class="sidebar">
    <h1> <img src="images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<!-- 循环输出新闻列表 -->
      	<c:choose>
      		<c:when test="${requestScope.chinaNewsList == null}">
      			<p>当前暂无新闻</p>
      		</c:when>
      		<c:when test="${empty requestScope.chinaNewsList}">
      			<p>当前暂无新闻</p>
      		</c:when>
      		<c:otherwise>
      			<c:forEach items="${requestScope.chinaNewsList}" var="aNew">
            		<li><a href='/readNews&newsId=${aNew.newsId}'><b>${aNew.newsTitle}</b></a></li>
      			</c:forEach>
      		</c:otherwise>
      	</c:choose>
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
      <!-- 循环输出新闻列表 -->
      	<c:choose>
      		<c:when test="${requestScope.intelNewsList == null}">
      			<p>当前暂无新闻</p>
      		</c:when>
      		<c:when test="${empty requestScope.intelNewsList}">
      			<p>当前暂无新闻</p>
      		</c:when>
      		<c:otherwise>
      			<c:forEach items="${requestScope.intelNewsList}" var="aNew">
            		<li><a href='/readNews&newsId=${aNew.newsId}'><b>${aNew.newsTitle}</b></a></li>
      			</c:forEach>
      		</c:otherwise>
      	</c:choose>
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
      <!-- 循环输出新闻列表 -->
      	<c:choose>
      		<c:when test="${requestScope.playNewsList == null}">
      			<p>当前暂无新闻</p>
      		</c:when>
      		<c:when test="${empty requestScope.playNewsList}">
      			<p>当前暂无新闻</p>
      		</c:when>
      		<c:otherwise>
      			<c:forEach items="${requestScope.playNewsList}" var="aNew">
            		<li><a href='/readNews&newsId=${aNew.newsId}'><b>${aNew.newsTitle}</b></a></li>
      			</c:forEach>
      		</c:otherwise>
      	</c:choose>
      </ul>
    </div>
  </div>
</body>
</html>
