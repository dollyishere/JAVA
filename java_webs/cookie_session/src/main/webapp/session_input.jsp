<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session test</title>
</head>
<body>
	개인정보를 입력하세요~
	<form action="session_agreement.jsp" method="post">
		<label>아이디 : </label>
		<input type="text" name="id" requried > <br>
		<label>비밀번호 : </label>
		<input type="text" name="pw" requried > <br>
		<label>이름 : </label>
		<input type="text" name="name" requried > <br>
		
		<input type="submit" value="확인" > <br>
	</form>
</body>
</html>