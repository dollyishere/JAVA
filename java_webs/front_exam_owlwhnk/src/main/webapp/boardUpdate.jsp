<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정 폼</title>
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
    form {
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
	<form action="default.jsp">
		<label>제 목</label>
		<input type="text" name="title" maxlength="100" required="required" ><br>
		<label>작성자</label>
		<input type="text" name="name" required="required" readonly=readonly ><br>
	
		<label>내 용</label><br>
		<textarea rows="10" cols="50" name="content" required="required"></textarea><br>
		<br>
		<div  class = "right-align">
			<button  class="click-button" onclick="goMenu()">목록</button>
			<input  class="click-button" type="submit" value="수정하기" >
		</div>
	</form>
	
</body>
<script type="text/javascript">
	function goMenu() {
		document.location="default.jsp";
	}
</script>
</html>