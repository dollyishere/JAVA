package com.dolly.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

// MyInetAddress.class => 자바 제공 inet address, 다양한 메서드 제공(당연하지)
public class MyInetAddress {
	private InetAddress ip;

	// 생성자
	public MyInetAddress() {
		
	}
	
	// 생성자 오버라이딩
	public MyInetAddress(InetAddress ip) {
		this.ip = ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}
	
	// IntAddress 객체를 통해 정보를 추출하는 메서드
	public void info() {
		System.out.println(this.ip.getHostAddress()); // IP 번호만 추출
		System.out.println(this.ip.getHostName()); // 도메인명만 추출
		System.out.println(this.ip.toString()); // IP, 도메인 출력
	}
	
	// main()
	public static void main(String[] args) {
		// 외부자원이니 예외처리
		try {
			// InetAddress.getLocalHost() 현재 내 PC
			// InetAddress: ip 번호 및 도메인 명 등을 포함하는 객체(클래스)
			MyInetAddress my = new MyInetAddress(InetAddress.getLocalHost());
			my.info();
			
			// 도메인을 보낼 수 있음
			// InetAddress.getByName() : 도메인을 통해 ip 번호 등을 추출하여 InetAddress 객체로 반환
			my.setIp(InetAddress.getByName("www.naver.com"));
			my.info();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}

	} // main() END


}

//출력결과
//10.10.14.119
//kcci119
//kcci119/10.10.14.119
//223.130.192.247
//www.naver.com
//www.naver.com/223.130.192.247
