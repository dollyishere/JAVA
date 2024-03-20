package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.freeflux.db.MySQLConnector;
import com.freeflux.db.Querys;

/** 게시글 삭제 컨트롤러 **/
public class DeleteController extends MySQLConnector implements Querys {
	Connection conn = null;
	
	public DeleteController() {
		this.conn = connect();
	}
	
	public void delete(int idx) {
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			pstmt = conn.prepareStatement(QUERY_DELETE);
			pstmt.setInt(1, idx);
			n = pstmt.executeUpdate();
			
			if (n < 1) {
				System.out.println("DELETE FAIL");
			}
			
		} catch (SQLException e) {
			System.out.println("DELETE ERR" +  e.getMessage());
		} finally {
			close(conn, pstmt);
		}
		
		System.out.println("DeleteController => delete()");	
	}


}
