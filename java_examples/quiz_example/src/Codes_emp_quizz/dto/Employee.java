package com.freeflux.dto;

public class Employee {

	private int empNo = 0; // 사원 고유번호
	private String empName = ""; // 사원이름
	private String job = ""; // 직급
	private String mgr = ""; // 직급번호
	private String hireDate = ""; // 입사일
	private int sale = 0; // 급여
	private int commission = 0; // 성과급
	private int deptNo = 0; // 부서번호

	public Employee() { // 기본 생성자
	}
	
	/** Overloading 생성자 **/
	public Employee(int empNo, String empName, String job, String mgr, String hireDate, int sale, int commission, int deptNo) {
		this.empNo=empNo;
		this.empName=empName;
		this.job=job;
		this.mgr=mgr;
		this.hireDate=hireDate;
		this.sale=sale;
		this.commission=commission;
		this.deptNo=deptNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", mgr=" + mgr + ", hireDate="
				+ hireDate + ", sale=" + sale + ", commission=" + commission + ", deptNo=" + deptNo + "]";
	}

	
}
