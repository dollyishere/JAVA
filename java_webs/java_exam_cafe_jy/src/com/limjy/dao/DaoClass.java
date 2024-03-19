package com.limjy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.limjy.db.MySQLConnector;
import com.limjy.db.Querys;
import com.limjy.dto.CafeOrder;

// 실제 db 데이터에 접근하는 클래스
public class DaoClass {

	// 생성자
	public DaoClass() {
	}
	
	// cafe.txt 데이터 입력
	public void insert(CafeOrder menu) {
		PreparedStatement pstmt = null;
		int result = 0; // insert into 결과 확인		
		
		try {
			pstmt = MySQLConnector.conn.prepareStatement(Querys.QUERY_INSERT);
			pstmt.setString(1, menu.getOrderId());
			pstmt.setString(2, menu.getOrderDate());
			pstmt.setString(3, menu.getCategory());
			pstmt.setString(4, menu.getItem());
			pstmt.setInt(5, menu.getPrice());
			
			result = pstmt.executeUpdate();
			
			if (result < 1) {
				System.out.println("INSERT FAIL !!!");
			}
			
		} catch (SQLException e) {
			System.out.println("INSERT ERR" + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e2) {
				System.out.println("INSERT CLOSE ERR" + e2.getMessage());
			}
		}
	} // insert() END
	
	
	// 조건에 맞는 데이터 지정한 값으로 업데이트
	public void updateItemData(String tData, String cData) {
		PreparedStatement pstmt = null;
		int rs = 1;		
		
		try {
			pstmt = MySQLConnector.conn.prepareStatement(Querys.QUERY_UPDATE_ITEM);
			pstmt.setString(1, cData);
			pstmt.setString(2, tData);

			rs = pstmt.executeUpdate();
			
			if (rs < 1) {
				System.out.println("UPDATE DATA FAIL !!!");
			}
			
		} catch (SQLException e) {
			System.out.println("UPDATE ERR" + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e2) {
				System.out.println("UPDATE CLOSE ERR" + e2.getMessage());
			}
		}
	} // updateData() END
	
	// 데이터 수 세기
	public int countData() {
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			stmt = MySQLConnector.conn.createStatement();
			rs = stmt.executeQuery(Querys.QUERY_COUNT_ALL);
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("COUNT All ERR: " + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e2) {
				System.out.println("COUNT All CLOSE ERR: " + e2.getMessage());
			}
		}
		return cnt;
	} // countData()
	
	// 기존 테이블 데이터 삭제
	public void deleteAll() {
		Statement stmt = null;
		int rs = 1;
		
		try {
			stmt = MySQLConnector.conn.createStatement();
			rs = stmt.executeUpdate(Querys.QUERY_DELETE_ALL);
			if (rs < 1) {
				System.out.println("DELETE ALL FAIL !!!");
			}
			
		} catch (SQLException e) {
			System.out.println("DELECT All ERR: " + e.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				System.out.println("DELECT All CLOSE ERR: " + e2.getMessage());
			}
		}
	} // deleteAll() END
}
