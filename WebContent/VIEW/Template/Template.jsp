<%@page import="kr.co.hkitedu.model.DTO.TempSectionPageStat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//TemplateF폴더의 조각 파일들을 통합하는 템플릿 페이지
%>
<%
	String wps = "../TemplateF/Home.jsp";//템플릿 기본값
	String wpsn = "Happy Board"; // 헤더 타이틀 기본값
	TempSectionPageStat tsps = null;
	if (request.getAttribute("tsps") != null) {
		tsps = (TempSectionPageStat) request.getAttribute("tsps");
		wps = "../TemplateF/" + tsps.getWps() + ".jsp";
		wpsn = tsps.getWpsn();
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
			<div class="login">
				<button
					onclick="location.href='<%=request.getContextPath()%>/Login.do'">로그인</button>
				<button
					onclick="location.href='<%=request.getContextPath()%>/Signup.do'">회원가입</button>
			</div>
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