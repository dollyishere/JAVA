package com.dolly.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTestClass {

	public HashSetTestClass() {
		// TODO Auto-generated constructor stub
	} // �⺻ ������ END
	
	public static void hashSetTest() {
		HashSet<String> set = new HashSet<String>();
		set.add("test1");
		set.add("test1"); // �ߺ��� ������� �ʱ⿡ ���� �ƿ� �߰����� �ʴ´�!!
		set.add("test2");
		set.add("test3");
		set.add("test4");
		
		System.out.println(set.size()); // 4
		
		/* Set ��ü ������ ���� */
		/*
		 * �����Ϳ� ���� index�� ����
		 * Mapó�� Key�� �������� �ʱ⿡
		 * �ϴ�, �����ʹ� �Ϸķ� �����ؾ� �Ѵ�
		 * => Iterator�� �ʿ�
		 * => Iterator�� Set.interator(); �� �� �ִ�
		 * Interator �ֿ� �޼���
		 * => next() : ���� ���� ������ ��
		 * => hasNext() : ������ ���� �ִ����� Ȯ���� ��
		 * */
		
		Iterator<String> iter = set.iterator();
		
		// ���� �ִ��� ������ Ȯ��
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// �ϴ� �ϳ��� �� ��ģ ������, ���� ���� �ִ��� ������ ���� Ȯ���ϰ�(.hasNext()), �ϳ��� ������(.next())
		// �׷��� set�� ������ ������ �� ����!
		// ���λ��� �ָӴ� �ȿ� ��ǰ�� ���� ���� �ڼ��� ���ۿ� ����
		// �̰� �Ϸķ� �� �þ���� �Ǹ��Ѵٰ� ���� ��
		
		
	} // hashSetTest() END

}
