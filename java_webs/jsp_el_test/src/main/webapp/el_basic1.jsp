<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL : el_basic.jsp</title>
</head>
<body>
	${ "EL" }<br> <!-- EL 을 이용한 출력 -->
	<%= "EL" %> <br> <!-- jsp 문법을 이용한 출력 -->
	<%
		out.print("EL"); // JSP 내장 객체인 out을 이용한 출력
		// out을 사용할 경우 println()은 의미가 없다! => html에서는 줄바꿈하려면 무조건 br 태그 생성해야 하기 때문
	%>
</body>
</html>