<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<form action="main">
		<fieldset>
			<legend>로그인 체크</legend>
			<label>아이디</label>
			<input type="text" name="id" placeholder="영문8글자" required>
			<br>
			<label>비밀번호</label>
			<input type="password" name="pw" placeholder="숫자8자리" required>
			<br>
			<input type="submit" value="로그인">
			<input type="reset" value="취소">
		</fieldset>
	</form>
	<div>
		<!-- 이대로 그냥 실행시키면 join.jsp에서 servlet로부터 값을 받아와야 하는 구조인데 join.jsp만 실행될 당시에는 파라미터를 받지 않게 되므로 오류 발생 -->
		<%= request.getParameter("RESULT") %>
	</div>
</body>
</html>