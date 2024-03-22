<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	JSP 방식 <br>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		out.print(num1+num2);
	%><br>
	<hr>
	EL 방식<br>
	${ param.num1 } + ${ param.num2 }<br>
	${ param.num1 + param.num2 }
	
</body>
</html>