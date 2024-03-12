package com.dolly.ex;

public class ParentClassOne {
	int pVar = 10; // default
	public String pString = "parent";
	private boolean pBool = true;
	protected float pFloat = 0.0003F;
	
	public ParentClassOne() {
		// TODO Auto-generated constructor stub
		System.out.println("ParentClassOne() »ý¼ºÀÚ È£ÃâµÊ!");
	}
	
	public void pMethod() {
		System.out.println("Parent pMethod() È£ÃâµÊ");
	}

}
