<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if 태그 (select_color.jsp) 선택 결과</title>
</head>
<body>
	<!-- test에 조건이 들어감 -->
	<co:if test="${ param.color == 0 }">
		<span style="color:black;"> <!-- span : 주로 꾸밀 때 많이 사용 -->
			<u>					<!-- u: 밑줄 -->
				<i>선택된 색상이 없습니다</i>
			</u>
		</span>
	</co:if>
	<co:if test="${ param.color == 1 }">
		<span style="color:red;"> <!-- span : 주로 꾸밀 때 많이 사용 -->
			<u>					<!-- u: 밑줄 -->
				<i>빨강</i>
			</u>
		</span>
	</co:if>
	<co:if test="${ param.color == 2 }">
		<span style="color:green;"> <!-- span : 주로 꾸밀 때 많이 사용 -->
			<u>					<!-- u: 밑줄 -->
				<i>초록</i>
			</u>
		</span>
	</co:if>
	<co:if test="${ param.color == 3 }">
		<span style="color:yellow;"> <!-- span : 주로 꾸밀 때 많이 사용 -->
			<u>					<!-- u: 밑줄 -->
				<i>노랑</i>
			</u>
		</span>
	</co:if>
	<!-- choose 태그 사용 : 마치 switch처럼 -->
	<co:choose>
		<co:when test="${ param.color == 1 }"> <!-- case 처럼 사용 -->
			<b>빨강</b> <!-- b: 굵게! -->
		</co:when>
		<co:when test="${ param.color == 2 }"> <!-- case 처럼 사용 -->
			<b>초록</b>
		</co:when>
		<co:when test="${ param.color == 3 }"> <!-- case 처럼 사용 -->
			<b>노랑</b>
		</co:when>
	</co:choose>
</body>
</html>