package com.dolly;

// ����� ����
public class WifeClass extends Thread {

	public WifeClass() {
	}

	public void run() {
		synchronized(MainClass.bank) { // ���� �����ϴ� ��ü(MainClass.bank)�� �������� �־���
			MainClass.bank.minusMoney(3000);
		}
		System.out.println("��� �� �ܾ�: " + MainClass.bank.getMoney());
	}
}
