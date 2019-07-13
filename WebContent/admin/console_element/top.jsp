<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="header">
	<div id="welcome">
		欢迎<%=session.getAttribute("login")%>使用新闻管理系统！
	</div>
	<div id="silder" class="js-silder">
		<div class="silder-scroll">
			<div class="silder-main">
				<div class="silder-main-img">
					<img src="images/d2.png" alt="">
				</div>
				<div class="silder-main-img">
					<img src="images/d1.png" alt="">
				</div>
			</div>
		</div>
	</div>
</div>
<div id="admin_bar">
	<div id="status">
		管理员：
		<%=session.getAttribute("login")%>
		&#160;&#160;&#160;&#160; <a href="#">login out</a>
	</div>
	<div id="channel"></div>
</div>
