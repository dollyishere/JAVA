package com.dolly.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashmapTestClass {

	public HashmapTestClass() {

	} // �⺻ ������ END
	
	public static void hashMapTest() {
		// Map�� Ű�� ���� �ѽ� => <keyŸ��, ������Ÿ��>
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("a", 10);
		m.put("a", 20);
		// �̶� a�� ���� ���������� 20�� ��
		// ������ Ű ���� ������ �Ǹ� value�� ���� �����
		// ��������� m���� ���� �ϳ��ۿ� ���� => ('a', 40)
		m.put("b", 30);
		m.put("c", 40);
		m.put("d", 50);
		
		// ��ü ������ ����
		System.out.println(m.size()); // 4
		
		// Ư�� ������ ����: key������ ����
		System.out.println(m.get("c")); // 40
		
		// Map�� key��鸸 ���� : Map.keySet()
		// => Map.keySet()�� ��ȯ Ÿ���� Set<String>
		Set<String> s = m.keySet();
		List<String> list  = new LinkedList<String>(s);
		for (String key: list) {
			System.out.println(key + " : " + m.get(key));
		}
		
		System.out.println();
		System.out.println("Iterator�� ��ȯ�Ͽ� ���");
		Iterator<String> iter = s.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + " : " + m.get(key));
		}
		
	} // hashMapTest() END

	public static void hashMapStudent() {
		Map<String, Student> m = new HashMap<String, Student>();
		
		m.put("a", new Student(10, "test1"));
		m.put("c", new Student(30, "test3"));
		m.put("b", new Student(20, "test4"));
		m.put("d", new Student(40, "test2"));
		
		System.out.println(m);
		
		Set<String> s = m.keySet();
		List<String> list = new LinkedList<String>(s);
		
		for(String key : list) {
			System.out.println(m.get(key));
		}
		
		
	} // hashMapStudent() END
}
