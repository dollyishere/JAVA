package com.juju.modifier_test;

import com.jujumoidifier.test.MethodClass;

public class MainClass {

	public static void main(String[] args) {
		TestClass test = new TestClass();
		MethodClass mc = new MethodClass();
		
		DataClass dc = new DataClass();
		System.out.println(dc.getName());
		
		System.out.println(dc.getCategory());
		dc.setCategory("dog");
		System.out.println(dc.getCategory());
		
		
//		DataClass dc1 = new DataClass();
//		DataClass dc2 = new DataClass();
//		
//		dc1.defaultVar = 20000;
//		dc1.staticVar = 30000;
//		
//		DataClass.initData();
//		System.out.println(DataClass.test[0]);
		
//		System.out.println(dc1.staticVar + " : " + dc2.staticVar);
//		System.out.println(dc1.defaultVar + " : " + dc2.defaultVar);
	}

}
