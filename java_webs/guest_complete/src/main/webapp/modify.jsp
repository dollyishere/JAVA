<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.guest.dto.Guest" %>
<%@ include file="style.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<script>
	function gotoList() {
		document.location = "main.jsp";
	}
</script>
<body>
	<h2>글수정</h2>
	<hr>
	<br>
	<div style="width:500px;">
		<form action="guest">
		<table>
			<tr style="background-color: #A8CD9F; color:white;">
				<td>
					<label>작성자</label>
				</td>
				<td>
					<input type="text" name="name" value="${ guest1.getName() }" readOnly><br>
				</td>
			</tr>
			<tr style="background-color: #E2F4C5; color:#496989;">
			<td>
				<label>제 목</label>
			</td>
			<td>
				<input type="text" name="title" value="${ guest1.getTitle() }" ><br>
			</td>
			</tr>
			<tr>
				<td style="vertical-align: top;">
					<label>내 용</label>
				</td>
				<td>
					<textarea rows="10" cols="50" name="content">${ guest1.getContent() }</textarea><br>
					<input type="hidden" name="command" value="W" >
				</td>
			</tr>
		</table>
		<br>
		<div class="right-align">
			<input class="click-button" type="button" value="취소" onclick="gotoList()">
			<input class="click-button" type="submit" value="수정" >
		</div>
	</form>
	</div>

</body>
</html>