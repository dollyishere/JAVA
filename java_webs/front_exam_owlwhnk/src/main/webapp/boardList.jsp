<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
	.title {
			width: 200px;
          white-space: nowrap;
          overflow: hidden;
          text-overflow: ellipsis;
        }
     .pagenationBtn {
     	border: none;
     	background: none;
     	padding: 0;
     	cursor: pointer;
     }
      .right-align {
            float: right;
        }
       .click-button {
            background-color: #007bff;
            font-weight: bold;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            cursor: pointer;
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
        }
     table {
    		width: 100%;
            border-collapse: collapse;
        }
     th, td {
            border: 1.5px solid black;
            padding: 8px;
            text-align: center;
        }
     th {
            text-align: center;
            font-weight: bold;
            background-color: #e6f7ff;
        }
     body {
    		margin: 40px;
       }
</style>
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
	<table width=600>
			<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회</th>
			</tr>
			<% for(int i=0 ; i<10; i++){%>
				<tr>
					<td><%= i + 1 %></td>
					<td style="text-overflow:ellipsis;width:300;overflow:hidden">
						<nobr>
							<a href="boardDetail.jsp?idx=<%= i %>">
							하하하하agsd하하하하ㅏ하하하하하하하하하
							</a>
						</nobr>
					</td>
					<td>sadg</td>
					<td>gg</td>
					<td>gg</td>
				</tr>
			<%}%>
	</table>
	<br>
	<span>
		<button class="pagenationBtn">&lt;이전 </button>&nbsp;&nbsp;
		<% for(int j=0 ; j<8; j++){%>
			<button class="pagenationBtn"><%= j+1 %></button>
		<%}%>
		&nbsp;&nbsp;<button class="pagenationBtn">다음></button>
	</span>
	<span class ="right-align">
		<button class="click-button" onclick="refreshPage()">목록</button>
		<input class="click-button" type="button" value="글쓰기"  onclick="goInsert()" > 
	</span>
</body>
<script type="text/javascript">
	function refreshPage() {
		document.location="default.jsp";
	}
	function goInsert(){
		document.location="boardInsert.jsp";
	}
	function startSearch() {
		var searchInput = document.getElementById("searchItem");
		console.log(searchInput.value);
		searchInput.value = "";
	}
</script>
</html>