<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = request.getParameter("result");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 가입 결과</h3>
	<%
		if (result.equals("SUCESS")) {
			out.print("축하!!!");
		} else {
			out.print("아쉽네용");
		}
	%>
</body>
</html>