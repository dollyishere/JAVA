package com.dolly.member;

import java.sql.Date;

public class MemberVO {
	private String id=null;
	private String pwd=null;
	private String email=null;
	private String name=null;
	private Date joindate=null; // java.sql.Date
	
	public MemberVO() {

	} // 기존 생성자 END

	//	getter & setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	} //	getter & setter END

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", joindate=" + joindate
				+ "]";
	} // toString END

} // MemberVO END
