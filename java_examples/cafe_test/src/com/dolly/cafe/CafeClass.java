package com.dolly.cafe;

//���ԵǴ� ������ => ("C38167668", "2017-09-13 10:15", "Coffee", "ī��Ḷ���ƶ�", 5000)
public class CafeClass {
	private String order_id = "";
	private String date = "";
	private String cg = "";
	private String item = "";
	private int pr;
	
	// �⺻ ������
	public CafeClass() {
	}
	
	// �⺻ �����ڸ� Overloading �� ������
	public CafeClass(String id, String date, String cg, String itm, int pr) {
		this.order_id = id;
		this.date = date;
		this.cg = cg;
		this.item = itm;
		this.pr = pr;
	} // Overloading �� ������ END

	// private �����鿡 ���� getter �޼����
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
	// getter �޼���� END
	
	

}
