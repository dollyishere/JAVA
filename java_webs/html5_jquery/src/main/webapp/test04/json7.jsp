<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script>
	$(function(){
		$('#checkJson').click(function() {
			$.ajax({
				type: "post",
				async: false,
				url: "${contextPath}/json3",
				success: function(data, textStatus) {
					var jsonInfo = JSON.parse(data);
					var output = "<h2>회원 정보</h2><br>";
					output += "<hr>";
					
					for (var i in jsonInfo.members) {
						output += "이름 : " + jsonInfo.members[i].name + "<br>";
						output += "나이 : " + jsonInfo.members[i].age + "<br>";
						output += "성별 : " + jsonInfo.members[i].gender + "<br>";
						output += "별명 : " + jsonInfo.members[i].nickname + "<br>";
						output += "=================<br>"
					}
					
					
					output +=  "<h2>서적 정보</h2><br>";
					output += "<hr>";
					for (var j in jsonInfo.books) {
						output += "제목 : " + jsonInfo.books[j].title + "<br>";
						output += "저자 : " + jsonInfo.books[j].author + "<br>";
						output += "가격 : " + jsonInfo.books[j].price + "<br>";
						output += "<img src=" + jsonInfo.books[j].image + " /><br>";
						output += "=================<br>"
					}
					console.log(output);
					$("#output").html(output);
				},
				error: function(data, textStatus) {
					alert("에러 발생!");
				},
				complete: function(data, textStatus) {
					alert("작업 완료!");
				}
			})
		});
	});
</script>

</head>
<body>
<a id="checkJson" style="cursor:pointer">출력</a><br><br>
<div id="output"></div>
</body>
</html>