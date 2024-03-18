package com.naver.news;

public class NaverMainClass {

	public static void main(String[] args) {
		final String loadUri = "c:/filetest/naver_news_stand_data_edit.txt";
		final String saveUri = "c:/filetest/naver_news_stand_complete.html";

		NaverMethodClass.readData(loadUri);
		String tags =NaverMethodClass.makeHTMLTags();
		
		NaverPrintClass.createHTML(saveUri, tags);

	}

}

