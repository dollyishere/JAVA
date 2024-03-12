package com.juju.cafe;

// 삽입되는 데이터 => ("C38167668", "2017-09-13 10:15", "Coffee", "카라멜마끼아또", 5000)
public class CafeClass {
	String order_id, order_date, category, item;
	int price;
	
	// 생성자도 매개 변수를 받을 수 있음!
	public CafeClass(String id, String date, String cg, String itm, int pr) {
		// 각 속성에 맞게 데이터 삽입
		order_id = id;
		// String temp = date.substring(11); // "2019-09-13 10:15" ==> "10:15"
		order_date = date.substring(0, 10); // "2017-09-13 10:15" ==> "2017-09-13"
		category = cg;
		item = itm;
		price = pr;
	}

}
