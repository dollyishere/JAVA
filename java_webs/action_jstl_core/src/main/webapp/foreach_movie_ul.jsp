<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String[] movieList = {"듄", "코카콜라 비극의 탄생", "더 다크 호러 러브", "릴릴리 삐빠빱", "사랑을 말하지 않는 당신에게"};
	// movieList는 현재 페이지에서만 사용 가능하도록...
	pageContext.setAttribute("movieList", movieList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul> <!-- 목록화 태그 / ol tag: 얘는 내부에 <li></li> 있어야 함 -->
	<!-- li 태그는 자동 줄바꿈 기능이 내장 -->
		<c:forEach var="movie" items="${ movieList }" varStatus="status">
			<c:choose>
				<c:when test="${ status.first }"> <!-- if() -->
					<li style="color:red; font-weight:bold;">
						${ movie }
					</li>
				</c:when>
				<c:otherwise> <!-- else -->
					<li>
						${ movie }
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	<c:forEach var="movie" items="${ movieList }" varStatus="status">
		${ movie } <c:if test="${ not status.last }">, </c:if>		
	</c:forEach>
</body>
</html>