package com.naver.news;

import java.io.FileWriter;
import java.io.IOException;

public class NaverPrintClass {

	public NaverPrintClass() { // �⺻ ������
	} // ������ END
	
	
	/** �ܺηκ��� ���޵� ���ڿ��� �̿��Ͽ� html ������ �����ϴ� �޼��� **/
	public static void createHTML(String  uri, String tags) {
		FileWriter fw=null;	// ����.html ���ο� HTML �±׸� ���� ���� ��ü ����  
		
		try {
			fw=new FileWriter(uri); 	// ���� ���� ��ü ����
			fw.write(tags); 				// tag �� ���Ͽ� ����
			fw.close();					// �������� ��, close()
			System.out.println("html ���� ���� �� ���� ���� ");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	} // makeHTML() END

} // class END




