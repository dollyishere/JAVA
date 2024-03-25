<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forTokens.jsp: 문자열을 구분하여 분리</title>
</head>
<body>
	<c:forTokens var="city" items="서울, 부산, 제주, 대구, 전주" delims=", ">
		${ city }<br>
	</c:forTokens>
</body>
</html>