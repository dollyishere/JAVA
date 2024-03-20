<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.freeflux.dto.GuestClass" %>
<% 
	GuestClass guest = (GuestClass) request.getAttribute("guest");
	if (guest == null) {
		response.sendRedirect("main.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
	글수정 <br>
	<form action="guest">
		<label>작성자</label>
		<input type="text" name="name" value="<%= guest.getName() %>"><br>
		<label>제 목</label>
		<input type="text" name="title" value="<%= guest.getTitle() %>"><br>
		<label>내 용</label><br>
		<textarea rows="10" cols="50" name="content"><%= guest.getContent() %></textarea><br>
		<input type="hidden" name="command" value="U" >
		<input type="hidden" name="idx" value="<%= guest.getIdx() %>" >
		<input type="submit" value="내용수정" >
	</form>
</body>
</html>