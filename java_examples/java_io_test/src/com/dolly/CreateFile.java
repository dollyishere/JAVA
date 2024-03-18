package com.dolly;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* File Ŭ������ �̿��� ���� ���� */
public class CreateFile {

	public static void main(String[] args) {
		// 1. ���� ���� ��� �� ���ϸ�.Ȯ����
		String fname = "c:/filetest/newFile2.text";
		
		// 2. ������ �ٷ�� File ��ü ����
		File f = new File(fname);
		
//		// 3. ������ ������ ���� ���� Ȯ��
//		if (!f.exists()) {
//			// ������ ������ ���� �� ����
//			System.out.println("�ش� ������ ã�� �� �����ϴ�: " + fname);
//		}
		
		// 4. ���ο� ���� ����: newFile.txt
		// ���� ������ �����س��� ���̹Ƿ� ����ó�� �ʼ�
		try {
			if (!f.exists()) { // ������ ���� ���� ���� Ȯ��
				// ������ ������ ������ �����Ͽ� ���ο� ���� ����
				f.createNewFile();
				// ���� ���� ���� ���� Ȯ��
				System.out.println("�ش� ������ �����Ǿ����ϴ�: " + fname);
			}
			
			FileWriter fw = new FileWriter(f);
			fw.write("ȣȣȣ~");
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	} // main() END

} // CreateFile END
