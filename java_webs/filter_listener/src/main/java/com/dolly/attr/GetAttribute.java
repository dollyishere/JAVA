package com.dolly.attr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/** SetAttribute.java ("/set")에서 저장한 값들을 추출 **/
@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		String ctxMsg = (String) ctx.getAttribute("context");
		String sessionMsg = (String) session.getAttribute("session");
		String requestMsg = (String) request.getAttribute("request");
		
		pw.println(ctxMsg + "<br>");
		pw.println(sessionMsg + "<br>");
		// forwarding을 안해서 null로 뜸
		pw.println(requestMsg + "<br>");
	}
}

/**
 * ServletContext : Servlet이 소멸되기 전까지(즉, 서버 닫힐 때까지?) 유지
 * HttpSession	: 동일 브라우저에서만 유지
 * HttpServletRequest : 통일하기 전까지는 동일 url에서만 유지
 * **/