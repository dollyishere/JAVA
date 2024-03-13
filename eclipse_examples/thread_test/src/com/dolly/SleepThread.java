package com.dolly;

// ������ ��� ����ٰ� �����ϴ�(Sleep) Ŭ����
public class SleepThread extends Thread {

	public SleepThread() {

	} // SleepThread() END
	
	public void run() {
		System.out.println("sleep Start!");
		try {
			Thread.sleep(2000); // 1/1000�� (1���� �������� �� �ʱⰪ)
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("sleep END!");
	}
	
	

}
