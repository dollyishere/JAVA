<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// JSP에서 내장 객체를 통한 변수 선언 위치(범위)
	// 내장 객체의 setArribute("키", 데이터);
	pageContext.setAttribute("name", "dolly");
	// => 현재 페이지에서만 사용 가능한 변수
			
	request.setAttribute("list", "ArrayList");
	// request 객체 내부에 선언
	
	session.setAttribute("id", "dolly");
	// 웹 서버(프로젝트 내부) 선언 : 단, session은 개발자에 의해 제거할 수 있음 (자동 소멸도 가능) => 수명을 줄 수 있다는 뜻
			
	application.setAttribute("listener", "init data");
	// 구동 중인 앱 내부에 선언.. / 서버가 중지될 때까지 사용 가능..
	// 가장 폭 넓게 사용됨
	// tomcat 서버가 실행될 때 가장 먼저 확인하는 web.xml에 들어가 있는 요소들을 application이 가져온다고 볼 수 있음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_scope.jsp: 변수의 범위</title>
</head>
<body>
	<!-- 객체 내부에 직접 선언한 값 -->
	내장 객체를 이용하여 선언된 변수의 값을 추출하는 방법<br>
	<hr>
	pageContext: ${ name } <br>
	request : ${ requestScope.list } <br>
	session : ${ sessionScope.id } <br>
	application : ${ applicationScope.listener } <br>
	
	<!-- 외부 전달 값 -->
	외부로부터 전달 받은 데이터(name 속성을 이용하여...)<br>
	param: ${ param.name }
	
	
	
	
	
</body>
</html>