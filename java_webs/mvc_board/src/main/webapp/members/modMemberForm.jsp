<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정: modMemberForm.jsp</title>
</head>
<body>
<form action="${ contextPath }/member/modMember.do"  method="post">
		<p>회원수정화면</p>
		<table>
			<tr>
				<td>아이디</td> <!-- 아이디 수정 불가! -->
				<td>
					<input type="text" disabled value="${ member.id }">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pwd" value="${ member.pwd }">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" value="${ member.name }">
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="email" name="email" value="${ member.email }">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
		<input type="text" name="id" hidden="hidden" value="${ member.id }">
	</form>
</body>
</html>