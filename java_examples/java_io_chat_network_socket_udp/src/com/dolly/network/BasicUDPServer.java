package com.dolly.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class BasicUDPServer {
	DatagramSocket dsock; // 패킷 다루는 기능
	DatagramPacket sPack, rPack; // 보내는 패킷, 받는 패킷
	InetAddress client; // 클라이언트 ip
	// 서버 포트, 클라이언트 포트
	int serverPort = 7777, clientPort; // clientPort는 클라이언트로부터 전달받음

	public BasicUDPServer() {
		
	}
	
	// 생성자 오버라이딩
	public BasicUDPServer(int port) {
		this.serverPort = port;
		System.out.println(">> 서버 시작!");
		System.out.println(">> 클라이언트 접속을 기다리는 중!");
		
		try {
			this.dsock = new DatagramSocket(this.serverPort);
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		}
	} // BasicUDPServer() END
	
	public void comm() {
		// 1. 키보드로부터 입력받은 내용을 Buffer에 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while(true) { // 계속 송수신
				// 한번에 받을 수 있는 byte 수를 1024로 제한해둔 것
				byte[] buffer = new byte[1024]; // 패킷의 크기 지정
				
				// 클라이언트에서 전송된 패킷을 받기 위한 객체
				this.rPack = new DatagramPacket(buffer, buffer.length); // 패킷의 크기
				// 수신 대기
				this.dsock.receive(rPack); // 서버소켓이 클라이언트로부터 전달 받기 위한 대기 상태
				// 전달받은 데이터(패킷)를 문자열로 변화
				// String 객체 생성
				String str = new String(rPack.getData(), 0, buffer.length);
				
				// 클라이언트의 주소, 포트 반환
				this.client = this.rPack.getAddress();
				this.clientPort = this.rPack.getPort();
				
				// 전송받은 결과 출력
				System.out.println("[클라이언트]" + this.client + " : " + str);
				
				// 클라이언트로부터 종료 요청이 들어오면 while() 멈춤
				// 하지만 클라이언트가 quit를 제대로 입력하지 못한다면(앞 뒤에 공백이 있을 시) 멈출 수 없음
				// 공백을 없애주자
				if(str.trim().equals("quit")) break; // 결과가 true일 때 단일 실행문은 {} 생략 가능
				// String.trim() : 문자열의 앞, 뒤 공백 제거
				
				/* 서버가 클라이언트에게 전송 */
				// 입력된 정보를 DatagramPacket 객체로 만들어서 클라이언트에 전송
				String out = br.readLine(); // 위쪽에서 BuffredReader 객체가 있기에 활용
				this.sPack = new DatagramPacket(out.getBytes(), out.getBytes().length, client, clientPort);
				// String.getBytes(): 문자열을 byte 배열로 반환
				// String.getBytes().length: byte 배열의 길이 (크기)
				
				this.dsock.send(sPack); // DatagramSocket을 통해 클라이언트로 전송

			} // while() END
			// 클라이언트 접속 종료 시 while문도 종료
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}

	} // comm() END
	
	public static void main(String[] args) {
		// 서버 쪽 실행
		BasicUDPServer server = new BasicUDPServer(7777);
		server.comm();

	}

}
