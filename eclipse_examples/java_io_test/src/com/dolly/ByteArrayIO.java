package com.dolly;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* ByteArrayInputStream */
public class ByteArrayIO {

	public static void main(String[] args) {
		// byte 배열 데이터를 읽어서 소문자 데이터를 대문자로 출력
		int c;
		byte[] b = {'a', 'b', 'z', 'x', 't'};
		
		// byte 배열을 읽는 ByteArrayInputStream 객체 생성
		// 이 때 생성자에게 byte 배열을 전달
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		
		// 배열 데이터를 대문자로 변환한 후에 저장할 ByteArrayOutputStream 객체 생성
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// 소문자 데이터를 읽어 대문자로 출력해보기
		while((c = bais.read()) != -1) {
			// 원본 소문자 확인
			System.out.println((char)c);
			// 소문자를 대문자로 변환 출력
			System.out.println(Character.toUpperCase((char)c));
			
			// 대문자로 저장
			baos.write(Character.toUpperCase((char)c));
		}
		
		// Arrays.toString() 배열 데이터를 문자열로 변환
		System.out.println(Arrays.toString(b));
		// baos.toByteArray()
		// BufferedArrayOutputStream 객체 데이터를 배열로 변환
		System.out.println(baos.toByteArray());
		System.out.println(Arrays.toString(baos.toByteArray()));
	}

}

// 출력 결과
//a
//A
//b
//B
//z
//Z
//x
//X
//t
//T
//[97, 98, 122, 120, 116]
//[B@1175e2db
//[65, 66, 90, 88, 84]

// 우리가 문자를 입력할 때 컴퓨터는 문자가 아니라 숫자로 인식함
// 운영체제가 a를 97로 인식해서 되돌려주는 것

