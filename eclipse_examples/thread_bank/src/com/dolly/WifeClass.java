package com.dolly;

// 출금자 역할
public class WifeClass extends Thread {

	public WifeClass() {
	}

	public void run() {
		synchronized(MainClass.bank) { // 실제 실행하는 주체(MainClass.bank)를 조건으로 넣어줌
			MainClass.bank.minusMoney(3000);
		}
		System.out.println("출금 후 잔액: " + MainClass.bank.getMoney());
	}
}
