package com.limjy.main;

import com.limjy.dao.DaoClass;
import com.limjy.db.DataClass;
import com.limjy.db.MySQLConnector;
import com.limjy.util.UtilClass;
import com.limjy.view.PrintClass;

public class CafeMain {

	public static void main(String[] args) {
		MySQLConnector dbc = new MySQLConnector();
		dbc.connMySQL(); // ����̹� �ε� �� ����
		
		// db�� ������ �Է�
		UtilClass.readInsertData();
		
		// �޴� ���
		PrintClass.startMenu();
	}

}
