<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json 테스트 문자 배열 데이터 : json1.jsp</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script>
// 1. id가 checkJson인 요소에 click 이벤트 설정
// 2. 이벤트가 발생하면 json 데이터를 출력
// 2-1 json 데이터: "key명 : 데이터"
// 2-2 문자열 형태의 데이터를 json 객체로 변환: JSON.parse(문자열)
// 필수 라이브러리: json-simple-1.1.1.jar
	$(function() { // $(document).ready(function(){}); <body></body> 내의 컨텐츠 준비가 끝나면 
		$("#checkJson").click(function() { // 1.
			var jsonstr = '{ "name": ["홍길동", "이순신", "이승만"] }';
			var jsonObj = JSON.parse(jsonstr);
			console.log(jsonObj)
			
			var output = "회원이름<br>";
			output += "====================";
			
			for (var i in jsonObj.name) { // js for()문 < == java for(:)
				output+= jsonObj.name[i] + "<br>"
			}
			console.log(output);
			$('#output').html(output);
		});
		
	});
</script>

</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br><br>
	<div id="output"></div>
</body>
</html>