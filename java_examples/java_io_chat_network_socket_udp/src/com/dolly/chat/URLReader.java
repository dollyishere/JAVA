package com.dolly.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// �� ������ �б�
public class URLReader {
	
	// 1. ���� ������ ����
	URL url; // java.net.~
	
	// 2. ���� �����͸� �� �پ� ������ ó��
	BufferedReader br;
	
	// 3. ���� ������ ����
	String line;
	
	public URLReader() {
		
	}
	
	// site �����θ� ����
	public URLReader(String site) {
		try {
			this.url = new URL(site);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 1. ���� ������ ��� �޼���
	public void page() {
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(this.url.openStream());
			this.br = new BufferedReader(isr);
			
			while((this.line = br.readLine()) != null) {
				System.out.println(this.line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		
		}
	}
	
	// 2. ���� �����Ϳ� ���� �⺻ ���� ��� �޼��� : ���ڵ� / ����Ʈ ��
	public void connectInfo() {
		// ���� ���� url ������ ���ؼ� connection�� ���� ��?
		try {
			// openConnection �߿�
			URLConnection conn = this.url.openConnection();
			// �ַ� html5 ������� ������� ��
			System.out.println(conn.getContentEncoding());
			// �ַ� html4 ������� ������� ��
			System.out.println(conn.getContentType());
			System.out.println(conn.getContentLength());
			System.out.println(conn.getContentLengthLong());
			System.out.println(conn);
			System.out.println(conn.getURL());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		String site = "https://www.google.com/index.html";
		URLReader url = new URLReader(site);
		url.page();
		url.connectInfo();
	}

}
