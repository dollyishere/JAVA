package com.dolly;

// 스레드 잠시 멈췄다가 실행하는(Sleep) 클래스
public class SleepThread extends Thread {

	public SleepThread() {

	} // SleepThread() END
	
	public void run() {
		System.out.println("sleep Start!");
		try {
			Thread.sleep(2000); // 1/1000초 (1으로 지정했을 시 초기값)
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("sleep END!");
	}
	
	

}
