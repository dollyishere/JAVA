package com.dolly.cafe;

public class ItemCountClass {
	// item 명과 count 값을 하나의 객체로 ...
	String item = "";
	int count = 0;

	public ItemCountClass() { // 기본 생성자
		// TODO Auto-generated constructor stub
	}
	
	public ItemCountClass(String item) { // overloading 생성자
		this.item = item;
	}

}
