package com.dolly.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTestClass {

	public HashSetTestClass() {
		// TODO Auto-generated constructor stub
	} // 기본 생성자 END
	
	public static void hashSetTest() {
		HashSet<String> set = new HashSet<String>();
		set.add("test1");
		set.add("test1"); // 중복값 허용하지 않기에 값이 아예 추가되지 않는다!!
		set.add("test2");
		set.add("test3");
		set.add("test4");
		
		System.out.println(set.size()); // 4
		
		/* Set 전체 데이터 추출 */
		/*
		 * 데이터에 대한 index가 없다
		 * Map처럼 Key도 존재하지 않기에
		 * 일단, 데이터는 일렬로 나열해야 한다
		 * => Iterator가 필요
		 * => Iterator는 Set.interator(); 얻어낼 수 있다
		 * Interator 주요 메서드
		 * => next() : 실제 값을 추출할 때
		 * => hasNext() : 추출할 값이 있는지를 확인할 때
		 * */
		
		Iterator<String> iter = set.iterator();
		
		// 값이 있는지 없는지 확인
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// 일단 하나로 쫙 펼친 다음에, 꺼낼 값이 있는지 없는지 먼저 확인하고(.hasNext()), 하나씩 꺼내옴(.next())
		// 그래서 set은 순서를 보장할 수 없음!
		// 보부상이 주머니 안에 상품을 넣을 때는 뒤섞일 수밖에 없음
		// 이걸 일렬로 쫙 늘어놓고 판매한다고 보면 됨
		
		
	} // hashSetTest() END

}
