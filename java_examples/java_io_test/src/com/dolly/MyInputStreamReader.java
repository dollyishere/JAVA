package com.dolly;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

// 
public class MyInputStreamReader {

	public MyInputStreamReader() {
		// TODO Auto-generated method stub

	}
	
	public static void test() {
		// MyInputStreamReader.java를 줄 단위로 읽기
		String line; // 한 줄을 저장
		String fname = "src/com/dolly/MyInputStreamReader.java";
		
		try {
			// FileInputStream => fname 필요, 글자 단위로 읽어냄
			FileInputStream fis = new FileInputStream(fname);
			
			// InputStreamReader => FileInputStream 객체 필요
			InputStreamReader isr = new InputStreamReader(fis);
			
			// BufferedReader => InputStreamReader 객체 필요, readLine(); 메서드 이용 가능함
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("Encoding: "+ isr.getEncoding());
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			// 최근에 사용한 거부터 먼저 close
			br.close();
			isr.close();
			fis.close();
			
		} catch(FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch(IOException e2) {
			System.err.println(e2.getMessage());
		}
	}

}
