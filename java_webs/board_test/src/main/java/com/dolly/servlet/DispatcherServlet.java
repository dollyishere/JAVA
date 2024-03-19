package com.dolly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dolly.controller.MemberController;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(description = "모든 요청사항 처리 서블릿", urlPatterns = { "/main" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); // 파라미터로 얻어온 값
		String pw = request.getParameter("pw");
		
		MemberController mc = new MemberController();
		String result = mc.join(id, pw);
		
		response.sendRedirect("join.jsp?RESULT="+result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
