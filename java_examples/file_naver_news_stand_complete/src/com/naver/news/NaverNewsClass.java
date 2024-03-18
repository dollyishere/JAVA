package com.naver.news;

/** �ϳ��� �Ź��� ���� ������ ��� Ŭ���� **/
public class NaverNewsClass {
	private String img = "";
	private String url = "";

	public NaverNewsClass() { // �⺻������
	} // �⺻ ������ END

	/** �ܺηκ��� ���޹��� �����͸� ���(�ν��Ͻ�) ������ �����ϴ� ������ **/
	public NaverNewsClass(String img, String url) {
		this.img = img;
		this.url = url;
	}  // Overloading ������

	/** �Ʒ� �޼���� private ���������Ϳ� �����ϱ� ���� getter �� **/
	public String getImg() {
		return img;
	}

	public String getUrl() {
		return url;
	}

}
