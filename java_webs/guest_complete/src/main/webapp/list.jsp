<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.freeflux.guest.dto.Guest" %>    
<%
	List<Guest> glist = (List<Guest>)request.getAttribute("glist"); 
%>
<%@ include file="style.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<script>
	function gotoList() {
		document.location = "main.jsp";
	}
	function goURL(){
		document.location="write.jsp";
	}
	function startSearch() {
		var searchInput = document.getElementById("searchItem");
		console.log(searchInput.value);
		searchInput.value = "";
	}
</script>
</head>

<body>
	<div class ="right-align">
		<select name="searchType">
			<option value="1">전체</option>
			<option value="2">이름</option>
			<option value="3">내용</option>
			<option value="4">작성자</option>
		</select>
		<input type="text" name="searchItem" id="searchItem">
		<button  class="click-button" onclick="startSearch()">검색</button>
	</div>
	<br>
	<br>
	<br>
	<table>
	<% if(glist.size() < 1) { %>
		<tr><td>게시글이 없습니다..</td></tr>
	<% }else{ %>
			<tr style="background-color: #58A399;">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
			<% for(Guest guest : glist){
				pageContext.setAttribute("guest", guest);
			%>
				<% if (guest.getIdx()% 2 == 1)  {%>
					<tr style="background-color: #A8CD9F; color:white;">
				<% } else { %>
					<tr style="background-color: #E2F4C5; color:#496989;">
				<% } %>
					<td>${ guest.getIdx() }</td>
					<td>
					<a href="guest?command=D&status=detail&idx=${ guest.getIdx() }" >
						 ${ guest.getTitle() }
					</a>
					</td>
					<td>${ guest.getName() }</td>
					<td>${ guest.getMoment() }</td>
					<td>${ guest.getHit() }</td>
				</tr>
			<%}%>
	 <%} %>
	</table>
	<br>
	<span>
		<button class="pagenationBtn">&lt;이전 </button>&nbsp;&nbsp;
		<% for(int j=0 ; j<(glist.size() / 10 + 1); j++){%>
			<button class="pagenationBtn"><%= j+1 %></button>
		<%}%>
		&nbsp;&nbsp;<button class="pagenationBtn">다음></button>
	</span>
	<span  class ="right-align">
		<input type="button" value="목록" onclick="gotoList()" class="click-button">
		<!-- main.jsp -->
		<input type="button" value="글쓰기"  onclick="goURL()"  class="click-button">
	</span> 
</body>
</html>








