package com.juju.employee;

public class EMPMainClass {

	public static void main(String[] args) {
		// EMPDataClass ����
		EMPDataClass emp = new EMPDataClass();
		
		// ���� "��"���� ����� �ο� ��?
		/*
		 * 1. emp ��ü�� �ʿ�
		 * 2. emp ��ü�� ���� name �迭
		 * 3. name �迭�� ������ �� "��"�� �����ϴ� ������ ã�� 
		 * 		String ��ü�� �޼��带 �̿��Ͽ� �˻�
		 * 4. �ο��� ���� ���� => int startSum = 0;
		 * 5. for�� name �迭 ��ȸ => for()
		 * 6. ���� name ���� "��"�� �����ϴ� ��ü�� �ִٸ�, ī���� => if()
		 *  */
		
		String startStr = "��";
		int count = 0;
		for (int k=0; k < emp.name.length; k++) {
			if(emp.name[k].startsWith(startStr)) {
				count ++;
			}
		}
		
		System.out.println("'" + startStr + "'" + "�� ���� ���� �ο� ��: " + count);
		
		// ������ Java�̰� �ٹ����� ������ ����� ��� �޿� ���ϱ�
		/*
		 * 1. emp ��ü�� job, code(�� �� ����), pay(������ �� �뵵) �迭 => for()
		 * 2. job �迭���� Java�� �������� ���� ����� �ε��� ã�� ==> if()
		 * 3. code�� �ش��ϴ� �ε����� �����ؼ� �ش� ����� ����("KR")���� ���ϴ��� ���� ==> &&, equals
		 * 4. ����̸� ������ �����̶� ���� ����ȭ ==> String countJob, String countCode
		 * 5. java �������� ���� ��� �� ī���� => int countJ = 0; ==> �� �ʱ�ȭ
		 * 6. java �������� ���� ����� �޿� ī���� => int payJ = 0; ==> �� �ʱ�ȭ
		 * 7. ��� �޿� ���ϱ� ==> double payA; ==> �׳� �ٷ� �� �������ְų� �̸� ���ְų�~
		 * 8. �� ���
		 * */
		
		int countJ = 0;
		int payJ = 0;
		double payA;
		
		String countJob = "java";
		String countCode = "JP";
		
		for (int n=0;n<emp.job.length;n++) {
			if (emp.job[n].equals(countJob) && emp.code[n].equals(countCode)) {
				countJ ++;
				payJ += emp.pay[n];
			}
		}
		
		payA = (float) payJ / countJ;
		
		System.out.println(countJob + " �����̰� " + countCode + "�� �ٹ��ϴ� ����� ��� �޿�: " + payA);
	}
	

	
}
