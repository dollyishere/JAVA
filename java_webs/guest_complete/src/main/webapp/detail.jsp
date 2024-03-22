<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.guest.dto.Guest" %>
<%@ include file="style.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<script>
	function gotoModify() {
		document.location = "guest?command=D&idx=" + ${guest1.getIdx()} + "&status=modify";
	}
	function gotoList() {
		document.location = "main.jsp";
	}
	function gotoDelete() {
		 var result = confirm("정말로 삭제하시겠습니까?");
			if (result) {
				document.location = "guest?command=DEL&idx=" + ${ guest1.getIdx() };
			}
	}
</script>
</head>
<body>
	<h2>글상세</h2>
	<hr>
	<br>
	<table>
		<tr class="title-block"><td colspan="3">제목</td></tr>
		<tr>	
			<td colspan="3"> ${ guest1.getTitle() } </td>
		</tr>
		<tr class="title-block">
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<tr>
			<td>${ guest1.getName() }</td>
			<td>${ guest1.getMoment() }</td>
			<td>${ guest1.getHit() }</td>
		</tr>
		<tr>
		</tr>
		<tr class="title-block"><td colspan="3">내용</td></tr>
		<tr style="height:300px;">
			<td colspan="3">
				${ guest1.getContent() }
			</td>
		</tr>
	</table>
	<br>
	<div  class="right-align">
		<input  class="click-button" type="button" value="수정화면이동" onclick="gotoModify()">
		<!-- modify.jsp => 현재 보여지는 모든 데이터 전송 -->
	
		<input class="click-button" type="button" value="목록화면이동" onclick="gotoList()">
		<!-- main.jsp -->
	
		<input class="click-button" type="button" value="글삭제" onclick="gotoDelete()">
		<!-- guest?command=DEL&idx=1 -->
	</div>
</body>
</html>






