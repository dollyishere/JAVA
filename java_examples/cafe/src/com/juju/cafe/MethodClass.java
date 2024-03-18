package com.juju.cafe;

import java.util.ArrayList;

public class MethodClass {

	public MethodClass() {

	}
	
	public ArrayList<String> searchProduct(String sdate, ArrayList<CafeClass> salesList) {
		// 1. ������ ��¥�� �ش��ϴ� ��ǰ�� ����
		ArrayList<String> productOrders = new ArrayList<String>();
		
		// 2. ��¥ ����
		for (int i=0;i<salesList.size();i++) {  // ��ü ������ �� ��¥���� �����ϱ� ���� for��
			// ���� ��¥�� �˻���¥�� �ش��ϴ� ��¥�� ��, productNames�� ��ǰ�� ����
			if (salesList.get(i).order_date.equals(sdate)) {
				productOrders.add(salesList.get(i).item);
			}
			// ���� �ڵ�
			System.out.println(salesList.get(i).order_date + " : " + salesList.get(i).item);
		}
		
		return productOrders;
	}	// searchProduct() END
		
	// �ߺ� ���ŵ� ����Ʈ
	public ArrayList<String> outDoubleProduct(ArrayList<String> productOrder) {
		// �ߺ� ���ŵ� ����Ʈ
		ArrayList<String> productNames = new ArrayList<String>();
		
		// 2. ��¥ ����
		for (int i=0;i<productOrder.size();i++) {
			// ���� ���� productNames�� �� ��� �ִ� �̸��̸�, ����ֱ�
			if (!productNames.contains(productOrder.get(i))) {
				productNames.add(productOrder.get(i));
			}
			// ���� �ڵ�
			System.out.println(productOrder.get(i));
		}
		
		return productNames;
	} // outDoubleProduct END
	
	// ����Ʈ �����ؼ� �ִ밪 ����
		public int findMaxProduct(ArrayList<String> productOrder, ArrayList<String> productNames) {
			// �ִ밪
			int maxN = 0;
			// ��ǰ��
			String maxI = "";
			
			// productNames ��ȸ
			for (int i=0;i<productNames.size();i++) {
				// ���� ��ǰ �� ����� nowN ����
				int nowN = 0;
				for (int j=0;j<productOrder.size();j++) {
					if (productOrder.get(j).equals(productNames.get(i))) {
						nowN ++;
					}
				}
				// ���� ���� ��ǰ ��ü ���� �ִ� ������ ũ�ٸ�, ��ü
				if (nowN > maxN) {
					maxN = nowN;
					maxI = productNames.get(i);
				}
			}
			
			System.out.println(maxI);
			
			return maxN;
		} // findMaxProduct END
	
}
