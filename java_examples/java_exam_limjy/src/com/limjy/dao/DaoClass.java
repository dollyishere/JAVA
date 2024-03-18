package com.limjy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.limjy.db.DataClass;
import com.limjy.db.MySQLConnector;
import com.limjy.db.Querys;
import com.limjy.dto.CafeMenu;

// sql�� ���� �����ϴ� ������ db�� �����ϴ� Ŭ����
public class DaoClass {

	public DaoClass() {

	}
	
	/* �����ͺ��̽� ���� ���̺� ��ü ���ڵ� ��ȸ�� �� ������ ���� */
	public void selectAll() {
		Statement stmt = null;
		ResultSet rs = null;
		
		// �ڿ������� �����ϵ� �����ϵ� �ؾ� �� => finally
		try {
			stmt = MySQLConnector.conn.createStatement(); // Statement ��ü ����, ���� ���� ���߿� ���� ��
			// ��ü ��ȸ ��, ����� ����
			rs = stmt.executeQuery(Querys.QUERY_SELECT_ALL); // => java �ڵ� ���̱� ������ sql���� ���� �Ͱ� �޸� �����ݷ� �� �ٿ��� ����
			
			while(rs.next()) { // �о���� ���ڵ尡 �����ϸ� true
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
	
	
	
	// db�� ����� �� ������ �� ���ϱ�
	public int countData() {
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		// �ڿ������� �����ϵ� �����ϵ� �ؾ� �� => finally
		try {
			stmt = MySQLConnector.conn.createStatement(); // Statement ��ü ����, ���� ���� ���߿� ���� ��
			// ��ü ��ȸ ��, ����� ����
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
	
	/* �� �ջ� ���ϱ� */
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
	
	/* �� ��� ���ϱ� */
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
	
	/* ���ڵ� �߰� */
	public void insert(CafeMenu menu) {
		PreparedStatement pstmt = null;
		int result = 0; // insert into ���� ���� Ȯ��...		
		
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
	
	
	// ��ü ������ ����
	public void deleteAll() {
		Statement stmt = null;
		int rs = 1;
		
		// �ڿ������� �����ϵ� �����ϵ� �ؾ� �� => finally
		try {
			stmt = MySQLConnector.conn.createStatement();
			// ��ü ��ȸ ��, ����� ����
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
