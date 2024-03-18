package com.dolly.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BasicUDPClient {
	DatagramSocket dsock;
	DatagramPacket sPack, rPack;
	// ���� ��Ʈ ��ȣ
	InetAddress server;
	// Ŭ���̾�Ʈ ��Ʈ ��ȣ
	// ��Ʈ��ȣ�� ��ǻ�� ��ü������ �浹�� ���� �����Ƿ� �ȵǸ� �ϴ� ��Ʈ��ȣ���� �����غ� ��
	int port = 8858;
	
	public BasicUDPClient() {
		
	}
	
	public BasicUDPClient(String ip, int port) {
		try {
			// ip�� �̿��Ͽ� InetAddress ��ü ���
			this.server = InetAddress.getByName(ip);
			this.port = port;
			this.dsock = new DatagramSocket();
			// ����ڿ��� ������ �޽���

			System.out.println(">>> ������ �����մϴ�.");
			System.out.println(">>> ������ ������ �޽����� �Է� ��, ENTER.");
			System.out.println(">>> ������ ���, quit�� �Է��� ��, ENTER.");
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	} // �������̵� ������ END
	
	// ��� �޼���
	public void comm() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String out;
			
			while((out = br.readLine()) != null) {
												// ����� �Է� ���ڸ� byte�� ��ȯ
				this.sPack = new DatagramPacket(out.getBytes(), 
						out.getBytes().length, // byte[]�� ����
						this.server, // ���۴�� �ּ�, �̰� ���⿡ ������� ��
						port);	// ���۴�� port
				this.dsock.send(sPack); // ���� ����
				
				
				// ���� ����
				byte[] buffer = new byte[1024];
				this.rPack = new DatagramPacket(buffer, buffer.length);
				this.dsock.receive(this.rPack); // �޴� ��Ŷ�� �̿��Ͽ� ���� ���� ���
				
				String inStr = new String(this.rPack.getData(), 0, this.rPack.getData().length);
				System.out.println("�����κ��� ���۵� �޽��� " + inStr);
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
