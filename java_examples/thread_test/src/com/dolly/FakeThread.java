package com.dolly;

// 스레드 클래스 상속 받지 않은 클래스
public class FakeThread {

	public FakeThread() {

	}
	
	public void start() {
		run();
	}
	
	public void run() {
		int i=0;
		while(i<100) {
			System.out.println(i);
			i++;
		}
	}

}
