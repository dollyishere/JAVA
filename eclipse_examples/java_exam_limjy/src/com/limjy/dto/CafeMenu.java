package com.limjy.dto;

// ī�� �ֹ� ������ ������Ʈ
public class CafeMenu {
	
	private String orderId = ""; // �ֹ� ���̵�
	private String orderDate = ""; // �ֹ� ��¥ �� �ð�
	private String category = ""; // �ֹ� ����
	private String item = ""; // �޴� �̸�
	private int price = 0; // ����

	// �⺻ ������
	public CafeMenu() {

	} // CafeMenu() END
	
	// Override �� ������
	public CafeMenu(String orderId, String orderDate, String category, String item, int price) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.category = category;
		this.item = item;
		this.price = price;
	} // Override CafeMenu() END

	// getter ����
	public String getOrderId() {
		return orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getCategory() {
		return category;
	}

	public String getItem() {
		return item;
	}

	public int getPrice() {
		return price;
	}
	// getter END

	@Override
	public String toString() {
		return "CafeMenu [orderId=" + orderId + ", orderDate=" + orderDate + ", category=" + category + ", item=" + item
				+ ", price=" + price + "]";
	}
	
	
	
}
