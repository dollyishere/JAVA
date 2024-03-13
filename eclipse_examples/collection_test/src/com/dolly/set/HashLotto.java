package com.dolly.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class HashLotto {

	public HashLotto() {
		// TODO Auto-generated constructor stub
	} // 기본 생성자 END
	
	public static void lotto() {
		HashSet<Integer> numbers = new HashSet<Integer>();
		
		// 로또 번호: 6개 숫자 (임의의: random)
		// 1. 수학에 관련된 모든 메서드를 가지고 있는 Math.random()을 사용하는 것
		// 		=> 0 ~ 1 사이의 실수를 반환
		// 		(int)(Math.random() * 45 + 1)
		// 2. Random.class
		// 	  Random 객체를 먼저 생성해줘야 함
		// 	  Random r = new Random();
		//    r.nextInt(45); <= 0~44 정수 중 임의의 정수가 반환
		
		// 메서드나 객체에 줄가면 앞으로 없어질 녀석이라는 뜻
		for (int n=0; n<6; n++) {
			// Math.random()이 실수 값을 배출해내므로, 45곱새주고, 1을 더해주기
			// 아니면 1만 들어간 리스트 됨
			int num = (int)(Math.random()*45+1);
			System.out.println(num);
			numbers.add(new Integer(num)); // delete
		}
		
		// HashSet을 LinkedList로 변환
		// linkedList 내에 hashset을 넣게 되면 알아서 자동 변환해줌(인덱스 번호 부여하는 등)
		List<Integer> list = new LinkedList<Integer>(numbers);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
	} // lotto() END
	


}
