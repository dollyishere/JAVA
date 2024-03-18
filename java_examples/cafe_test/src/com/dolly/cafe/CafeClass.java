package com.dolly.cafe;

//삽입되는 데이터 => ("C38167668", "2017-09-13 10:15", "Coffee", "카라멜마끼아또", 5000)
public class CafeClass {
	private String order_id = "";
	private String date = "";
	private String cg = "";
	private String item = "";
	private int pr;
	
	// 기본 생성자
	public CafeClass() {
	}
	
	// 기본 생성자를 Overloading 한 생성자
	public CafeClass(String id, String date, String cg, String itm, int pr) {
		this.order_id = id;
		this.date = date;
		this.cg = cg;
		this.item = itm;
		this.pr = pr;
	} // Overloading 한 생성자 END

	// private 변수들에 대한 getter 메서드들
	public String getOrder_id() {
		return order_id;
	}

	public String getDate() {
		return date;
	}

	public String getCg() {
		return cg;
	}

	public String getItem() {
		return item;
	}

	public int getPr() {
		return pr;
	}
	// getter 메서드들 END
	
	

}
