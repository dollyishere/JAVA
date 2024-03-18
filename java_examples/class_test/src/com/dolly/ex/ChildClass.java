package com.dolly.ex;

public class ChildClass extends ParentClassOne {
	int cVar = 10; // default
	public String cString = "child";
	private boolean cBool = true;
	protected float cFloat = 0.0003F;
	
	public ChildClass() {
		// TODO Auto-generated constructor stub
		System.out.println("ChildClass() 생성자 호출됨");
	}

}
