package com.dolly;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* ByteArrayInputStream */
public class ByteArrayIO {

	public static void main(String[] args) {
		// byte �迭 �����͸� �о �ҹ��� �����͸� �빮�ڷ� ���
		int c;
		byte[] b = {'a', 'b', 'z', 'x', 't'};
		
		// byte �迭�� �д� ByteArrayInputStream ��ü ����
		// �� �� �����ڿ��� byte �迭�� ����
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		
		// �迭 �����͸� �빮�ڷ� ��ȯ�� �Ŀ� ������ ByteArrayOutputStream ��ü ����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// �ҹ��� �����͸� �о� �빮�ڷ� ����غ���
		while((c = bais.read()) != -1) {
			// ���� �ҹ��� Ȯ��
			System.out.println((char)c);
			// �ҹ��ڸ� �빮�ڷ� ��ȯ ���
			System.out.println(Character.toUpperCase((char)c));
			
			// �빮�ڷ� ����
			baos.write(Character.toUpperCase((char)c));
		}
		
		// Arrays.toString() �迭 �����͸� ���ڿ��� ��ȯ
		System.out.println(Arrays.toString(b));
		// baos.toByteArray()
		// BufferedArrayOutputStream ��ü �����͸� �迭�� ��ȯ
		System.out.println(baos.toByteArray());
		System.out.println(Arrays.toString(baos.toByteArray()));
	}

}

// ��� ���
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

// �츮�� ���ڸ� �Է��� �� ��ǻ�ʹ� ���ڰ� �ƴ϶� ���ڷ� �ν���
// �ü���� a�� 97�� �ν��ؼ� �ǵ����ִ� ��

