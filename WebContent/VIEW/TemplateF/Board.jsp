<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.hkitedu.model.DTO.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//Board.do로 접속시 게시판 페이지.
	//필요정보 : BoardVo객체, 게시판 종류, 페이지 정보.
	ArrayList<BoardVO> bvl = null;

	if (request.getAttribute("bvl") != null) {
		bvl = (ArrayList<BoardVO>) request.getAttribute("bvl");
	}

	int pgn = 1;

	if (request.getAttribute("pgn") != null) {
		pgn = (int) request.getAttribute("pgn");
	}

	String wb = "1";
	if (request.getAttribute("wb") != null) {
		wb = request.getAttribute("wb").toString();
	}
%>

<div class="board">
	<table class="boardtable">
		<tr>
			<th>게시번호</th>
			<th>게시글</th>
			<th>게시일</th>
		</tr>
		<%
			if (bvl != null && bvl.size() != 0) {
				for (int i = 0; i < bvl.size(); i++) {
		%>
		<tr>
			<td><%=bvl.get(i).getBid()%></td>
			<td><%=bvl.get(i).getBtitle()%></td>
			<td><%=bvl.get(i).getBregdate()%></td>
		</tr>
		<%
			}
			} else {
		%>
		<tr>
			<td class="borderbid">게시글이</td>
			<td class="borderbtitle">없습니다.</td>
			<td class="borderbregdate">####/##/##(####/##/##)</td>
		</tr>
		<%
			}
		%>
	</table>

	<div class="boarderbtn">
		<div class="page">
			<%
				for (int i = 0; i <= pgn; i++) {
			%>
			<a
				href="<%=request.getContextPath()%>/Board.do?wb=<%=wb%>&wbp=<%=(i + 1)%>"><%=(i + 1)%></a>
			<%
				if (i != pgn) {
			%>
			,
			<%
				}
				}
			%>
		</div>
		<button class="writeboard">글쓰기</button>
	</div>
</div>