package com.juju.cafe;

import java.util.ArrayList;

public class CafeMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ������ �غ�
		DataClass dc = new DataClass();

		// 2. �˻� ��¥ ���� ����
		String date = "2017-09-13";
		
		// 3. �˻� �޼��� ȣ��
		MethodClass mc = new MethodClass();
		ArrayList<String> productOrders = mc.searchProduct(date, dc.salesList);
		
		// 4. ����� ��ǰ ����Ʈ�� �̿��Ͽ� �ߺ� ���ŵ� ����Ʈ ����
		ArrayList<String> productNames = mc.outDoubleProduct(productOrders);
		
		// 5. �ߺ� ���ŵ� ����Ʈ�� ����� ��ǰ ����Ʈ�� ���ϸ鼭 �ش� ��ǰ�� ���� ī����
		
		// 6. ī���õ� ����� �̿��Ͽ� ����
		
		// 7. ��� ���
		System.out.println(mc.findMaxProduct(productOrders, productNames));
		// ������ ���ߴ�~~~~~~~~
	}

}
