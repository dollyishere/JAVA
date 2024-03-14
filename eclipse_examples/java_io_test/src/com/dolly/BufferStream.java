package com.dolly;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* Buffered~ 를 사용하는 목적 */
// 1. 줄단위로 읽은 메서드를 보유
// 2.대용량 데이터를 빨리 처리하기 위함

//반드시는 아니고 주로 이하와 같이 사용됨
//- BufferedReader: FileReader / BufferedWriter: FileWriter
//- BufferedInputStream: FileInputStream / BufferedOutputStream : FileOutputStream
//
//### 참고사항
//- ~~~InputStream은 InputStream가 조상
//- ~~~OutputStream은 OutputStream가 조상

// Buffered~~ 들은 단독 사용 불가능 반드시 File~~~ 객체가 필요

// BufferedInputStream 이름 사용 불가
// 기존 클래스 명과 겹치기에
// 보통 클래스 새로 만들거면 이름 뒤에 ~~Class 붙여주면 좋음
public class BufferStream {

	public static void main(String[] args) {
		FileOutputStream fos;
		BufferedOutputStream bos;
		BufferedInputStream bis;
		
		String fname = "src/com/dolly/test.buff";
		
		try {
			fos = new FileOutputStream(fname);
			bos = new BufferedOutputStream(fos);
			byte[] data = {'A', 'B', 'C', 'D'};
			//				65 	 66	  67   68
			System.out.println(Arrays.toString(data));
			
			// 데이터에 있는 값을 buffer 쪽에 주는 것 
			bos.write(data, 0, 4); // write(배열 데이터, 배열의 시작 인덱스, buffer에 줄 값의 개수(count)) : 시작 인덱스나 값의 수는 선택사항
			bos.close();
			fos.close();
			// ==========================================================
			
			// buffer에 저장된 데이터 읽기 그리고 파일에 쓰기
			// file name을 가장 먼저 받는 건 FileOutputStream임
			// 이를 test.buffer에 내보냄 (우리가 아직 읽지는 않은 상태)
			// 그래서 buffer에 내보낼 객체 bos를 만들어두었는데, 이게 BufferedOutputStream쪽에 들어있음
			// 그래서 이걸 통해서 쓴 내용이 test.buff에 들어갈 수밖에 없는 것
			// 이 데이터를 이제 buffer에 쓰고, close 시키면 4개의 숫자가 들어감
			// 이걸 확인해보기 위해 다시 읽어봄(bis)
			// 그리고 data에 방을 10개를 만들어둠(재사용)
			// 그 뒤에 걔한테 읽은 내용을 맨 첫번째부터 다섯번째까지 채움
			// 그런데 우리가 넣어둔 숫자는 4개임
			// 그래서 4개만 채워지고 나머지는 0으로 채워지게 됨
			bis = new BufferedInputStream(new FileInputStream(fname));
			data = new byte[10];
			bis.read(data, 0, 5);
			bis.close();
			System.out.println(Arrays.toString(data));
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

}

// 출력 결과
//[65, 66, 67, 68]
//[65, 66, 67, 68, 0, 0, 0, 0, 0, 0]
