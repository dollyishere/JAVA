package com.dolly;

// �Ա��� ����
public class MeClass extends Thread {

	public MeClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		synchronized(MainClass.bank) { // ���� �����ϴ� ��ü(MainClass.bank)�� �������� �־���
			MainClass.bank.saveMoney(3000);
		}

		System.out.println("�Ա� �� �ܾ�: " + MainClass.bank.getMoney());
	}

}
