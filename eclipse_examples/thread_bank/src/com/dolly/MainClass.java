package com.dolly;

public class MainClass {
	
	public static BankClass bank = new BankClass();

	public static void main(String[] args) {
		System.out.println("���� �ܾ�: " + bank.getMoney());
		
		MeClass me = new MeClass();
		WifeClass wife = new WifeClass();
		// ����ȭ �� (�񵿱�)
		/*
		 * - ��� 
		 * ���� �ܾ�: 10000 �Ա� �� �ܾ�: 13000 ��� �� �ܾ�: 7000
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
