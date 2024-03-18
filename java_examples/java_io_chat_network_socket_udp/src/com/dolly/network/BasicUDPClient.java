package com.dolly.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BasicUDPClient {
	DatagramSocket dsock;
	DatagramPacket sPack, rPack;
	// 서버 포트 번호
	InetAddress server;
	// 클라이언트 포트 번호
	// 포트번호가 컴퓨터 자체적으로 충돌날 수도 있으므로 안되면 일단 포트번호부터 변경해볼 것
	int port = 8858;
	
	public BasicUDPClient() {
		
	}
	
	public BasicUDPClient(String ip, int port) {
		try {
			// ip를 이용하여 InetAddress 객체 얻기
			this.server = InetAddress.getByName(ip);
			this.port = port;
			this.dsock = new DatagramSocket();
			// 사용자에게 보여줄 메시지

			System.out.println(">>> 서버에 접속합니다.");
			System.out.println(">>> 서버에 접속할 메시지를 입력 후, ENTER.");
			System.out.println(">>> 종료할 경우, quit를 입력한 후, ENTER.");
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	} // 오버라이드 생성자 END
	
	// 통신 메서드
	public void comm() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String out;
			
			while((out = br.readLine()) != null) {
												// 사용자 입력 문자를 byte로 변환
				this.sPack = new DatagramPacket(out.getBytes(), 
						out.getBytes().length, // byte[]의 길이
						this.server, // 전송대상 주소, 이걸 여기에 보내라는 뜻
						port);	// 전송대상 port
				this.dsock.send(sPack); // 실제 전송
				
				
				// 서버 수신
				byte[] buffer = new byte[1024];
				this.rPack = new DatagramPacket(buffer, buffer.length);
				this.dsock.receive(this.rPack); // 받는 패킷을 이용하여 서버 수신 대기
				
				String inStr = new String(this.rPack.getData(), 0, this.rPack.getData().length);
				System.out.println("서버로부터 전송된 메시지 " + inStr);
			} // while() END

			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	} // comm() END 
	
	public static void main(String[] args) {
		BasicUDPClient client = new BasicUDPClient("127.0.0.1", 7777);
		client.comm();
	}

}
