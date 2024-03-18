package com.dolly.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// 웹 페이지 읽기
public class URLReader {
	
	// 1. 접속 도메인 저장
	URL url; // java.net.~
	
	// 2. 읽은 데이터를 한 줄씩 빠르게 처리
	BufferedReader br;
	
	// 3. 한줄 데이터 저장
	String line;
	
	public URLReader() {
		
	}
	
	// site 도메인명 전달
	public URLReader(String site) {
		try {
			this.url = new URL(site);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 1. 읽은 데이터 출력 메서드
	public void page() {
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(this.url.openStream());
			this.br = new BufferedReader(isr);
			
			while((this.line = br.readLine()) != null) {
				System.out.println(this.line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		
		}
	}
	
	// 2. 읽은 데이터에 대한 기본 정보 출력 메서드 : 인코딩 / 바이트 수
	public void connectInfo() {
		// 내가 가진 url 정보를 통해서 connection을 얻어내는 것?
		try {
			// openConnection 중요
			URLConnection conn = this.url.openConnection();
			// 주로 html5 방식으로 만들어진 것
			System.out.println(conn.getContentEncoding());
			// 주로 html4 방식으로 만들어진 것
			System.out.println(conn.getContentType());
			System.out.println(conn.getContentLength());
			System.out.println(conn.getContentLengthLong());
			System.out.println(conn);
			System.out.println(conn.getURL());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		String site = "https://www.google.com/index.html";
		URLReader url = new URLReader(site);
		url.page();
		url.connectInfo();
	}

}
