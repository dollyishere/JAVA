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
		
		// ���� ���� ��ü ����
		MethodClass method = new MethodClass();
		int sumA = method.sum(mcArray); // ���� �� �޼��� ȣ��
		double avgA = method.avg(sumA, mcArray.length); // ���� ���� �̿��Ͽ� ��� �޼��� ȣ��
		System.out.println(avgA);
		
		// �̸� �˻��ϱ�
		String name = "����";
		ArrayList<Integer> visit = method.searchName(mcArray, name);
		if (!visit.isEmpty()) {
			System.out.print("\"" + name + "\"" + "(��)��� �̸��� ���� ������ �� " + visit.size() + "���̰�, �� �湮 Ƚ���� ");
			for (int i=0;i<visit.size();i++) {
				System.out.print(visit.get(i) + "ȸ");
				if (i != visit.size()-1) {
					System.out.print(", ");
				}
			}
			System.out.print("�Դϴ�.");
		} else {
			System.out.println("���ǿ� �ش�Ǵ� �湮 ����� �������� �ʽ��ϴ�.");
		}
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(10);
		// aList.add(true); ����Ÿ���� ���������� �����߱⿡ ������ �߻���
		
		ArrayList<MemberClass> aList2 = new ArrayList<MemberClass>();
	}
}
