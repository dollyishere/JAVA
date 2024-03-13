package com.dolly;

// �ϳ��� ���� ����: �Ա�, ��� �޼���
public class BankClass {
	private int money = 10000; //  ���� �ܾ� ����

	public BankClass() {
	}

	public int getMoney() { // �ܾ� ��ȸ
		return money;
	}

	public void setMoney(int money) { // ����ݿ� ���� �ܾ� ����
		this.money = money;
	}
	
	public void saveMoney(int save) { // �Ա� �޼���
		int m = this.money; // �� �ܾ�
		try {
			Thread.sleep(3000); // �Ա� ó�� �ð� 3��
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		this.setMoney(m+save);
	}

	/*
	 * �޼��� ����ȭ ��Ű�� ���
	 * 
	 * 1. �޼��� ����ο� synchronized Ű���� �߰� 
	 * 2. �޼��� ���ο� synchronized(this) { ���೻�� }
	 * 
	 */
	
	public void minusMoney(int minus) { // ��� �޼���
//		synchronized (this) { // ���⼭ this�� �޼��� �ڱ� �ڽ��� ��Ī��
			int m = this.money; // �� �ܾ�
			try {
				Thread.sleep(2000); // ��� ó�� �ð� 2��
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			this.setMoney(m-minus);
		}
//	}
	
}
