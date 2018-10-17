<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//Login.do로 접속시 로그인 페이지
%>
<div class="login">
	<form action="Login.do" method="post">
		<fieldset>
			<legend>로그인</legend>
			<label for="loginID">아이디</label> <input id="loginID" name="loginID" type="text"
				autofocus="autofocus" required="required" /><br /> <label
				for="loginPW">비밀번호</label> <input id="loginPW" name="loginPW"  type="password"
				required="required" /><br /> <input type="submit" value="로그인" />
		</fieldset>
	</form>
</div>