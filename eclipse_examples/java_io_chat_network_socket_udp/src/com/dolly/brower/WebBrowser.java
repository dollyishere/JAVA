package com.dolly.brower;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebBrowser {

	// �ڹٿ��� �� ������ ���� ����!
	public static void main(String[] args) {
		// ����ũž�� ���� �ҷ����� ���� Ŭ����
		// �ܺ� �����̱⿡ try-catch �ʿ�
		// URI: ������ �ּҸ� �ϳ��� ��ü�� ���� ��
		try {
			Desktop.getDesktop().browse(new URI("https://www.naver.com"));
		} catch (IOException | URISyntaxException e) {
			System.out.println(e.getMessage());
		}
	}

}
