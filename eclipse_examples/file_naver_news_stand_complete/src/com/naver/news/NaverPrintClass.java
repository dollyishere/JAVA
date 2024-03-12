package com.naver.news;

import java.io.FileWriter;
import java.io.IOException;

public class NaverPrintClass {

	public NaverPrintClass() { // 기본 생성자
	} // 생성자 END
	
	
	/** 외부로부터 전달된 문자열을 이용하여 html 파일을 생성하는 메서드 **/
	public static void createHTML(String  uri, String tags) {
		FileWriter fw=null;	// 파일.html 내부에 HTML 태그를 쓰기 위한 객체 저장  
		
		try {
			fw=new FileWriter(uri); 	// 파일 쓰기 객체 생성
			fw.write(tags); 				// tag 들 파일에 적기
			fw.close();					// 파일저장 후, close()
			System.out.println("html 파일 생성 및 저장 성공 ");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	} // makeHTML() END

} // class END




