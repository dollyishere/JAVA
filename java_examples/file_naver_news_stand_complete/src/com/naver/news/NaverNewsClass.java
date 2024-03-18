package com.naver.news;

/** 하나의 신문사 관련 정보를 담는 클래스 **/
public class NaverNewsClass {
	private String img = "";
	private String url = "";

	public NaverNewsClass() { // 기본생성자
	} // 기본 생성자 END

	/** 외부로부터 전달받은 데이터를 멤버(인스턴스) 변수에 대입하는 생성자 **/
	public NaverNewsClass(String img, String url) {
		this.img = img;
		this.url = url;
	}  // Overloading 생성자

	/** 아래 메서드는 private 변수데이터에 접근하기 위한 getter 들 **/
	public String getImg() {
		return img;
	}

	public String getUrl() {
		return url;
	}

}
