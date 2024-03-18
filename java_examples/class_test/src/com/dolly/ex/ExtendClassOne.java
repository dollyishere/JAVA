package com.dolly.ex;

// ParentClassOne를 물려받을 클래스    // new ParentClassOne()이 먼저 실행됨
public class ExtendClassOne extends ParentClassOne {

	
	public ExtendClassOne() {
		System.out.println("ExtendClassOne() 생성자 호출됨");
	}

}
