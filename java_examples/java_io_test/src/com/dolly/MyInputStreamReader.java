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
		// MyInputStreamReader.java�� �� ������ �б�
		String line; // �� ���� ����
		String fname = "src/com/dolly/MyInputStreamReader.java";
		
		try {
			// FileInputStream => fname �ʿ�, ���� ������ �о
			FileInputStream fis = new FileInputStream(fname);
			
			// InputStreamReader => FileInputStream ��ü �ʿ�
			InputStreamReader isr = new InputStreamReader(fis);
			
			// BufferedReader => InputStreamReader ��ü �ʿ�, readLine(); �޼��� �̿� ������
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("Encoding: "+ isr.getEncoding());
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			// �ֱٿ� ����� �ź��� ���� close
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
