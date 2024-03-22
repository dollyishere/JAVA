<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, com.freeflux.dto.GuestClass" %>
<%
	List<GuestClass> guestList = (List<GuestClass>) request.getAttribute("guestList");
%>
<%-- <%= guestList.size() %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
	<script type="text/javascript">
		function goURL() {
			// alert 반드시 문자열로 시작해야 함
			// 경고창이 뜬 상태에서는 아예 내부 컨텐츠를 사용하는 것이 불가함 (코드 자체가 아예 일시정지)
			alert("글쓰기 버튼 클릭");
			document.location="write.jsp";
			
		}
		
		
	</script>
</head>
<body>
	<% if (guestList.size() == 0) { %>
		<p>게시글이 없습니다.</p>
		<% } else { %>
			<table>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
				<% for (GuestClass guest: guestList) { %>
					<tr>
						<td><%= guest.getIdx() %></td>
						<td> 
							<a href="guest?command=D&idx=<%= guest.getIdx() %>&status=detail">
								<%= guest.getTitle() %>
							</a>
						</td>
						<td><%= guest.getName() %></td>	
						<td><%= guest.getMoment() %></td>	
						<td><%= guest.getHit() %></td>
					</tr>
				<% } %>	
			</table>
			
		<% } %>
	
	<input type="button" value="글쓰기" onclick="goURL()">
</body>
</html>