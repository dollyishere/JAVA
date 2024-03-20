package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.freeflux.db.MySQLConnector;
import com.freeflux.db.Querys;
import com.freeflux.dto.GuestClass;

/** 이름, 타이틀, 내용 갱신 컨트롤러 **/
public class UpdateController extends MySQLConnector implements Querys {
	Connection conn = null;
	
	public UpdateController() {
		this.conn = connect();
	}
	
	public void update(GuestClass guest) {
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			pstmt = conn.prepareStatement(QUERY_UPDATE);
			pstmt.setString(1,  guest.getName());
			pstmt.setString(2, guest.getTitle());
			pstmt.setString(3, guest.getContent());
			pstmt.setInt(4, guest.getIdx());
			
			n = pstmt.executeUpdate();
			
			if(n < 1) {
				System.out.println("UPDATE ERR");
			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			close(conn, pstmt);
		}
		System.out.println("UpdateController => update()");
	}

	public void update(int hit, int idx) {
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			pstmt = conn.prepareStatement(QUERY_UPDATE_HIT);
			pstmt.setInt(1,  ++hit);
			pstmt.setInt(2,  idx);
			System.out.println(pstmt);
			
			n = pstmt.executeUpdate();
			
			if(n < 1) {
				System.out.println("UPDATE HIT ERR");
			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			close(conn, pstmt);
		}
		System.out.println("UpdateHITController => update()");
	}
}
