package com.dolly.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
	int port = 7070; // port no
	ServerSocket server; // 버서 소켓
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public MyServerSocket() {
		
	}
	
	public MyServerSocket(int port) {
		this.port = port;
		System.out.println("");
		try {
			this.server = new ServerSocket(7070);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	} // 생성자 END
	
	// 1.  클라이언트 접속 대기
	public void waitClient() {
		System.out.println(">> 클라이언트가 접속하길 기다림~~");
		try {
			this.socket = this.server.accept(); // 클라이언트 요청 감지!!!, socket에 담아줌
			printInfo();
			
			// 클라이언트 소켓에 스트림 연결
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	// 2. 수신 메서드
	public void receive() {
		try {
			// 클라이언트 소켓으로부터 받은 메시지 출력
			System.out.println("[클라이언트 메시지] " + in.readLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	// 3. 송신 메서드
	public void send(String msg) {
		try {
			// 클라이언트 소켓에 메시지 전송
			this.out.println(msg);
			this.out.flush();
			System.out.println("[서버 메시지] " + msg);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	// 4. 종료 메서드
	public void close() {
		try {
			this.socket.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	// 5. 출력 메서드
	public void printInfo() {
		System.out.println(">> 클라이언트 접속 성공 ~~");
		System.out.println("서버 포트 번호 " + this.socket.getLocalPort());
		System.out.println("클라이언트 주소 " + this.socket.getInetAddress());
		System.out.println("클라이언트 포트 " + this.socket.getPort());
	}
	
	public static void main(String[] args) {
		int port = 7070;
		MyServerSocket myServer = new MyServerSocket(port);
		myServer.waitClient();
		myServer.receive();
		myServer.send("서버에 접속 환영~~");
		myServer.close();
	}

}
