package com.dolly.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter outPrintWriter = response.getWriter();
		
		JSONObject total = new JSONObject();
		// 회원 정보
		JSONArray memberArray = new JSONArray();
		JSONObject member = new JSONObject();
		// 첫번째 사람의 정보
		member.put("name", "홍길동");
		member.put("age", 100);
		member.put("gender", "남자");
		member.put("nickname", "대도");
		
		// 첫번째 사람의 정보를 배열에 추가!
		memberArray.add(member);
		
		// 두번째 사람의 정보
		member = new JSONObject();
		member.put("name", "홍동");
		member.put("age", 102);
		member.put("gender", "여자");
		member.put("nickname", "대하");
		// 두번째 사람의 정보를 배열에 추가!
		memberArray.add(member);
		
		// 전체 데이터 보유 배열을 객체에 추가
		total.put("members", memberArray);
		
		// 도서정보
		JSONArray bookArray = new JSONArray();
		JSONObject book = new JSONObject();
		book.put("title", "누구나 쉽게 다룰 수 있는 sql 입문");
		book.put("author", "황기훈");
		book.put("price", 30000);
		book.put("image", "http://localhost:9000/html5_jquery/image/image1.jpg");
		bookArray.add(book);
		
		
		book = new JSONObject();
		book.put("title", "간단하게 배우자! 즐거운 java 타임");
		book.put("author", "아사미");
		book.put("price", 23000);
		book.put("image", "http://localhost:9000/html5_jquery/image/image2.jpg");
		bookArray.add(book);
		
		total.put("books", bookArray);
		
		String info = total.toJSONString();
		outPrintWriter.print(info);
	}


}
