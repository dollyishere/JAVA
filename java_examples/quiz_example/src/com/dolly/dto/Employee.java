package com.dolly.dto;

//하나의 레코드를 객체화시키는 클래스

//필드명
//empNo  : 사원 고유번호
//empName  : 사원이름
//job  : 직급
//mgr  : 직급번호
//hireDate  : 입사일
//sale  : 급여
//commission : 성과급
//deptNo  : 부서번호
public class Employee {
	private int empNo = 0; // 사원 고유번호
	private String empName = ""; // 사원 이름
	private String job = ""; // 직급
	private String mgr = ""; // 직급 번호
	private String hireDate = ""; // 입사일
	private int sale = 0; // 급여
	private int commission = 0; // 성과급
	private int deptNo = 0; // 부서번호

	// 기본 생성자
	public Employee() {
		
	} // 기본 생성자 END
	
	// 기본 생성자 Overloading
	public Employee(int empNo, String empName, String job, String mgr, String hireDate, int sale, int commission, int deptNo) {
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sale = sale;
		this.deptNo = deptNo;
	} // Overloading 생성자 END

	// private 변수 대응 getter
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

	// private 변수 대응 getter END
	
}
