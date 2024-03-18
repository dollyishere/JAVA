package com.dolly.list;

import java.util.LinkedList;

public class LinkedListTestClass {

	public LinkedListTestClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void linkedListTest() {
		LinkedList<String> list = new LinkedList<String>();
		// �� �ڿ� ������ �߰�
		// list�� �ߺ��� ��� (�ε����� ���� �����ϱ� ����)
		list.add("apple");
		list.add("orange");
		list.add("orange");
		list.add("peach");
		
		// Ư�� ��ġ�� ������ �߰�
		list.add(1, "kiwi"); // list.add(�ε��� ��ȣ, �߰��ϰ� ���� ������);
		// 0: apple, 1: kiwi, 2: orange, 3: orange, 4: peach
		
		// Ư�� ��ġ�� ������ ����
		list.set(3, "melon"); // list.set(�ε��� ��ȣ, �ٲٰ� ���� ������);
		// 0: apple, 1: kiwi, 2: orange, 3: melon, 4: peach
		
		// Ư�� ��ġ�� ���� �����ϰ� ��ȯ
		String f= list.remove(3);
		System.out.println("now remove: " + f);
		// f: melon
		// 0: apple, 1: kiwi, 2: orange, 3: peach
		
		// Ư�� �����͸� �̿��Ͽ� �ش� index ����
		int idx = list.indexOf("apple");
		// idx: 0
		
		list.add("apple");
		// 0: apple, 1: kiwi, 2: orange, 3: peach, 4: apple
		idx = list.lastIndexOf("apple");
		// idx: 4
		
		// ��ü ������ ��ȸ 1
		for(String fu : list) {
			System.out.println(fu);
		}
		
		// ��ü ������ ��ȸ 2
		// �ε��� ��ȣ���� ����ϴ� ��Ȳ�̸� ������ ����
		for(int index=0;index<list.size();index++) {
			System.out.println(list.get(index));
		}
		
		// ��ü ������ ���� ��ȸ
		int n = list.size() - 1;
		for(int index=n;index>-1;index--) {
			System.out.println(index + " : " +list.get(index));
		}
	} // linkedListTest() END

}
