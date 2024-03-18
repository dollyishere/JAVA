package com.limjy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*데이터베이스 접속*/
public class MySQLConnector {

	public final String DB_DRIVE = "com.mysql.cj.jdbc.Driver";
	// “jdbc:Driver 종류://IP:포트번호/DB명/유저명/비밀번호”
	public final String DB_URL = "jdbc:mysql://localhost:3306/";
	public final String DB_NAME = "cafe_db_jy";
	public final String DB_ADMIN_ID = "root";
	public final String DB_ADMIN_PW = "1234";
	
	// import java.sql.Connection
	// static으로 다른 패키지 & 클래스에서 참고 가능하도록 설정
	public static Connection conn = null;
	
	// 기본 생성자
	public MySQLConnector() {
		
	}
	
	/* 데이터베이스 접속 메서드 */
	public void connMySQL() {
		try {
			// 드라이버 로드
			Class.forName(DB_DRIVE);
			// Connection 객체 얻기
			conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_ADMIN_ID, DB_ADMIN_PW);
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		} catch (SQLException e2) {
			System.out.println("SQLException: " + e2.getMessage());
		}
		
	} // connMySQL() END
}
