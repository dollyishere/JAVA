package com.dolly.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* Connection 객체는 하나의 서블릿이 일을 마칠 때마다 바로 close() */
public class MySQLConnector {
	public Connection connector = null;
	private final static String SQL_URL = "jdbc:mysql://localhost:3306/";
	private final static String SQL_DRIVE = "com.mysql.cj.jdbc.Driver";
	private final static String SQL_DB_NAME = "test";
	private final static String SQL_USER = "root";
	private final static String SQL_PW = "1234";
	
	
	public MySQLConnector() { // 외부에서 객체 생성 방지
	}
	
	public void connect() {
		// 1. connector가 null인지 확인 후, null일 경우에만 객체 생성
		if(connector == null) {
			// Driver 로드
			try {
				Class.forName(SQL_DRIVE);
				// Connection 객체 얻기
				connector = DriverManager.getConnection(SQL_URL + SQL_DB_NAME, SQL_USER, SQL_PW);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("CLASS | CONNECTION ERR: "  + e.getMessage());
			}
		} // if() END
	} // connect() END

	public void close() { // Connection CLOSE
		if (connector != null) {
			try {
				connector.close();
			} catch (SQLException e) {
				System.err.println("CONNECTION CLOSE ERR: " + e.getMessage());
			}
		} // if() END
	} // close() END
	
	public void close(PreparedStatement pstmt, ResultSet rs) { // Connection CLOSE
		// null이면 굳이 닫을 필요 없기에, 각자 구분
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("ResultSet CLOSE ERR: " + e.getMessage());
			}
		} // if() END
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("PreparedStatment CLOSE ERR: " + e.getMessage());
			}
		} // if() END
		
		if (connector != null) {
			try {
				connector.close();
			} catch (SQLException e) {
				System.err.println("CONNECTION CLOSE ERR: " + e.getMessage());
			}
		} // if() END
	} // close() END
}
