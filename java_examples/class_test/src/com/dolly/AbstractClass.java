package com.dolly;

// ����ο� abstract�� �ݵ�� �ʿ�
public abstract class AbstractClass {
	public int var = 1000; // �Ϲ� ����
	public final int var2 =200; // ���
	
	public AbstractClass() { // ������
		System.out.println("AbstractClass() ������ ȣ���!");
	}

	public void test() { // �Ϲ� �޼��� ����
		
	}
	
	// �޼��� �� ���� ����
	public abstract void sum(); // �߻� �޼���� ����
}
