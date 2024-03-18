package com.dolly.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

// MyInetAddress.class => �ڹ� ���� inet address, �پ��� �޼��� ����(�翬����)
public class MyInetAddress {
	private InetAddress ip;

	// ������
	public MyInetAddress() {
		
	}
	
	// ������ �������̵�
	public MyInetAddress(InetAddress ip) {
		this.ip = ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}
	
	// IntAddress ��ü�� ���� ������ �����ϴ� �޼���
	public void info() {
		System.out.println(this.ip.getHostAddress()); // IP ��ȣ�� ����
		System.out.println(this.ip.getHostName()); // �����θ� ����
		System.out.println(this.ip.toString()); // IP, ������ ���
	}
	
	// main()
	public static void main(String[] args) {
		// �ܺ��ڿ��̴� ����ó��
		try {
			// InetAddress.getLocalHost() ���� �� PC
			// InetAddress: ip ��ȣ �� ������ �� ���� �����ϴ� ��ü(Ŭ����)
			MyInetAddress my = new MyInetAddress(InetAddress.getLocalHost());
			my.info();
			
			// �������� ���� �� ����
			// InetAddress.getByName() : �������� ���� ip ��ȣ ���� �����Ͽ� InetAddress ��ü�� ��ȯ
			my.setIp(InetAddress.getByName("www.naver.com"));
			my.info();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}

	} // main() END


}

//��°��
//10.10.14.119
//kcci119
//kcci119/10.10.14.119
//223.130.192.247
//www.naver.com
//www.naver.com/223.130.192.247
