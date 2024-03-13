package com.dolly;

// 스레드 클래스 상속 받은 클래스
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
