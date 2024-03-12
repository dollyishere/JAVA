package split_test;

import java.util.ArrayList;

// 연산을 위한 전용 클래스
public class MethodClass {

	public MethodClass() {

	}

	// 나이합 메서드
	public int sum(MemberClass[] mc) {
		int ageSum = 0;

		for (int m = 0; m < mc.length; m++) {
			ageSum += mc[m].age;
		}

		return ageSum;
	} // sum() END

	// 평균 메서드
	public double avg(int sum, int total) {
		return (double) sum / total;
	} // avg END

	// 이름 검색 메서드 (방문 횟수를 반환)
	public ArrayList<Integer> searchName(MemberClass[] mc, String name) {
		ArrayList<Integer> visit = new ArrayList<Integer>();

		for (int m = 0; m < mc.length; m++) {
			if (mc[m].name.equals(name)) {
				visit.add(mc[m].numVisit);
			}
		}

		return visit;
	} // searchName END

}
