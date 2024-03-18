package com.dolly.socket_quiz;

import java.io.*;
import java.net.*;

public class QuizClient {
	public static void main(String[] args) throws IOException {

		Socket quizSocket = null;
		PrintWriter out = null;  // ������ ������ ������ ��� ��ü
		BufferedReader in = null;  // �����κ��� ���۵� ������ �б� ��ü

		try {
			// ���� ���� �� ������ ������ ������ �����غ�
			quizSocket = new Socket("localhost", 5555);
			OutputStream quizOut=quizSocket.getOutputStream();
			out = new PrintWriter(quizOut, true);
			
			// �����κ��� ���۵� ������ �б� �غ�
			InputStream quizis=quizSocket.getInputStream();
			InputStreamReader quizisr=new InputStreamReader(quizis);
			in = new BufferedReader(quizisr);
			
		} catch (UnknownHostException e) {
			System.err.println("localhost��  ������ �� �����ϴ�.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("����� ����");
			System.exit(1);
		}
//----------------������� ������ ��� �غ� ��--------------------
		
		
//----------------������� ������ ��� ����---------------------------	
		// BufferedReader user�� ����ڰ� �Է��� ���� �б�
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader user = new BufferedReader(isr);
		String fromServer;  // �����κ��� ���޵� �޽��� ����
		String fromUser;    // ����ڰ� �Է��� �޽��� ����

		// �����κ��� ���۵� ������ �б�
		while ((fromServer = in.readLine()) != null) {
			System.out.println("����: " + fromServer);
			if (fromServer.equals("quit")) {
				break;
			}
			
			// client �� �Է��� ������ ���� ��, ������ ����
			fromUser = user.readLine();  // "y"
			if (fromUser != null) {
				System.out.println("Ŭ���̾�Ʈ: " + fromUser);
				out.println(fromUser); // ������ ����
			}
		} // while() END
		out.close();		in.close();		quizSocket.close();
		
	} // main() END
} // class END


