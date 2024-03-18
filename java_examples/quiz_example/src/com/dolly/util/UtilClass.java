package com.dolly.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// �ʿ��� �޼��� ����
public class UtilClass {

	// ������
	public UtilClass() {

	}
	
	// �� ���� �����͸� ��üȭ �� ����
	/** FileReader�� BufferedReader�� �̿��Ͽ� txt ������ �о���̴� �޼��� **/
	public static void readData(String uri) {
		// 1. ���� ��� : uri 
		
		// 2. ���� ��θ� �̿��� FileReader��ü
		FileReader fr =null;
		
		// 3. BufferedReader ��ü
		BufferedReader br =null;
		
		try {
			fr = new FileReader(uri);
			br = new BufferedReader(fr);
			//  "C38167668", "2017-09-13 10:15", "Coffee", "ī��Ḷ���ƶ�", 5000
			
			String one = "";
			while( (one = br.readLine() ) != null ) {
				String[] temp = one.split("\", \"");
	
				// �ϳ��� ��ü�� ����
				CafeMenu menu = new CafeMenu(temp[1], temp[2], temp[3], temp[4], temp[5]);
				
				// ��ü ������ ����ҿ� �߰�
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		// 4. while() {  }
		
	} // readData(String uri) END

//	/** String�� �̿��Ͽ� HTML �±׵��� �����ϴ� �޼��� **/
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
	
	// �ʱ� ���� �� �ݺ��Ǵ� ��ƿ(�޴� ���� �����ϵ���)
	


}
