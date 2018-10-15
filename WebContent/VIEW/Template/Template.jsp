<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String wp = "Home";
	if (request.getAttribute("wp") != null) {
		wp = "../TemplateF/" + request.getAttribute("wp").toString() + ".jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy Board</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/VIEW/CSS/Common.css" />
</head>
<body>
	<div class="container">
		<div class="top">
			<header>
				<h1>Happy Board</h1>
			</header>
		</div>
		<nav>
			<ul class="navul1">
				<li><a href="<%=request.getContextPath()%>/Home.do">Home</a></li>
				<li><a href="">Board</a>
					<ul class="navul2">
						<li><a href="<%=request.getContextPath()%>/Board.do">유머
								게시판</a></li>
						<li><a href="<%=request.getContextPath()%>/Board.do">학습
								게시판</a></li>
						<li><a href="<%=request.getContextPath()%>/Board.do">자유
								게시판</a></li>
					</ul></li>
			</ul>
		</nav>
		<section>
			<jsp:include page="<%=wp%>" />
		</section>
		<footer>CopyRight by Lee</footer>
	</div>
</body>
</html>