package com.dolly.dto;

/** table의 record 하나를 객체화 **/
public class MemberVO {
	private int idx = 0;
	private String id = null;
	private String pw = null;
	
	public MemberVO() {
	}

	// getter, setter
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	// toString override
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", id=" + id + ", pw=" + pw + "]";
	}

	
}
