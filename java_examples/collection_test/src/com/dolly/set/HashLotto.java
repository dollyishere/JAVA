package com.dolly.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class HashLotto {

	public HashLotto() {
		// TODO Auto-generated constructor stub
	} // �⺻ ������ END
	
	public static void lotto() {
		HashSet<Integer> numbers = new HashSet<Integer>();
		
		// �ζ� ��ȣ: 6�� ���� (������: random)
		// 1. ���п� ���õ� ��� �޼��带 ������ �ִ� Math.random()�� ����ϴ� ��
		// 		=> 0 ~ 1 ������ �Ǽ��� ��ȯ
		// 		(int)(Math.random() * 45 + 1)
		// 2. Random.class
		// 	  Random ��ü�� ���� ��������� ��
		// 	  Random r = new Random();
		//    r.nextInt(45); <= 0~44 ���� �� ������ ������ ��ȯ
		
		// �޼��峪 ��ü�� �ٰ��� ������ ������ �༮�̶�� ��
		for (int n=0; n<6; n++) {
			// Math.random()�� �Ǽ� ���� �����س��Ƿ�, 45�����ְ�, 1�� �����ֱ�
			// �ƴϸ� 1�� �� ����Ʈ ��
			int num = (int)(Math.random()*45+1);
			System.out.println(num);
			numbers.add(new Integer(num)); // delete
		}
		
		// HashSet�� LinkedList�� ��ȯ
		// linkedList ���� hashset�� �ְ� �Ǹ� �˾Ƽ� �ڵ� ��ȯ����(�ε��� ��ȣ �ο��ϴ� ��)
		List<Integer> list = new LinkedList<Integer>(numbers);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
	} // lotto() END
	


}
