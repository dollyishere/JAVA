package com.juju.cafe;

import java.util.ArrayList;

public class CafeMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 데이터 준비
		DataClass dc = new DataClass();

		// 2. 검색 날짜 저장 변수
		String date = "2017-09-13";
		
		// 3. 검색 메서드 호출
		MethodClass mc = new MethodClass();
		ArrayList<String> productOrders = mc.searchProduct(date, dc.salesList);
		
		// 4. 저장된 상품 리스트를 이용하여 중복 제거된 리스트 생성
		ArrayList<String> productNames = mc.outDoubleProduct(productOrders);
		
		// 5. 중복 제거된 리스트와 저장된 상품 리스트를 비교하면서 해당 상품에 대한 카운팅
		
		// 6. 카운팅된 결과를 이용하여 정렬
		
		// 7. 결과 출력
		System.out.println(mc.findMaxProduct(productOrders, productNames));
		// 설계대로 안했다~~~~~~~~
	}

}
