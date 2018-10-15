<%@page import="kr.co.hkitedu.model.DTO.TempSectionPageStat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String wps = "../TemplateF/Home.jsp";//템플릿 기본값
	String wpsn = "Happy Board";
	TempSectionPageStat tsps = null;
	if (request.getAttribute("tsps") != null) {
		tsps = (TempSectionPageStat) request.getAttribute("tsps");
		if (tsps.getWps().equals("")) {
			wps = tsps.getWps();
		} else if (tsps.getWpsn().equals("")) {
			wpsn = tsps.getWpsn();
		}
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
				<h1><%=wpsn%></h1>
			</header>
		</div>
		<nav>
			<ul class="navul1">
				<li><a href="<%=request.getContextPath()%>/Home.do">Home</a></li>
				<li><a href="">Board</a>
					<ul class="navul2">
						<li><a href="<%=request.getContextPath()%>/Board.do?wb=1">유머
								게시판</a></li>
						<li><a href="<%=request.getContextPath()%>/Board.do?wb=2">학습
								게시판</a></li>
						<li><a href="<%=request.getContextPath()%>/Board.do?wb=3">자유
								게시판</a></li>
					</ul></li>
			</ul>
		</nav>
		<section>
			<jsp:include page="<%=wps%>" />
		</section>
		<footer>CopyRight by Lee</footer>
	</div>
</body>
</html>