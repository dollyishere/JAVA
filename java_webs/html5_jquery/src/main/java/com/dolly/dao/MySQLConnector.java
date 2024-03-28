package com.dolly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				return connector;
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: " + e.getMessage());
			} catch (SQLException e2) {
				System.out.println("SQLException: " + e2.getMessage());
			}
		}
		
		return null;
	}
	
	public void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection connector) {
			try {
				if (rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if (connector != null) {
					connector.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
