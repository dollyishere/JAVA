package com.dolly;

// ������ Ŭ���� ��� ���� Ŭ����
public class MyThread extends Thread{

	public MyThread() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		int i=0;
		while(i<100) {
			System.out.println(i);
			i++;
		}
	}

}
