<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%
	// 1. 약관 동의 여부
	String agree = request.getParameter("agree"); // YES / NO
	// 2. 회원 가입 승인 여부
	String result = null; // SUCCESS, FAIL, DISAGREE
	
	if(agree.equals("YES")) {
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");
		String name = (String) session.getAttribute("name");
		
		// 데이터를 아이디.txt 파일로 내보내기 (WEB-INF 위치로)
		// 웹에서는 PrintWriter 객체를 필요로 함
		PrintWriter writer = null;
		String filePath = "/WEB-INF/" + id + ".txt";
		String realPath = application.getRealPath(filePath);
		
		try{
			writer = new PrintWriter(realPath);
			writer.println("아이디: " + id);
			writer.println("비밀번호: " + pw);
			writer.println("이름: " + name);
			
			result = "SUCESS";
		} catch(IOException E) {
			result = "FAIL";
		} finally {
			writer.close();
		}
	} else {
		result = "DISAGREE";
	}
	
	session.invalidate(); // 세션 종료 <= 이 때 데이터 상실!
	response.sendRedirect("session_result.jsp?result=" + result);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session_subscribe.jsp</title>
</head>
<body>

</body>
</html>