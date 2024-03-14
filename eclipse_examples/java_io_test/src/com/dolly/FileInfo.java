package com.dolly;

import java.io.File;
import java.util.Date;

/* ���� ���� : File */
public class FileInfo {

	public static void main(String[] args) {
		String fname = "C:/filetest";
		
		// 1.  ������ ��� ���� File ��ü ����
		File f = new File(fname);
		System.out.println(f.getName()); // ReadFlies.java
		System.out.println(f.getPath()); // src\com\dolly\ReadFiles.java �����
		System.err.println(f.getAbsolutePath()); // ������ : ����̺��:\~~~
		// C:\eclipse\java_io_test\src\com\dolly\ReadFiles.java 
		
		System.out.println("���� " + f.canWrite()); // ������ �Ӽ��� ���� Ȱ��ȭ ����
		// �б� ������ ������ �� �� ����
		System.out.println("�б� " + f.canRead()); // ������ �Ӽ��� �б� Ȱ��ȭ ����
		System.out.println(f.getParent()); // �θ� ������ �˷���
		System.out.println("���� " + f.isFile()); // ������ ������ �����̸� true
		System.out.println("���� " + f.isDirectory()); // ������ ������ ������ true
		Date date = new Date(f.lastModified()); // ���� ��¥ �ľ�
		System.out.println(f.lastModified()); // ������ ������ ���� ��¥ �� �ð� (������ ��ȯ)
		System.out.println(f.length()); // ������ ũ�� (byte)
		
		// �ش� ���� ���踸 �ǵ帱 �� ����
		String[] fileList = f.list(); // ������ ���� ���� ���ϸ� ����Ʈ ��ȯ
		for (String n: fileList) {
			System.out.println(n + " is Directory: " + (new File(fname + "/" + n).isDirectory()));
		}
		System.out.println(fileList.length);
	} // main() END

} // FileInfo END


//��� ���
//filetest
//C:\filetest
//C:\filetest
//���� true
//�б� true
//C:\
//���� false
//���� true
//1710376614530
//0
//animals is Directory: true
//book.txt is Directory: false
//can.txt is Directory: false
//3
