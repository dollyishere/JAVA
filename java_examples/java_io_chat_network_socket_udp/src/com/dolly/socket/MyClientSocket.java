package com.dolly.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public MyClientSocket() {
		
	}
	
	public MyClientSocket(String ip, int port) {
		try {
			this.socket = new Socket(ip, port); // ���� ��Ĺ ����
			
			// ���� ��Ĺ�� ��Ʈ�� ����
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			
			// ��� �޼��� ȣ��
			printInfo();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	} // ������ END

	
	// �޽��� �޴� �޼���
	public void receive() {
		try {
			// tcp�� ���� �߽�
			// ���� �������κ��� ���� �޽��� ���
			System.out.println("[���� : ]" + this.in.readLine());
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	// �޼��� ���� �޼���
	public void send(String msg) {
		// ���� ���Ͽ� �޽��� ����
		this.out.println(msg);
		this.out.flush();
		System.out.println("[Ŭ���̾�Ʈ : ]" + msg);
	}
	
	// ���� ���� �޼���
	public void close() {
		try {
			this.socket.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	// ��� �޼��� : MyServerSocket() ������ ������ ȣ��
	private void printInfo() {
		System.out.println(">>> ������ ���� ����!!");
		System.out.println(">>> ���� �ּ� : " + this.socket.getInetAddress());
		System.out.println(">>> ���� ��Ʈ��ȣ : " + this.socket.getPort());
		System.out.println(">>> Ŭ���̾�Ʈ ��Ʈ��ȣ : " + this.socket.getLocalPort());
		
	} // ��� �޼��� END

	public static void main(String[] args) {
		// ���� �ּҿ� ��Ʈ ��ȣ�� ����, ������ ����
		MyClientSocket client = new MyClientSocket("127.0.0.1", 7070);
		
		System.out.println(">>> ������ ���� �޽��� �Է� ��, ENTER");
		Scanner scanner = new Scanner(System.in);
		String msg = scanner.nextLine();
		client.send(msg); // �۽�
		client.receive(); // ���� ���
		client.close(); // ����
		System.out.println();
	}

}
