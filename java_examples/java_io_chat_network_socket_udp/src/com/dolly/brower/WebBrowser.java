package com.dolly.brower;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebBrowser {

	// 자바에서 웹 브라우저 실행 가능!
	public static void main(String[] args) {
		// 데스크탑에 정보 불러오기 위한 클래스
		// 외부 접속이기에 try-catch 필요
		// URI: 접속할 주소를 하나의 객체로 생성 시
		try {
			Desktop.getDesktop().browse(new URI("https://www.naver.com"));
		} catch (IOException | URISyntaxException e) {
			System.out.println(e.getMessage());
		}
	}

}
