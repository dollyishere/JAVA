package com.dolly.cafe;

import java.util.ArrayList;
import java.util.Comparator;

public class MethodClass {
	// CafeClass 객체에서 item만 추출하여 저장할 ArrayList
	private ArrayList<String> items = new ArrayList<String>();
	
	// 위의 items에서 중복 제거된 item들만 저장할 ArrayList
	private ArrayList<String> no = new ArrayList<String>();
	
	// 위의 중복 제거된 item과 count할 수 있도록 각각을 객체화하여 저장할 ArrayList
	private ArrayList<ItemCountClass> item_count_list = new ArrayList<ItemCountClass>();
	
	// 코드 진행 중에는 
	
	// 다른 곳에서 못 건드리게 막기
	public MethodClass() { // 기본 생성자
		// TODO Auto-generated constructor stub
	}
	
	// CafeClass 객체에서 item만 추출하여 저장 메서드
	public void item() {
		for (int n=0; n<DataClass.cafe.size();n++) {
			items.add(DataClass.cafe.get(n).getItem());
		} 
		
		// 또는
//		for (CafeClass cafe : DataClass.cafe) {
//			items.add(cafe.getItem());
//		}
	}
	
	// items 내의 데이터 중복 제거 메서드
	// 	static ArrayList<String> no = new ArrayList<String>();
	public void duplicate() {
		String tempString = ""; // 중복 제거를 위한 임시 저장
		
		// 중복 제거 전 데이터 정렬 : ArrayList.sort()
		items.sort(Comparator.naturalOrder());
		
		for(int n=0; n<items.size(); n++) {
			if (!tempString.equals(items.get(n))) {
				tempString = items.get(n);
				no.add(tempString);
			}
		}
		System.out.println(no);
	} // duplicate() END
	
	// no 내의 item 값과 count 변수를 하나의 객체로 추가 메서드
	// static ArrayList<ItemCountClass> item_count_list = new ArrayList<ItemCountClass>();
	public void item_count_list() {
		for (String item: no) {
			item_count_list.add(new ItemCountClass(item));
		}
	} // item_count_list() END
	
	// ItemCountClass 객체들을 저장한 ArrayList와 전체 데이터를 비교하여 counting하는 메서드
	// 2중 for문
	public void counting() {
		for(ItemCountClass itemObj: item_count_list) {
			for(int idx=0; idx<DataClass.cafe.size(); idx++) {
				if (itemObj.item.equals(DataClass.cafe.get(idx).getItem())) {
					itemObj.count++;
				}
			} // 전체 데이터 순회
		} // 중복 데이터 순회
	} // item_count_list() END

	
	// count 값이 가장 큰 객체를 찾아서 반환
	public ItemCountClass maxItem() {
		// 1. 초기 데이터 로드
		DataClass.initData();
		
		// 2. CafeClass 객체에서 item만 추출하여 저장
		item();
		
		// 3. items 내의 데이터 중복 제거 메서드 호출
		duplicate();
		
		// 4. no 내의 item 값과 count 변수를 하나의 객체로 추가 메서드 호출
		// => item과 count를 한 쌍으로 다루기 위해...
		item_count_list();

		// 5. counting 하는 메서드 호출
		counting();
		
		ItemCountClass tempObj= new ItemCountClass(); // 임시 저장
		
		for(ItemCountClass item: item_count_list) {
			if(tempObj.count < item.count) {
				tempObj.count = item.count;
				tempObj.item = item.item;
			}
		}
		
		return tempObj;
	} // maxItem() END
	
} // MethodClass End
