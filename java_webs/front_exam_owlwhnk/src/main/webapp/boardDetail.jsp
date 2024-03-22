<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 보기</title>
</head>
<style>
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
      .right-align {
            float: right;
        }
 	  .title {
          font-weight: bold;

      }
      .content {
      		height: 300px;
            padding: 20px;
      }
    table {
  		width: 100%;
        border-collapse: collapse;
      }

     td {
     	padding: 8px;
     }
     tr {
     	 border: 1.5px solid black;
     	 
     }
     body {
    		margin: 40px;
       }
</style>
<body>
	<table>
		<tr style="background-color: #007bff">
			<td class="title">제목</td>
			<td colspan="2">아바다카다브라</td>
		</tr>
		<tr style="background-color: #007bba">
			<td class="title">작성자 / 조회수</td>
			<td colspan="2">김연석 / 11</td>
		</tr>
		<tr style="background-color: #87CEEB">
			<td colspan="3" class="content">
				내용~~~~~~~~~g
			</td>
		</tr>
	</table>
	<br>
	<div class = "right-align">
		<input class="click-button" type="button" value="목록" onclick="gotoList()">
		<!-- default.jsp -->
		
		<input class="click-button" type="button" value="수정" onclick="gotoUpdate()">
		<!-- boardUpdate.jsp -->
	
		<input class="click-button" type="button" value="삭제" onclick="gotoDelete()">
	</div>
</body>
<script type="text/javascript">
	function gotoUpdate() {
		// 이후 서블렛 연결 후 switch로 교체
		document.location="boardUpdate.jsp";
	}
	
	function gotoList() {
		document.location="default.jsp";
	}
	
	function gotoDelete() {
		// 이후 서블렛 연결 후 switch로 교체
		 var result = confirm("정말로 삭제하시겠습니까?");
		if (result) {
			document.location="default.jsp";
		}
	}
</script>
</html>