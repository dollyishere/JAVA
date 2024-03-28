package com.dolly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	private Connection connector = null;
	private PreparedStatement pstmt = null;
	private MySQLConnector datasource = null;
	private ResultSet rs = null;

	public MemberDAO() {
		datasource = new MySQLConnector();
	}

	public boolean overlappedID(String id) {
		boolean result = false;
		
		try {
			connector = datasource.getConnection();
			String query = "select id from t_member where id=?";
			pstmt = connector.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			result = rs.next(); // 조회된 id가 있으면 true, 없으면 false
			return result;
		} catch (Exception e) {
			System.err.println("ID SELECT ERR : " + e.getMessage());
		} finally {
			datasource.closeConnection(rs, pstmt, connector);
		}
		return result;
	}
}
