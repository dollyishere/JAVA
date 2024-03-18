package com.juju.modifier_test;

public class DataClass {
	static int staticVar=10;
	public int publicVar=100;
	int defaultVar=1000;
	
	static int[] test = new int[3];
	
	public DataClass() {
		// TODO Auto-generated constructor stub
		this.initData();
	}

	private void initData() {
		test[0] = 10;
		test[1] = 20;
		test[2] = 30;
	}
	
	// 이 두 가지 변수는 반드시 객체가 만들어져야 함
	private String name = "dolly";
	private String category = "sheep";

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

}
