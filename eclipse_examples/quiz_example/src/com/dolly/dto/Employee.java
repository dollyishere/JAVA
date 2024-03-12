package com.dolly.dto;

//�ϳ��� ���ڵ带 ��üȭ��Ű�� Ŭ����

//�ʵ��
//empNo  : ��� ������ȣ
//empName  : ����̸�
//job  : ����
//mgr  : ���޹�ȣ
//hireDate  : �Ի���
//sale  : �޿�
//commission : ������
//deptNo  : �μ���ȣ
public class Employee {
	private int empNo = 0; // ��� ������ȣ
	private String empName = ""; // ��� �̸�
	private String job = ""; // ����
	private String mgr = ""; // ���� ��ȣ
	private String hireDate = ""; // �Ի���
	private int sale = 0; // �޿�
	private int commission = 0; // ������
	private int deptNo = 0; // �μ���ȣ

	// �⺻ ������
	public Employee() {
		
	} // �⺻ ������ END
	
	// �⺻ ������ Overloading
	public Employee(int empNo, String empName, String job, String mgr, String hireDate, int sale, int commission, int deptNo) {
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sale = sale;
		this.deptNo = deptNo;
	} // Overloading ������ END

	// private ���� ���� getter
	public int getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public String getJob() {
		return job;
	}

	public String getMgr() {
		return mgr;
	}

	public String getHireDate() {
		return hireDate;
	}

	public int getSale() {
		return sale;
	}

	public int getCommission() {
		return commission;
	}

	public int getDeptNo() {
		return deptNo;
	}

	// private ���� ���� getter END
	
}
