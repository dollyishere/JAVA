<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"></c:set>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${ param.param1 }"></c:set>
<c:set var="file2" value="${ param.param2 }"></c:set>
<title>이미지 파일 출력 : result.jsp => FileDownload (download.do)</title>
</head>
<body>
	<pre>
		대략적인 순서
		1. 이미지 파일 표시창에서 <img> 태그의 src 속성에
			다운로드할 요청 url pattern 명(download.do)을 이용하여 요청
			파일이름을 get 방식으로 전송
			
		2. 다운로드한 이미지 파일을 <img> 태그에 출력
		3. <a href=""></a>를 이용하여 사용자가 이미지를 클릭했을 때 다운로드할 수 있도록...
		4. 파일 전체를 로컬 pc의 다운로드 폴더에 저장
		
		알아내야 할 것
		1. 다운로드할 파일 이름을 추출
		2. 파일 이름으로 서블릿에서 이미지를 다운로드 하여 출력
		3. 파일 이름으로 서블릿에서 이미지를 다운로드 하여 출력
		4. 이미지 파일 다운로드...
	</pre>
	
	<!-- 1 -->
	${ contextPath }
	파라미터 1: <c:out value="${ file1 }"></c:out>
	파라미터 2: <c:out value="${ file2 }"></c:out>
	<!-- 2 -->
	<c:if test="${ not empty file1 }">
		<img src="${ contextPath }/download.do?fileName=${ file1 }" width= "300" height="300"> <br>
	</c:if>
	<!-- 3 -->
	<c:if test="${ not empty file2 }">
		<img src="${ contextPath }/download.do?fileName=${ file2 }" width= "300" height="300"> <br>
	</c:if>
	<!-- 4 -->
	파일 다운로드 : <br>
	<!-- a 태그의 경로가 파일로 되어있으면 무조건 다운로드가 되어버림... -->
	<a href="${ contextPath }/download.do?fileName=${ file1 }">파일1 내려받기</a>
	<a href="${ contextPath }/download.do?fileName=${ file2 }">파일2 내려받기</a>
	<!-- 1 -->
</body>
</html>