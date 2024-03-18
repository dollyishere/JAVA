package com.dolly;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* stream ������� ���� �б� */
// stream ���: byte ������ ���ڸ� �б�(��, �� ���ڸ� �����ڵ� ������ �о�� ���)
// int (����) ���·� ���� ��, char�� ��ȯ�Ͽ� ���
// �����ڵ�� ���� �ٱ��� ������ ���� �� ���
public class ReadFiles {

	public static void main(String[] args) {
		int data; // byte ���� ���ڸ� ����
		
		// ���� ������ ���
		String fname = "src/com/dolly/ReadFiles.java";
		FileInputStream fis = null;
		
		try {
			// ������ ��Ʈ������ �б�: FileInputStream ��ü ����
			fis = new FileInputStream(fname);
			
			// ���� �о�� �����Ͱ� -1�� �ƴ� ������ ����
			while((data = fis.read()) != -1) { // .read(): �� �̻� ���� ���ڰ� ������ -1�� ��ȯ
				System.out.print((char)data); // �׳� �����͸� ����ϸ� Int ���·� ��µ�
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e2) {
			System.out.println(e2.getMessage());
		}
	}

}
