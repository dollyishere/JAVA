package com.dolly.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTest2
 */
@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = ""; // xml 문서 저장
		request.setCharacterEncoding("utf-8");
		result = result + "<main><book>";
		result = result + "<title><![CDATA[초보자를 위한 Java]]></title>";
		result = result + "<writer><![CDATA[이윤성]]></writer>";
		result = result + "<image><![CDATA[http://localhost:9000/html5_jquery/image/image1.jpg]]></image>";
		result = result + "</book>";
		result = result + "<book>";
		result = result + "<title><![CDATA[모두의 파이썬]]></title>";
		result = result + "<writer><![CDATA[이승환]]></writer>";
		result = result + "<image><![CDATA[http://localhost:9000/html5_jquery/image/image2.jpg]]></image>";
		result = result + "</book></main>";
		
		System.out.println("xml 문서 => " + result);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(result);
	}

}
