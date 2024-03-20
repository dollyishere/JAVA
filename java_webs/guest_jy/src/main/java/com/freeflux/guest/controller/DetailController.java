package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.freeflux.db.MySQLConnector;
import com.freeflux.db.Querys;
import com.freeflux.dto.GuestClass;

/** 단일 객체 데이터 불러오는 컨트롤러 **/
public class DetailController extends MySQLConnector implements Querys {
	Connection conn = null;
	
	public DetailController() {
		this.conn = connect();
	}
	
	public GuestClass detail(int idx) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestClass guest = new GuestClass();
		
		try {
			pstmt = conn.prepareStatement(QUERY_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				guest.setIdx(rs.getInt("idx")); // idx
				guest.setName(rs.getString("name")); // name
				guest.setTitle(rs.getString("title")); // title
				guest.setContent(rs.getString("content")); // content
				guest.setMoment(rs.getString("moment")); // moment
				guest.setHit(rs.getInt("hit")); // hit
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			close(conn, pstmt, rs);
		}
		
		System.out.println("DetailController => detail()");
		return guest;
	}

}
