package com.dolly.list;

import java.util.LinkedList;

public class LinkedListTestClass {

	public LinkedListTestClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void linkedListTest() {
		LinkedList<String> list = new LinkedList<String>();
		// 맨 뒤에 데이터 추가
		// list는 중복값 허용 (인덱스로 값을 구분하기 때문)
		list.add("apple");
		list.add("orange");
		list.add("orange");
		list.add("peach");
		
		// 특정 위치에 데이터 추가
		list.add(1, "kiwi"); // list.add(인덱스 번호, 추가하고 싶은 데이터);
		// 0: apple, 1: kiwi, 2: orange, 3: orange, 4: peach
		
		// 특정 위치의 데이터 변경
		list.set(3, "melon"); // list.set(인덱스 번호, 바꾸고 싶은 데이터);
		// 0: apple, 1: kiwi, 2: orange, 3: melon, 4: peach
		
		// 특정 위치의 값을 제거하고 반환
		String f= list.remove(3);
		System.out.println("now remove: " + f);
		// f: melon
		// 0: apple, 1: kiwi, 2: orange, 3: peach
		
		// 특정 데이터를 이용하여 해당 index 추출
		int idx = list.indexOf("apple");
		// idx: 0
		
		list.add("apple");
		// 0: apple, 1: kiwi, 2: orange, 3: peach, 4: apple
		idx = list.lastIndexOf("apple");
		// idx: 4
		
		// 전체 데이터 조회 1
		for(String fu : list) {
			System.out.println(fu);
		}
		
		// 전체 데이터 조회 2
		// 인덱스 번호까지 써야하는 상황이면 이쪽이 좋음
		for(int index=0;index<list.size();index++) {
			System.out.println(list.get(index));
		}
		
		// 전체 데이터 역순 조회
		int n = list.size() - 1;
		for(int index=n;index>-1;index--) {
			System.out.println(index + " : " +list.get(index));
		}
	} // linkedListTest() END

}
