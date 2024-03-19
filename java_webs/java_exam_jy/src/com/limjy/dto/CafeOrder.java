package com.limjy.dto;

// 데이터 오브젝트 생성 클래스
public class CafeOrder {
	
	private String orderId = ""; // 주문 ID
	private String orderDate = ""; // 주문 날짜
	private String category = ""; // 카테고리
	private String item = ""; // 상품명
	private int price = 0; // 가격

	// 기본 생성자
	public CafeOrder() {

	} // CafeOrder() END
	
	// Override한 생성자
	public CafeOrder(String orderId, String orderDate, String category, String item, int price) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.category = category;
		this.item = item;
		this.price = price;
	} // Override CafeOrder() END

	// getters
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
		return "CafeOrder [orderId=" + orderId + ", orderDate=" + orderDate + ", category=" + category + ", item=" + item
				+ ", price=" + price + "]";
	}
	
	
	
}
