package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.freeflux.db.MySQLConnector;
import com.freeflux.db.Querys;
import com.freeflux.dto.GuestClass;

public class InsertController extends MySQLConnector implements Querys {
	Connection conn = null;

	public InsertController() {
		this.conn = connect();
	}

	public void insert(GuestClass guest) {
		PreparedStatement pstmt = null;
		int n=0;
		try {
			pstmt = conn.prepareStatement(QUERY_INSERT);
			pstmt.setString(1,  guest.getName());
			pstmt.setString(2, guest.getTitle());
			pstmt.setString(3, guest.getContent());
			
			n = pstmt.executeUpdate();
			
			if(n < 1) {
				System.out.println("INSERT ERR");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			close(conn, pstmt);
		}
		System.out.println("InsertController => insert() END");
	}
}
