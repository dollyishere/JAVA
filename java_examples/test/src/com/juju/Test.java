package com.juju;

public class Test {

	public static void main(String[] args) {
		int[] arr = new int[4];
		int arr2[] = new int[4];
		int num = 0;
		
		for (int i = 0;i<arr.length;i++) {
			num += 10;
			arr[i] = num;
		}
		
		System.out.println(arr.length);
		
		// ��(if)
		// �� ������: >, <, >=, <=, ==, !=
		// �� ������ ����� �Ǵ� -> �� ������: &&, ||, !
		// �׸���, ~�̰� -> &&(AND) => true && true ===> true
		// �Ǵ� -> ||(OR), false || false ===> false
		// true <=> false -> !
//		if(�񱳰� �񱳿����� �񱳰�) { 
//				(�� ������ ����� true�� ��� ������ �ڵ�) 
//			} else {
//				(�� ������ ����� false�� ��� ���� ����)
//			}
		if(10 < 20 && arr[0] > arr[1]) {
			System.out.println("��");
		} else {
			System.out.println("����");
		}
		
		
		/*
		 * ������ 34�� �̻��̸� �� ������ 100����...
		 * age 34 >= if print
		 * */
		int age = 40;
		if (age >= 34) {
			System.out.println("�� ������ 100����");
		}
		
		/*
		 * �� �ҵ��� 300���� �����̰�, ���� �ο��� 2�� �̻��̸� ���� ���� 
		 * # �̷��� ��簡 ����ִ� ��쿡�� ���� ó���� �ؾ� ��~
		 * income 300 <= && household 2 >= print */
		int income = 280;
		int household = 3;

		if (income <= 300 && household >= 2) {
			System.out.println("���ݰ���");
		} else {
			System.out.println("������¡");
		}
		
		// ��������: �ݵ�� �ʱⰪ�� ����
		// for���� �ݺ��Ǵ� �ڵ带 ���̱� ���ؼ���
		int sum = 0;
		sum = sum + arr[0]; // 10
		sum = sum + arr[1]; // 30
		sum = sum + arr[2]; // 60
		sum = sum + arr[3]; // 100
		
		// sum ������ arr �迭�� ��� ���� ����
		for(int i=0; i < arr.length ; i++) {
			sum += arr[i];
		}
		
		for(int n:arr) {
			sum += n;
		}
		
		System.out.println(sum);
		
		// arr �迭�� �� ��, 40�� index ��ȣ ���
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
			if (arr[i] == 40) {
				System.out.println("index:" + i);
			}
		}
		
		// String
		String str;
		String str2 = "��";
		str = "������";
	}
}
