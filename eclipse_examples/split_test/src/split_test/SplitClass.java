package split_test;

import java.util.ArrayList;

public class SplitClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataClass dc = new DataClass();

		MemberClass[] mcArray = new MemberClass[98];
		
		for (int m=0;m<mcArray.length;m++) {
			mcArray[m] = new MemberClass();
			mcArray[m].inputRecord(dc.member[m]);
		}
		
		// 연산 전용 객체 생성
		MethodClass method = new MethodClass();
		int sumA = method.sum(mcArray); // 나이 합 메서드 호출
		double avgA = method.avg(sumA, mcArray.length); // 나이 합을 이용하여 평균 메서드 호출
		System.out.println(avgA);
		
		// 이름 검색하기
		String name = "동현";
		ArrayList<Integer> visit = method.searchName(mcArray, name);
		if (!visit.isEmpty()) {
			System.out.print("\"" + name + "\"" + "(이)라는 이름을 지닌 고객님은 총 " + visit.size() + "명이고, 각 방문 횟수는 ");
			for (int i=0;i<visit.size();i++) {
				System.out.print(visit.get(i) + "회");
				if (i != visit.size()-1) {
					System.out.print(", ");
				}
			}
			System.out.print("입니다.");
		} else {
			System.out.println("조건에 해당되는 방문 기록이 존재하지 않습니다.");
		}
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(10);
		// aList.add(true); 예약타입을 정수형으로 선언했기에 오류가 발생함
		
		ArrayList<MemberClass> aList2 = new ArrayList<MemberClass>();
	}
}
