package com.juju.cafe;

import java.util.ArrayList;

public class MethodClass {

	public MethodClass() {

	}
	
	public ArrayList<String> searchProduct(String sdate, ArrayList<CafeClass> salesList) {
		// 1. 지정된 날짜에 해당하는 상품명 저장
		ArrayList<String> productOrders = new ArrayList<String>();
		
		// 2. 날짜 추출
		for (int i=0;i<salesList.size();i++) {  // 전체 데이터 중 날짜들을 추출하기 위한 for문
			// 만약 날짜가 검색날짜에 해당하는 날짜일 시, productNames에 상품명 저장
			if (salesList.get(i).order_date.equals(sdate)) {
				productOrders.add(salesList.get(i).item);
			}
			// 검증 코드
			System.out.println(salesList.get(i).order_date + " : " + salesList.get(i).item);
		}
		
		return productOrders;
	}	// searchProduct() END
		
	// 중복 제거된 리스트
	public ArrayList<String> outDoubleProduct(ArrayList<String> productOrder) {
		// 중복 제거된 리스트
		ArrayList<String> productNames = new ArrayList<String>();
		
		// 2. 날짜 추출
		for (int i=0;i<productOrder.size();i++) {
			// 만약 아직 productNames에 안 담겨 있는 이름이면, 담아주기
			if (!productNames.contains(productOrder.get(i))) {
				productNames.add(productOrder.get(i));
			}
			// 검증 코드
			System.out.println(productOrder.get(i));
		}
		
		return productNames;
	} // outDoubleProduct END
	
	// 리스트 대조해서 최대값 리턴
		public int findMaxProduct(ArrayList<String> productOrder, ArrayList<String> productNames) {
			// 최대값
			int maxN = 0;
			// 상품명
			String maxI = "";
			
			// productNames 순회
			for (int i=0;i<productNames.size();i++) {
				// 현재 상품 수 담아줄 nowN 생성
				int nowN = 0;
				for (int j=0;j<productOrder.size();j++) {
					if (productOrder.get(j).equals(productNames.get(i))) {
						nowN ++;
					}
				}
				// 만약 현재 상품 전체 수가 최대 값보다 크다면, 대체
				if (nowN > maxN) {
					maxN = nowN;
					maxI = productNames.get(i);
				}
			}
			
			System.out.println(maxI);
			
			return maxN;
		} // findMaxProduct END
	
}
