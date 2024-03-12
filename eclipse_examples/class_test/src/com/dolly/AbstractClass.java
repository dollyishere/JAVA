package com.dolly;

// 선언부에 abstract이 반드시 필요
public abstract class AbstractClass {
	public int var = 1000; // 일반 변수
	public final int var2 =200; // 상수
	
	public AbstractClass() { // 생성자
		System.out.println("AbstractClass() 생성자 호출됨!");
	}

	public void test() { // 일반 메서드 선언
		
	}
	
	// 메서드 명만 선언 가능
	public abstract void sum(); // 추상 메서드명 선언
}
