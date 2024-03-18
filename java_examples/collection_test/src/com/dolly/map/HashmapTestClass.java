package com.dolly.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashmapTestClass {

	public HashmapTestClass() {

	} // 기본 생성자 END
	
	public static void hashMapTest() {
		// Map은 키와 값이 한쌍 => <key타입, 데이터타입>
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("a", 10);
		m.put("a", 20);
		// 이때 a의 값은 최종적으로 20이 됨
		// 동일한 키 값을 가지게 되면 value를 덮어 써버림
		// 결과적으로 m에는 값이 하나밖에 없음 => ('a', 40)
		m.put("b", 30);
		m.put("c", 40);
		m.put("d", 50);
		
		// 전체 데이터 갯수
		System.out.println(m.size()); // 4
		
		// 특정 데이터 추출: key명으로 추출
		System.out.println(m.get("c")); // 40
		
		// Map의 key명들만 추출 : Map.keySet()
		// => Map.keySet()가 반환 타입이 Set<String>
		Set<String> s = m.keySet();
		List<String> list  = new LinkedList<String>(s);
		for (String key: list) {
			System.out.println(key + " : " + m.get(key));
		}
		
		System.out.println();
		System.out.println("Iterator로 변환하여 출력");
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
