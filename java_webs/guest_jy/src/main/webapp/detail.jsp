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
<title>글상세</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        .author {
            font-size: 16px;
            color: #666;
            margin-bottom: 10px;
        }
        .content {
            font-size: 18px;
            line-height: 1.6;
            margin-bottom: 20px;
        }
        .date {
            font-size: 14px;
            color: #888;
            margin-bottom: 10px;
        }
        .views {
            font-size: 14px;
            color: #888;
            margin-bottom: 20px;
        }
        .button-container {
            display: flex;
            justify-content: space-evenly;
        }
        .button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
	<script type="text/javascript">
		function gotoModify() {
			document.location="guest?command=D&idx=<%= guest.getIdx() %>&status=M";
		}
		
		function gotoList() {
			document.location="main.jsp";
		}
		
		function gotoDelete() {
			document.location="guest?command=DEL&idx=<%= guest.getIdx() %>";
		}
	</script>
</head>
<body>
	<div class="container">
        <div class="title"> <%= guest.getTitle() %></div>
        <div class="author">작성자: <%= guest.getName() %></div>
        <div class="content">
           <%= guest.getContent() %>
        </div>
        <div class="date">작성 날짜:  <%= guest.getMoment() %></div>
        <div class="views">조회수:  <%= guest.getHit()+1 %></div>
    </div>
    <div class="button-container">
		<input class="button" type="button" value="수정화면이동" onclick="gotoModify()">
		<!-- modify.jsp => 현재 보여지는 모든 데이터 전송 -->
		<!-- 이 녀석을 호출할 때 detailController도 같이 호출해주면 됨 -->
		
		<input class="button" type="button" value="목록화면이동" onclick="gotoList()">
		<!-- main.jsp -->
		
		<input class="button" type="button" value="글삭제" onclick="gotoDelete()">
		<!-- guest?command=DEL&idx=1 -->
    </div>

</body>
</html>