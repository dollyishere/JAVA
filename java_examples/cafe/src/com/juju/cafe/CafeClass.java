package com.juju.cafe;

// ���ԵǴ� ������ => ("C38167668", "2017-09-13 10:15", "Coffee", "ī��Ḷ���ƶ�", 5000)
public class CafeClass {
	String order_id, order_date, category, item;
	int price;
	
	// �����ڵ� �Ű� ������ ���� �� ����!
	public CafeClass(String id, String date, String cg, String itm, int pr) {
		// �� �Ӽ��� �°� ������ ����
		order_id = id;
		// String temp = date.substring(11); // "2019-09-13 10:15" ==> "10:15"
		order_date = date.substring(0, 10); // "2017-09-13 10:15" ==> "2017-09-13"
		category = cg;
		item = itm;
		price = pr;
	}

}
