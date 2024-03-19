package com.limjy.view;

import java.util.Scanner;

import com.limjy.util.UtilClass;

// 출력 담당 클래스
public class PrintClass {

	public PrintClass() {
		
	}
	
	public static void printStart() {
		Scanner sc = new Scanner(System.in);
		
		int key = 1;
		boolean status = true;
		
		while(status) {
			System.out.println("카페 주문 관리 페이지에 접속하셨습니다.");
			System.out.println("이하 메뉴 중 원하시는 항목의 번호를 입력해주세요.");
			
			System.out.println("=====================================");
			System.out.println("- txt 데이터 db에 입력 (1)");
			System.out.println("- 상품명 변경 (2)");
			System.out.println("- 종료 (3)");
			System.out.println("--------------------------------------");
			System.out.println("입력 >> ");
			key = Integer.parseInt(sc.next());
			
			switch(key) {
			case 1:
				// 2. db에 데이터 삽입
				UtilClass.readInsertData();
				System.out.println("데이터 입력이 완료되었습니다.");
				System.out.println();
				break;
			case 2:
				// 4. 상품명 비엔나커피 => 시그니처 커피로 변경
				UtilClass.updateData();
				System.out.println("상품명 변경이 완료되었습니다.");
				System.out.println();
				break;
			default:
				// 5. 종료 시, 기존 테이블 데이터를 모두 삭제한 뒤 결과 메시지 출력
				status = false;
				UtilClass.deleteData();
				break;
			}
		}
	}
	
	public static void printEnd(int cnt) {
		System.out.println("총 " + cnt +"개 레코드가 삭제되었습니다.");
		System.out.println("프로그램이 종료되었습니다.");
	}
}
