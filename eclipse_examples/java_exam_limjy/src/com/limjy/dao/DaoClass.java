package com.limjy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.limjy.db.DataClass;
import com.limjy.db.MySQLConnector;
import com.limjy.db.Querys;
import com.limjy.dto.CafeMenu;

// sql문 실제 실행하는 것으로 db와 접촉하는 클래스
public class DaoClass {

	public DaoClass() {

	}
	
	/* 데이터베이스 내의 테이블 전체 레코드 조회한 뒤 데이터 저장 */
	public void selectAll() {
		Statement stmt = null;
		ResultSet rs = null;
		
		// 자원해제는 성공하든 실패하든 해야 함 => finally
		try {
			stmt = MySQLConnector.conn.createStatement(); // Statement 객체 생성, 쿼리 문은 나중에 들어가야 함
			// 전체 조회 후, 결과값 저장
			rs = stmt.executeQuery(Querys.QUERY_SELECT_ALL); // => java 코드 쪽이기 때문에 sql에서 쓰던 것과 달리 세미콜론 안 붙여도 ㅇㅋ
			
			while(rs.next()) { // 읽어들일 레코드가 존재하면 true
				DataClass.orderList.add(new CafeMenu(rs.getString("order_id"), rs.getString("order_date"), rs.getString("category"), rs.getString("item"), rs.getInt("price")));
				}
		} catch (SQLException e) {
			System.out.println("SELECT All ERR: " + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e2) {
				System.out.println("SELECT All CLOSE ERR: " + e2.getMessage());
			}
		}
	} // selectAll() END
	
	
	
	// db에 저장된 총 데이터 수 구하기
	public int countData() {
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		// 자원해제는 성공하든 실패하든 해야 함 => finally
		try {
			stmt = MySQLConnector.conn.createStatement(); // Statement 객체 생성, 쿼리 문은 나중에 들어가야 함
			// 전체 조회 후, 결과값 저장
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
	}
	
	/* 값 합산 구하기 */
	public int findCaseSum(String scase, String findV) {
		PreparedStatement pstmt = null;
		int sumV = 0;
		ResultSet rs = null;		
		
		try {
			
			switch(scase) {
				case "i":
					pstmt = MySQLConnector.conn.prepareStatement(Querys.QUERY_SUM_CASE + "item = ?");
					pstmt.setString(1, findV);
					break;
				case "d":
					pstmt = MySQLConnector.conn.prepareStatement(Querys.QUERY_SUM_CASE_SUB);
					pstmt.setInt(1, 0);
					pstmt.setInt(2, 11);
					pstmt.setInt(3, Integer.parseInt(findV));
					break;
				case "t":
					pstmt = MySQLConnector.conn.prepareStatement(Querys.QUERY_SUM_CASE_SUB);
					pstmt.setInt(1, 11);
					pstmt.setInt(2, 13);
					pstmt.setInt(3, Integer.parseInt(findV));
					break;
				default:
					pstmt = MySQLConnector.conn.prepareStatement(Querys.QUERY_SUM_CASE + "category = ?");
					pstmt.setString(1, findV);
					break;
			}
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sumV = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("FIND SUM ERR" + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e2) {
				System.out.println("FIND SUM CLOSE ERR" + e2.getMessage());
			}
		}
		
		return sumV;
	} // findCaseSum() END
	
	/* 값 평균 구하기 */
	public int findCaseAvg(String findV) {
		PreparedStatement pstmt = null;
		int avgV = 0;
		ResultSet rs = null;		
		
		try {
			pstmt = MySQLConnector.conn.prepareStatement(Querys.QUERY_AVG_SUB);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 10);
			pstmt.setString(3, findV.trim());

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				avgV = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("FIND AVG ERR" + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e2) {
				System.out.println("FIND AVG CLOSE ERR" + e2.getMessage());
			}
		}
		
		return avgV;
	} // findCaseSum() END
	
	/* 레코드 추가 */
	public void insert(CafeMenu menu) {
		PreparedStatement pstmt = null;
		int result = 0; // insert into 성공 여부 확인...		
		
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
			} else {
//				System.out.println("INSERT COMPLETE !!!");
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
	
	
	// 전체 데이터 삭제
	public void deleteAll() {
		Statement stmt = null;
		int rs = 1;
		
		// 자원해제는 성공하든 실패하든 해야 함 => finally
		try {
			stmt = MySQLConnector.conn.createStatement();
			// 전체 조회 후, 결과값 저장
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
