package com.dolly;

public class MainClass {
	
	public static BankClass bank = new BankClass();

	public static void main(String[] args) {
		System.out.println("현재 잔액: " + bank.getMoney());
		
		MeClass me = new MeClass();
		WifeClass wife = new WifeClass();
		// 동기화 전 (비동기)
		/*
		 * - 결과 
		 * 현재 잔액: 10000 입금 후 잔액: 13000 출금 후 잔액: 7000
		 */
		me.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		wife.start();
	}

}
