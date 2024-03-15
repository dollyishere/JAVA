package com.limjy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*�����ͺ��̽� ����*/
public class MySQLConnector {

	public final String DB_DRIVE = "com.mysql.cj.jdbc.Driver";
	// ��jdbc:Driver ����://IP:��Ʈ��ȣ/DB��/������/��й�ȣ��
	public final String DB_URL = "jdbc:mysql://localhost:3306/";
	public final String DB_NAME = "cafe_db_jy";
	public final String DB_ADMIN_ID = "root";
	public final String DB_ADMIN_PW = "1234";
	
	// import java.sql.Connection
	// static���� �ٸ� ��Ű�� & Ŭ�������� ���� �����ϵ��� ����
	public static Connection conn = null;
	
	// �⺻ ������
	public MySQLConnector() {
		
	}
	
	/* �����ͺ��̽� ���� �޼��� */
	public void connMySQL() {
		try {
			// ����̹� �ε�
			Class.forName(DB_DRIVE);
			// Connection ��ü ���
			conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_ADMIN_ID, DB_ADMIN_PW);
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		} catch (SQLException e2) {
			System.out.println("SQLException: " + e2.getMessage());
		}
		
	} // connMySQL() END
}
