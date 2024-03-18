package com.dolly;

// interface
public interface InterfaceClassOne {
	// 상수로 선언됨!!
	public int a = 10;
	
//	public InterfaceClassOne() { // interface는 생성자를 가질 수 없기에 오류 발생!!!
//	}
	
	// interface는 메서드명만 선언 가능!!
	public void test();
	public void test(int a);
	public int test(int a, int b);
	// interface를 구현받는 클래스는 반드시 interface 메서드를 재정의(override)해야 함!!
	// 즉, 강제성을 가지고 있다!!! => 안하면 오류
	
	// 100% 오류 발생
//	public void sum( ) { // interface는 메서드의 {}(블록)을 선언할 수 없다!
//		
//	}
	
}
