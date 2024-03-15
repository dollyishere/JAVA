package com.limjy.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import com.limjy.dao.DaoClass;
import com.limjy.dto.CafeMenu;
import com.limjy.util.UtilClass;

public class PrintClass {

	public PrintClass() {
	
	}
	
	public static void startMenu() {
		Scanner sc = new Scanner(System.in);
		
		/* switch ~ case */
		// switch의 각 case가 가진 값은 다 틀려야 함
		// case는 다 break가 걸려야 함
		int key = 1;
		boolean status = true;
		DaoClass dao = new DaoClass();
		
		while(status) {
			System.out.println("============================================");
			System.out.println("아래 메뉴의 번호를 입력 후, Enter를 누르세요.");
			System.out.println("일일 판매 목록 및 일일 평균 판매액(1)");
			System.out.println("최다 판매 상품과 해당 상품의 총 판매액(2)");
			System.out.println("최다 판매 시간대 및 총 판매액(3)");
			System.out.println("최다 판매 카테고리 및 총 판매액(4)");
			System.out.println("종료(5)");
			System.out.println("--------------------------------------");
			System.out.println("번호 입력>> ");
			key = Integer.parseInt(sc.next());
			
			switch(key) {
			case 1:
				UtilClass.showDayData();
				System.out.println("* info: 날짜 별 카페 목록이 생성되었습니다.");
				System.out.println();
				break;
			case 2:
				System.out.println("최다 판매 상품 및 판매액: " + UtilClass.findMaxItem());
				System.out.println();
				break;
			case 3:
				System.out.println("최다 판매 시간대: " + UtilClass.findMaxTime());
				System.out.println();
				break;
			case 4:
				System.out.println("최다 판매 카테고리 및 판매액: " + UtilClass.findMaxCategory());
				System.out.println();
				break;
			default:
				status = false;
				System.out.println("총 " + dao.countData() + "개 레코드가 삭제되었습니다.");
				dao.deleteAll();
				break;
			} // switch (key) END
		} // while(status) END
		
		sc.close();
		System.out.println("프로그램이 종료되었습니다.");
	} // startMenu() END
	
	// 일일 평균 판매액 출력 메서드
	public static void printAvgDay(LinkedList<String> onlyValues, LinkedList<CafeMenu> orderList) {
		DaoClass dao = new DaoClass();
		
		for (int i = 0; i < onlyValues.size(); i++) {
			System.out.println("* * *");
			System.out.println("#" + onlyValues.get(i) + "일 기준");
			for (int j = 0; j < orderList.size(); j ++) {
				// 해당 날짜일 때만 태그 추가
				if (onlyValues.get(i).equals(orderList.get(j).getOrderDate().substring(0, 11))) {
					System.out.println("-" 
							+ orderList.get(j).getOrderId() + " "
							+ orderList.get(j).getOrderDate() + " "
							+ orderList.get(j).getCategory() + " "
							+ orderList.get(j).getItem() + " "
							+ orderList.get(i).getPrice() + "원");
				}
			}
			System.out.println("============================================");
			System.out.println("$ " + onlyValues.get(i)  + "일일 평균 판매액 ==> " + dao.findCaseAvg(onlyValues.get(i)) + "원");
			System.out.println("");
		}
		
		
	}
	
	/** 외부로부터 전달된 문자열을 이용하여 html 파일을 생성하는 메서드 **/
	public static void createHTML(String  uri, String tags) {
		FileWriter fw=null;	// 파일.html 내부에 HTML 태그를 쓰기 위한 객체 저장  
		try {
			fw = new FileWriter(uri); 	// 파일 쓰기 객체 생성
			fw.write(tags); 				// tag 들 파일에 적기
			fw.close();	// 파일저장 후, close()
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	} // makeHTML() END
	

}
