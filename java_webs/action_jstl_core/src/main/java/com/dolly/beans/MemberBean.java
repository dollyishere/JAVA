package com.dolly.beans;

public class MemberBean {
	private String name;
	private String userid;
	private String nickname;
	private String pwd;
	private String email;
	private String phone;

	public MemberBean() { // 기본 생성자
		super(); // object class의 생성자
	}

	public MemberBean(String name, String userid) { // 기본 생성자
//		this.name = name; 
//		this.userid = userid; 
		// super() 위에는 어떤 코드도 넣어서는 안됨 (오류~)
//		super(); // object class의 생성자
		this(); // 나 자신(해당 클래스)를 의미
		this.name = name;
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberBean [name=" + name + ", userid=" + userid + ", nickname=" + nickname + ", pwd=" + pwd
				+ ", email=" + email + ", phone=" + phone + "]";
	}

	
}
