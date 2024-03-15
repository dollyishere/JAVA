package com.limjy.dto;

// 카페 주문 데이터 오브젝트
public class CafeMenu {
	
	private String orderId = ""; // 주문 아이디
	private String orderDate = ""; // 주문 날짜 및 시간
	private String category = ""; // 주문 종류
	private String item = ""; // 메뉴 이름
	private int price = 0; // 가격

	// 기본 생성자
	public CafeMenu() {

	} // CafeMenu() END
	
	// Override 한 생성자
	public CafeMenu(String orderId, String orderDate, String category, String item, int price) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.category = category;
		this.item = item;
		this.price = price;
	} // Override CafeMenu() END

	// getter 생성
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
