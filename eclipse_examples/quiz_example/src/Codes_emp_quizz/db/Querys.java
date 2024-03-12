package com.freeflux.db;

public interface Querys {
	static final String querySelectAll ="select * from employee";
	static final String querySelectOne ="select * from employee where empNo=?";
	static final String queryInsert ="insert into employee (empNo, empName, job, mgr, hireDate, sale, commission, deptNo) values (?,?,?,?,?,?,0,?)";
	static final String queryUpdate ="update employee set sale=? where seq_no=?";
	static final String queryDelete ="delete from employee where job=?";
}
/**
create table employee (
	seq_no int(4) auto_increment,
	empNo int(2) not null, 
	empName varchar(20) not null, 
	job varchar(20), 
	mgr char(2), 
	hireDate char(10) not null, 
	sale int(4) not null, 
	commission int(4),   // 초기값 없슴
	deptNo int(2), 
	primary key(seq_no, empNo)
);
**/