<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("job", "developer");
	// 수명을 먼저 주고 내보내야 함
	cookie.setMaxAge(3); // 쿠키 수명 설정
	response.addCookie(cookie); // 쿠키 객체가 자기에대한 수명을 가지고 있기에 바로 추가할 수는 없음?
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제: cookie_delete.jsp</title>
</head>
<body>

</body>
</html>