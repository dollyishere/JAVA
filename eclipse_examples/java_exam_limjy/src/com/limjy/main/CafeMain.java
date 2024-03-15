package com.limjy.main;

import com.limjy.dao.DaoClass;
import com.limjy.db.DataClass;
import com.limjy.db.MySQLConnector;
import com.limjy.util.UtilClass;
import com.limjy.view.PrintClass;

public class CafeMain {

	public static void main(String[] args) {
		MySQLConnector dbc = new MySQLConnector();
		dbc.connMySQL(); // 드라이버 로드 및 접속
		
		// db에 데이터 입력
		UtilClass.readInsertData();
		
		// 메뉴 출력
		PrintClass.startMenu();
	}

}
