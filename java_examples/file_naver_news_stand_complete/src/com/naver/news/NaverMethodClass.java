package com.naver.news;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** 작업을 위한 메서드들 : 클래스명.메서드() **/
public class NaverMethodClass {

	/** 전체 News 데이터 보유 객체 **/

	public NaverMethodClass() { // 기본 생성자
	} // 생성자 END

	/** 전체 News 데이터 보유 객체 생성 메서드 **/

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
			//  ("경향신문", "nsd16500796.gif", "newsstand.naver.com/032",  "종합지"));
			
			String one = "";
			while( (one = br.readLine() ) != null ) {
				String[] temp = one.split("\", \"");
	
				// 하나의 객체로 저장 => NaverNewsClass
				NaverNewsClass news = new NaverNewsClass(temp[1], temp[2]);
				
				// 전체 데이터 저장소에 추가
				NaverDataClass.news.add(news);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		// 4. while() {  }
		
	} // readData(String uri) END

	/** String을 이용하여 HTML 태그들을 생성하는 메서드 **/
	public static String makeHTMLTags() {
		String tags = "<!doctype html>";
		tags = tags + "<html>";
		tags = tags + "<head>";
		tags = tags + "<meta charset=\"utf-8\">";
		tags = tags + "<title>Naver News Stand</title>";
		tags = tags + "</head>";
		tags = tags + "<body>";
		for (int i = 0; i < NaverDataClass.news.size(); i++) {
			tags = tags + "<a href=https://" + NaverDataClass.news.get(i).getUrl() + ">";
			tags = tags + "<img src=./newsImages/" + NaverDataClass.news.get(i).getImg() + " />";
		}
		tags = tags + "</a>";
		tags = tags + "</body>";
		tags = tags + "</html>";

		return tags;
	}

} // class END
