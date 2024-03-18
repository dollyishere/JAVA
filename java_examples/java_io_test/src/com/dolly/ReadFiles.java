package com.dolly;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* stream 방식으로 파일 읽기 */
// stream 방식: byte 단위로 문자를 읽기(즉, 각 문자를 유니코드 값으로 읽어내는 방식)
// int (정수) 형태로 읽은 후, char로 변환하여 출력
// 유니코드는 추후 다국어 페이지 만들 때 사용
public class ReadFiles {

	public static void main(String[] args) {
		int data; // byte 단위 문자를 저장
		
		// 읽을 파일의 경로
		String fname = "src/com/dolly/ReadFiles.java";
		FileInputStream fis = null;
		
		try {
			// 파일을 스트림으로 읽기: FileInputStream 객체 생성
			fis = new FileInputStream(fname);
			
			// 파일 읽어온 데이터가 -1이 아닐 때까지 수행
			while((data = fis.read()) != -1) { // .read(): 더 이상 읽을 문자가 없으면 -1을 반환
				System.out.print((char)data); // 그냥 데이터만 출력하면 Int 형태로 출력됨
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e2) {
			System.out.println(e2.getMessage());
		}
	}

}
