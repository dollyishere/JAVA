package split_test;

public class MemberClass {
	String name;       	// �̸�
	String joinDate;   	// ������
	String lastVisitDate;  // �����湮��
	int numVisit;	// �湮Ƚ��
	String gender;         // ����
	int age;         	// ���ɴ�
	
	public MemberClass() {
		// TODO Auto-generated constructor stub
	}
	
	// �Ű�����
	public void inputRecord(String rawData) {
		// String.split("������) ==> String[]�� ��ȯ
		String[] split = rawData.split(",");
		
		name = split[0];
		joinDate = split[1];
		lastVisitDate = split[2];
		numVisit = Integer.parseInt(split[3]);
		gender = split[4];
		
		// String.substring(���� �ε���, �� �ε���)
		String temp = split[5].substring(0, 2);
		
		// "�����" ������ ó��
		if (temp.equals("���")) {
			temp = "0";
		}
		
		age = Integer.parseInt(temp);
	}
}
