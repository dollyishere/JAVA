package com.dolly.cafe;

public class CafeMainClass {

	public static void main(String[] args) {
		
		// ��ü ������ �ʿ� ���� (static�� �پ����� �����Ƿ�)
		MethodClass mc = new MethodClass();
		ItemCountClass maxItem = mc.maxItem();
		
		// ���� �ڵ�
		System.out.println("=============================================");
		System.out.println(maxItem.item + " ======> " + maxItem.count);
		
	} // main(String[] args) END

} // CafeMainClass END
