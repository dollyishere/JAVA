package com.dolly.socket_quiz;

import java.io.*;
import java.net.*;

public class QuizClient {
	public static void main(String[] args) throws IOException {

		Socket quizSocket = null;
		PrintWriter out = null;  // 서버로 전송할 데이터 출력 객체
		BufferedReader in = null;  // 서버로부터 전송된 데이터 읽기 객체

		try {
			// 서버 접속 및 서버로 전송할 데이터 전송준비
			quizSocket = new Socket("localhost", 5555);
			OutputStream quizOut=quizSocket.getOutputStream();
			out = new PrintWriter(quizOut, true);
			
			// 서버로부터 전송된 데이터 읽기 준비
			InputStream quizis=quizSocket.getInputStream();
			InputStreamReader quizisr=new InputStreamReader(quizis);
			in = new BufferedReader(quizisr);
			
		} catch (UnknownHostException e) {
			System.err.println("localhost에  접근할 수 없습니다.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("입출력 오류");
			System.exit(1);
		}
//----------------여기까지 서버와 통신 준비 끝--------------------
		
		
//----------------여기부터 서버와 통신 시작---------------------------	
		// BufferedReader user는 사용자가 입력한 답을 읽기
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader user = new BufferedReader(isr);
		String fromServer;  // 서버로부터 전달된 메시지 저장
		String fromUser;    // 사용자가 입력한 메시지 저장

		// 서버로부터 전송된 데이터 읽기
		while ((fromServer = in.readLine()) != null) {
			System.out.println("서버: " + fromServer);
			if (fromServer.equals("quit")) {
				break;
			}
			
			// client 가 입력한 데이터 읽은 후, 서버로 전송
			fromUser = user.readLine();  // "y"
			if (fromUser != null) {
				System.out.println("클라이언트: " + fromUser);
				out.println(fromUser); // 서버로 전송
			}
		} // while() END
		out.close();		in.close();		quizSocket.close();
		
	} // main() END
} // class END



