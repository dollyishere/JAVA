<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키의 값을 수정할 경우: Map처럼 동일한 이름에 새로운 값을 설정
	// 엄연히 말하자면 원래 값에 새 값을 덮어 씌우는 것
	response.addCookie(new Cookie("age", "27"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 수정: cookie_update.jsp</title>
</head>
<body>
	<h2>age 쿠키의 값이 수정되었습니다.</h2>
</body>
</html>