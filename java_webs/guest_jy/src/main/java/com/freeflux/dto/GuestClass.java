package com.freeflux.dto;

public class GuestClass {
	private int idx = 0;
	private String name = null;
	private String title = null;
	private String content = null;
	private String moment = null;
	private int hit = 0;
	
	// 기본 생성자
	public GuestClass() {

	} // 기본 생성자 END

//	// override 생성자
//	public GuestClass(int idx, String name, String title, String content, String moment, int hit) {
//		this.idx = idx;
//		this.name = name;
//		this.title = title;
//		this.content = content;
//		this.moment = moment;
//		this.hit = hit;
//	} // override 생성자 END

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	// toString override
	@Override
	public String toString() {
		return "GuestClass [idx=" + idx + ", name=" + name + ", title=" + title + ", content=" + content + ", moment="
				+ moment + ", hit=" + hit + "]";
	}	// toString override END
	
}
