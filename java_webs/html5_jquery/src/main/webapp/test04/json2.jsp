<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json 테스트 숫자 배열 데이터: json2.jsp</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script>
	$(function() {
		$("#checkJson").click(function() {
			var jsonstr = '{"age" : [23, 45, 56]}';
			var jsonObj = JSON.parse(jsonstr);
			var output = "회원 나이<br>";
			output += "<hr>";
			output += "<br>";
			
			for (var i in jsonObj.age) {
				output += jsonObj.age[i] + "<br>";
			}
			$("#output").html(output);
		});
	});
</script>

</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br><br>
	<div id="output"></div>
</body>
</html>