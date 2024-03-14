package com.dolly;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* Buffered~ �� ����ϴ� ���� */
// 1. �ٴ����� ���� �޼��带 ����
// 2.��뷮 �����͸� ���� ó���ϱ� ����

//�ݵ�ô� �ƴϰ� �ַ� ���Ͽ� ���� ����
//- BufferedReader: FileReader / BufferedWriter: FileWriter
//- BufferedInputStream: FileInputStream / BufferedOutputStream : FileOutputStream
//
//### �������
//- ~~~InputStream�� InputStream�� ����
//- ~~~OutputStream�� OutputStream�� ����

// Buffered~~ ���� �ܵ� ��� �Ұ��� �ݵ�� File~~~ ��ü�� �ʿ�

// BufferedInputStream �̸� ��� �Ұ�
// ���� Ŭ���� ��� ��ġ�⿡
// ���� Ŭ���� ���� ����Ÿ� �̸� �ڿ� ~~Class �ٿ��ָ� ����
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
			
			// �����Ϳ� �ִ� ���� buffer �ʿ� �ִ� �� 
			bos.write(data, 0, 4); // write(�迭 ������, �迭�� ���� �ε���, buffer�� �� ���� ����(count)) : ���� �ε����� ���� ���� ���û���
			bos.close();
			fos.close();
			// ==========================================================
			
			// buffer�� ����� ������ �б� �׸��� ���Ͽ� ����
			// file name�� ���� ���� �޴� �� FileOutputStream��
			// �̸� test.buffer�� ������ (�츮�� ���� ������ ���� ����)
			// �׷��� buffer�� ������ ��ü bos�� �����ξ��µ�, �̰� BufferedOutputStream�ʿ� �������
			// �׷��� �̰� ���ؼ� �� ������ test.buff�� �� ���ۿ� ���� ��
			// �� �����͸� ���� buffer�� ����, close ��Ű�� 4���� ���ڰ� ��
			// �̰� Ȯ���غ��� ���� �ٽ� �о(bis)
			// �׸��� data�� ���� 10���� ������(����)
			// �� �ڿ� ������ ���� ������ �� ù��°���� �ټ���°���� ä��
			// �׷��� �츮�� �־�� ���ڴ� 4����
			// �׷��� 4���� ä������ �������� 0���� ä������ ��
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

// ��� ���
//[65, 66, 67, 68]
//[65, 66, 67, 68, 0, 0, 0, 0, 0, 0]
