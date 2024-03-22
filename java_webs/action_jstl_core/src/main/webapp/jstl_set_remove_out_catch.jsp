<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_set_remove_out_catch.jsp</title>
</head>
<body>
	<!-- scope: 해당 페이지를 벗어나면 소멸되는 변수 -->
 	<c:set var="age" value="27" scope="page"></c:set>
 	<h4>설정한 변수값 출력</h4>
	<c:out value="${ age }"></c:out>
	
	<!-- 변수 제거 -->
	<c:remove var="age" scope="page" />
	<!-- 출력 ㄴㄴ -->
	<h4>제거된 변수값 출력</h4>
	<c:out value="${ age }"></c:out>
	
	<h4>오류가 발생했을 경우 예외 처리</h4>
	<c:catch var="errMsg">
		예외 발생 전 <br>
		<%= 1/0 %> <br>
		<!-- 얘는 출력되지 않음(위의 코드에 오류가 있기 떄문) -->
		예외 발생 후 <br>
	</c:catch>
	<c:out value="${ errMsg }"></c:out>
</body>
</html>