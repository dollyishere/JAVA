package com.dolly.map;

public class Student {
	private int no;
	private String name;

	public Student() {
		// TODO Auto-generated constructor stub
	} // �⺻ ������ END
	
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	} // overriding ������ END

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + "]";
	}
	
}
