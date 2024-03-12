package com.dolly;

// abstract 클래스는 상속에서만 사용 가능!
public class ExtendsAbstractClass extends AbstractClass{

	public ExtendsAbstractClass() {
		System.out.println("ExtraAbstractClass() 생성자 호출됨");
	}

	@Override
	public void sum() {
		// AbstractClass 내의 추상메서드는 반드시 재정의가 필요!
	}
	
	// 메서드 재정의: 메서드 선언부를 수정할 수 없고
	// 				  재정의된 메서드의 {} 내부만 수정 가능
	public void sum(int a) {
		
	}
}
