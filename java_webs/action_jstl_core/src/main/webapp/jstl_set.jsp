<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_set : set 태그</title>
</head>
<body>
	변수 설정 <br>
	<!-- var: 번수명, value: 변수 초기값 설정 -->
	<c:set var="msg" value="Hello"> </c:set>
	\${ msg } = ${ msg }<br>
	
	<c:set var="age">100</c:set>
	\${ age } = ${ age }<br>
	
	<c:set var="add" value="${ 10+5 }"></c:set>
	\${ add } = ${ add }<br>
	
	<c:set var="flag" value="${ 10>5 }"></c:set>
	\${ flag } = ${ flag }<br>
	
	<hr>
	<h4>MemberBean 객체 생성</h4>
	<!-- 풀 패키지명 넣어주기 -->
	<!-- 자동 import 해줄 때도 많은데 안해줄 때가 더 많아서 각자도생 의미라고 하면 되겠음 -->
	<c:set var="member" value="<%= new com.dolly.beans.MemberBean() %>"></c:set>
	
	<!-- 			 사용객체명			내부변수명		변수에 대입 -->
	<!-- 이하처럼 작성하면 setName()이 호출되어 값 입력하는 것이 가능함! -->
	<c:set target="${ member }" property="name" value="돌리"></c:set>
	<!-- 태그 사이에 넣는 것도 가능~ -->
	<c:set target="${ member }" property="userid">dolly</c:set>
	<!-- toString() 자동 호출 -->
	\${ member } = ${ member }
</body>
</html>