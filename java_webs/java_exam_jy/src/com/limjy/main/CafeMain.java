package com.limjy.main;

import com.limjy.db.MySQLConnector;
import com.limjy.util.UtilClass;
import com.limjy.view.PrintClass;

// 메인 클래스 (컨트롤러)
public class CafeMain {

	public static void main(String[] args) {
		MySQLConnector dbc = new MySQLConnector();
		dbc.connMySQL();
		
		PrintClass.printStart();

	}

}
