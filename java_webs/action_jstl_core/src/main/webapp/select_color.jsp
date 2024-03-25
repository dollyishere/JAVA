<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if 태그 (select_color.jsp) 선택</title>
</head>
<body>
	<form action="select_color_result.jsp">
		<!-- tag의 id="" 속성은 css 또는 javascript에서 html 요소 선택 시... -->
		<!-- javascript에서 html 요소 선택
			document.getElementById("id명");
			document.getElementByTag("Tag명");
		 -->
		<!-- <label for="color">색상을 선택하세요...</label> -->
		<!-- label의 for은 누구를 위한 라벨인지를 뜻함 -->
		<!-- <select id="color" name="color" size="3"> => 리스트 형태의 메뉴 -->
		<select id="color" name="color"> <!-- 콤보박스 -->
			<option value="1">색상선택</option>
			<option value="1">빨강</option>
			<option value="2">초록</option>
			<option value="3">노랑</option>
		</select>
		<input type="submit" value="전송">
	</form>
</body>
</html>