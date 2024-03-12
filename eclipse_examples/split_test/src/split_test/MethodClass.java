package split_test;

import java.util.ArrayList;

// ������ ���� ���� Ŭ����
public class MethodClass {

	public MethodClass() {

	}

	// ������ �޼���
	public int sum(MemberClass[] mc) {
		int ageSum = 0;

		for (int m = 0; m < mc.length; m++) {
			ageSum += mc[m].age;
		}

		return ageSum;
	} // sum() END

	// ��� �޼���
	public double avg(int sum, int total) {
		return (double) sum / total;
	} // avg END

	// �̸� �˻� �޼��� (�湮 Ƚ���� ��ȯ)
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
