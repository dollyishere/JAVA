package com.dolly;

// 입금자 역할
public class MeClass extends Thread {

	public MeClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		synchronized(MainClass.bank) { // 실제 실행하는 주체(MainClass.bank)를 조건으로 넣어줌
			MainClass.bank.saveMoney(3000);
		}

		System.out.println("입금 후 잔액: " + MainClass.bank.getMoney());
	}

}
