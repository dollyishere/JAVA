package com.dolly.udp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MsgSender extends Thread {
	String nickname;
	Socket socket;
	PrintWriter out;

	public MsgSender(String nickname, Socket socket) {
		this.nickname = "[" + nickname + "] ";
		this.socket = socket;
		try {
			//소켓에 출력 스트림을 연결
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			e.printStackTrace();			
			System.out.println(e.toString());			
		}
	}
	
	public void run() {
		Scanner s = new Scanner(System.in);
		while (out != null) {
			String msg = s.nextLine();
			//보내는 사람의 별명까지 앞에 붙여 전송
			out.println(nickname + msg);
			out.flush();
		}
		try {
			// 클라이언트 소켓 종료
			socket.close();		
		} catch(IOException e) {
			e.printStackTrace();			
		}
	}	
}
