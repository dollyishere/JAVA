package com.dolly.socket_quiz;

import java.net.*;
import java.io.*;

public class QuizServer {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5555);
		} catch (IOException e) {
			System.err.println("다음의 포트 번호에 연결할 수 없습니다: 5555");
			System.exit(1);
		}

		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("accept() 실패");
			System.exit(1);
		}
//-------------------------클라이언트와 통신준비 끝 -------------------
		
		
		
// -------------- 클라이언트와 통신 시작 ---------------
		// PrintWriter out 은 클라이언트에게 전송하기 위한 객체...
		OutputStream clientOut=clientSocket.getOutputStream();
		PrintWriter out = new PrintWriter(clientOut, true);
		
		//InputStreamReader isr 과 BufferedReader in는 클라이언트가 입력한 내용
		InputStream clientInput=clientSocket.getInputStream();
		InputStreamReader isr=new InputStreamReader(clientInput);
		BufferedReader in = new BufferedReader(isr);
		
		// String inputLine 는 BufferedReader in의 데이터를 저장
		// String outputLine 는 클라이언트에게 내보낼 메시지 저장
		String inputLine, outputLine;
		
		//-------- 퀴즈 시작 ---------------------------------------------

		// 퀴즈를 진행하기 위한 객체생성
		QuizProtocol qp = new QuizProtocol();

		// 퀴즈 프로세스 시작!!!
		outputLine = qp.process(null);  
		/** qp.process(null);
		 *  초기 client로부터 전달받은 값이 없으므로 null를 전달하여
		 *  프로세스 시작. outputLine <= // "퀴즈를 시작합니다(y/n)" 
		 *  향후, client가 전송한 값들을 전달...
		 */
		out.println(outputLine); // "퀴즈를 시작합니다(y/n)" 를 client에게 전송!!!
		
        /** 아래 부분은 client 가 입력값을 전송했을 경우 실행. 그전에는 일시정지!!**/
		// 1. client : "y", "Y" 입력 후, 서버로 전송하면...
		// 2. client : "java.net" 입력 후, 서버로 전송하면...
		while ((inputLine = in.readLine()) != null) {
			outputLine = qp.process(inputLine); //"y" , "Y"
							// 1. qp.process("y"); 또는 qp.process("Y");
							// 2. qp.process("java.net"); 
			
			out.println(outputLine);  // 1. "네트워크 처리 패키지는?"를 client에게 전송
			// 2. 정답~~(y/n) 또는 오답~~(y/n) 를 client에게 전송
			if (outputLine.equals("quit")) {
				break;
			}
		} // while() END
		out.close();		in.close();		clientSocket.close();		serverSocket.close();
	
	} // main() END
} // class END





