package com.dolly.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Connection 객체는 하나의 서블릿이 일을 마칠 때마다 바로 close() **/
public class MySQLConnector {
	private Connection connector = null;
	
	public final String DB_DRIVE = "com.mysql.cj.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost:3306/";
	public final String DB_NAME = "test";
	public final String DB_ADMIN_ID = "root";
	public final String DB_ADMIN_PW = "1234";
	
	public MySQLConnector() {
	}
	
	public Connection getConnection() {
		if (connector == null) {
			try {
				Class.forName(DB_DRIVE);
				connector = DriverManager.getConnection(DB_URL + DB_NAME, DB_ADMIN_ID, DB_ADMIN_PW);
				System.out.println("됐당");
				return connector;
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: " + e.getMessage());
			} catch (SQLException e2) {
				System.out.println("SQLException: " + e2.getMessage());
			}
		}
		
		return null;
	} // getConnection() END

	/** PreparedStatement, Connection CLOSE **/
	public static void close(PreparedStatement pstmt, Connection connector) {
		if(pstmt != null ) {
			try {
				pstmt.close();
			} catch(Exception e) {
				System.err.println("PreparedStatement CLOSE ERR : " + e.getMessage());
			}
		}
		
		if(connector != null ) {
			try {
				connector.close();
			} catch(Exception e) {
				System.err.println("Connection CLOSE ERR : " + e.getMessage());
			}
		}
	} // close() END
	
	/** ResultSet, PreparedStatement, Connection CLOSE **/
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection connector) {
		if(rs != null ) {
			try {
				rs.close();
			} catch(Exception e) {
					System.err.println("ResultSet CLOSE ERR : " + e.getMessage());
			}
		}
		
		if(pstmt != null ) {
			try {
				pstmt.close();
			} catch(Exception e) {
				System.err.println("PreparedStatement CLOSE ERR : " + e.getMessage());
			}
		}
		
		if(connector != null ) {
			try {
				connector.close();
			} catch(Exception e) {
				System.err.println("Connection CLOSE ERR : " + e.getMessage());
			}
		}
	} // close() END
}
