<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	// POST 방식으로 전송되면 한글이 깨지기 때문에 명시해줄 것
	// 이건 Servlet도 동일함
	
	// JSP 내장 객체인 session에 전달된 값들을 저장
	// 서블릿에서는 세션 객체가 없으니 만들어주어야 함
	session.setAttribute("id", request.getParameter("id"));
	session.setAttribute("pw", request.getParameter("pw"));
	session.setAttribute("name", request.getParameter("name"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session_agreement.jsp: 약관 동의</title>
</head>
<body>
	<h3>약관</h3>
	<hr>
	1. 회원 정보는 웹 운영에만~
	2. 웹 운영 차질 => 강제 탈퇴!!!
	<hr>
	
	위의 약관에 동의???
	<form action="session_subscribe.jsp">
		<input type="radio" name="agree" value="YES"> 동의 <br>
		<input type="radio" name="agree" value="NO"> 동의하지 않음 <br>
		<br>
		<input type="submit" value="확인">
	</form>
</body>
</html>