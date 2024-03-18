package com.dolly.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 필요한 메서드 저장
public class UtilClass {

	// 생성자
	public UtilClass() {

	}
	
	// 줄 단위 데이터를 객체화 후 저장
	/** FileReader와 BufferedReader를 이용하여 txt 파일을 읽어들이는 메서드 **/
	public static void readData(String uri) {
		// 1. 파일 경로 : uri 
		
		// 2. 파일 경로를 이용한 FileReader객체
		FileReader fr =null;
		
		// 3. BufferedReader 객체
		BufferedReader br =null;
		
		try {
			fr = new FileReader(uri);
			br = new BufferedReader(fr);
			//  "C38167668", "2017-09-13 10:15", "Coffee", "카라멜마끼아또", 5000
			
			String one = "";
			while( (one = br.readLine() ) != null ) {
				String[] temp = one.split("\", \"");
	
				// 하나의 객체로 저장
				CafeMenu menu = new CafeMenu(temp[1], temp[2], temp[3], temp[4], temp[5]);
				
				// 전체 데이터 저장소에 추가
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		// 4. while() {  }
		
	} // readData(String uri) END

//	/** String을 이용하여 HTML 태그들을 생성하는 메서드 **/
//	public static String makeHTMLTags() {
//		String tags = "<!doctype html>";
//		tags = tags + "<html>";
//		tags = tags + "<head>";
//		tags = tags + "<meta charset=\"utf-8\">";
//		tags = tags + "<title>Naver News Stand</title>";
//		tags = tags + "</head>";
//		tags = tags + "<body>";
//		for (int i = 0; i < NaverDataClass.news.size(); i++) {
//			tags = tags + "<a href=https://" + NaverDataClass.news.get(i).getUrl() + ">";
//			tags = tags + "<img src=./newsImages/" + NaverDataClass.news.get(i).getImg() + " />";
//		}
//		tags = tags + "</a>";
//		tags = tags + "</body>";
//		tags = tags + "</html>";
//
//		return tags;
//	}
	
	// 초기 실행 및 반복되는 유틸(메뉴 선택 가능하도록)
	


}
