<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- spring에서는 이런 형식이므로, 잘 만들어둘 것 -->
<jsp:useBean id="member" class="com.dolly.beans.MemberBean"></jsp:useBean>
<!-- memeberBean 내에 있는 변수들과 useBeans_add_form이 가지고 있는 변수들의 이름이 일치하기에 *로 불러올 수 있음! -->
<!-- 가지고 있는 파라미터들을 member로 세팅하고 있다는 의미?
< 즉 setProperty는 setter를, getProperty는 getter를 호출한다고 보면 됨 -->
<jsp:setProperty property="*" name="member"></jsp:setProperty>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>전달된 파라미터 명과 MemberBean의 멤버 변수를 자동 매핑</title>
</head>
<body>
	<jsp:getProperty property="name" name="member"></jsp:getProperty>
	<jsp:getProperty property="userid" name="member"></jsp:getProperty>
	<jsp:getProperty property="nickname" name="member"></jsp:getProperty>
	<jsp:getProperty property="pwd" name="member"></jsp:getProperty>
	<jsp:getProperty property="email" name="member"></jsp:getProperty>
	<jsp:getProperty property="phone" name="member"></jsp:getProperty>
</body>
</html>