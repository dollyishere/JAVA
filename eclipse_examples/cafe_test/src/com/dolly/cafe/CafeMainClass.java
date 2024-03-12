package com.dolly.cafe;

public class CafeMainClass {

	public static void main(String[] args) {
		
		// 객체 생성할 필요 있음 (static이 붙어있지 않으므로)
		MethodClass mc = new MethodClass();
		ItemCountClass maxItem = mc.maxItem();
		
		// 검증 코드
		System.out.println("=============================================");
		System.out.println(maxItem.item + " ======> " + maxItem.count);
		
	} // main(String[] args) END

} // CafeMainClass END
