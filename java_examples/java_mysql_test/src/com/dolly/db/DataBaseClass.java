package com.dolly.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* �����ͺ��̽� ���� & ���� ���� ����
  * �����Ϳ� ������ �����ϴ� Ŭ���� => DAO
 * */
public class DataBaseClass {
	public final String DB_Drive = "com.mysql.cj.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost:3306/";
	public final String DB_ADMIN_ID = "root";
	public final String DB_ADMIN_PW = "1234";
	
	
	// java.sql.~~~
	public Connection conn = null;
	
	
	public DataBaseClass() { // �⺻ ������
		
	} // DataBaseClass() END
	
	/* 1. �����ͺ��̽� ���� �޼��� */
	public void connMySQL() {
		try {
			Class.forName(DB_Drive);	// ����̹� �ε�
			// Connection ��ü ���
			conn = DriverManager.getConnection(DB_URL + "test", DB_ADMIN_ID, DB_ADMIN_PW);
			System.out.println("����̹�, ���� ���� !!!");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound ERR : " + e.getMessage());
			
		} catch (SQLException e2) {
			System.out.println("SQLException ERR : " + e2.getMessage());
		}
	} // connMySQL() END
	
	/* 2. �����ͺ��̽� ���� ���̺� ��ü ���ڵ� ��ȸ */
	// select * from employee
	// Connection, Statement(static�̱⿡, Ŀ�ؼ� ������ �޾ƾ� ��), ResultSet
	public void selectAll() {
		Statement stmt = null;
		ResultSet rs = null;
		
		// �ڿ������� �����ϵ� �����ϵ� �ؾ� �� => finally
		try {
			stmt = conn.createStatement(); // Statement ��ü ����, ���� ���� ���߿� ���� ��
			// ��ü ��ȸ ��, ����� ����
			rs = stmt.executeQuery("select * from employee"); // => java �ڵ� ���̱� ������ sql���� ���� �Ͱ� �޸� �����ݷ� �� �ٿ��� ����
			
			while(rs.next()) { // �о���� ���ڵ尡 �����ϸ� true
				System.out.println(rs.getString("empname") + "\t"); // ��ȸ�� �ʵ� �� emp_name �ʵ� ���� Ȯ��
				System.out.println(rs.getInt("sale")); // ��ȸ�� �ʵ� �� sale �ʵ� ���� Ȯ��
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
	
	/* 3. �����ͺ��̽� ���� ���̺��� empNo(��� ������ȣ => ����ȭ)�� ��ȸ */
	// �������� ����(�˻��� ��� ���� ��ȣ)�� �Է��ؾ� ��
	// ��ȸ�� select * from ���̺�� where empNum = ?
	// ��, �����ȣ�� ���� �Է��� ��
	// ? => String n = "1234";
	// "select * from employee where empno = " + n
	// "select * from employee where empno=" + "1234 => �̷��� �ص� sql�� 1234�� ���ڰ� �ƴ϶� ���ڷ� �ν�
	// ������ �ڹ� �ʿ��� ����Ǵ� �� �ƴ϶�, mysql�ʿ��� �����ϴ� ��
	// ���� "select * from employee where empno='1234'"��� �ۼ������ ��
	// �̸� �� ���� ���ִ� �� Prepare
	// Connection, PreparedStatement, ResultSet
	// PreparedStatement�� Connection�� ���� ��ü�� ��ȯ�޴´�
	// ��, PreparedStatement�� �̸� ������ �־�־� �Ѵ�! => �Ϲ� Statement�� ������
	public void selectOne() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from employee where empno=?";
		
		try {
			pstmt = conn.prepareStatement(query); // => �������� �̸� �� �־�� ��
			pstmt.setInt(1, 1001); // ���� ���� (����ǥ���� �ε����� ����, 1���� ����)
			// pstmt.setString(2, query) => �� ��° ����ǥ�� ������ �־�޶�~�� �ǹ�
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("empname") + " " + rs.getInt("sale"));
			}
		} catch(SQLException e) {
			System.out.println("SELECT ON ERR: " + e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e2) {
				System.out.println("SELECT ON CLOSE ERR: " + e2.getMessage());
			}
		} 
	} // selectOne() END

	// ��ü ���ڵ� �� �Ϻκи� ��ȸ
	// select * from employee limit ���� index, �� index < == MySQL ����
	// select * from employee limit ?, ?
	// ����Ŭ������ between�� �����
	public void selectLimit(int startIndex) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from employee limit ?, ?";

		int count = 5;
		
		try {
			pstmt = conn.prepareStatement(query);
			// ù��° ����ǥ �� ����(int)
			pstmt.setInt(1, startIndex);
			// �ι�° ����ǥ �� ����(int)
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("empname") + " : " + rs.getInt("sale") + " : " + rs.getString("hireDate"));
			}
			
			
		} catch(SQLException e) {
			System.out.println("SELECT LIMIT ERR: " + e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e2) {
				System.out.println("SELECT LIMIT CLOSE ERR: " + e2.getMessage());
			}
		} 
		
	} // selectLimit() END
	
	/* ���ڵ� �߰� */
	// insert into employee (empNo, empName, hireDate, sale) values (1015, 'dolly' 2024-03-12', 500);
	// 					 X	  X		X					X		X
	// (empNo, empName, job, mgr, hireDate, sale, commission, deptNo)
	// (empNo, empName, hireDate, sale)
	// ����ǥ�� �� 4���� �ʿ�
	// ���� ���� ��� ������ insert into employee (empNo, empName, hireDate, sale) values (?, ?, ?, ?);�� ��
	// �츮�� ����ϴ� ��ü�� pstmt�� ��
	// Connection, PreparedStatement, int result
	// ResultSet�� ��ȸ�� ������� �޾ƿ��� �뵵!
	public void insert() {
		PreparedStatement pstmt = null;
		int result = 0; // insert into ���� ���� Ȯ��...
		int empno = 1015;
		String empname = "dolly";
		String hiredate = "2024-03-12";
		int sale = 500;
		
		String query = "insert into employee (empNo, empName, hireDate, sale) values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empno);
			pstmt.setString(2, empname);
			pstmt.setString(3, hiredate);
			pstmt.setInt(4, sale);
			
			result = pstmt.executeUpdate();
			
			if (result < 1) {
				System.out.println("INSERT FAIL !!!");
			} else {
				System.out.println("INSERT COMPLETE !!!");
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
	
	/* ���ڵ� ���� */
	// update employee set job=?, mgr=?, commission=0, deptno=20 => �̷��� ��� ����� �� �ٲ�����
	// where empno = ?�� ������ �ɾ���� ��
	// ���, 13, 1015
	// Connection, PreparedStatement, int result
	// state�� ���� �������� �ʴ� �� null�� �� ���� ����
	public void update() {
		PreparedStatement pstmt = null;
		int result = 0; // Update �������� Ȯ��
		String job = "���";
		String mgr = "13";
		int empno = 1015;
		
		String query = "update employee set job=?, mgr=?, commission=0, deptno=20 where empno=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, job);
			pstmt.setString(2, mgr);
			pstmt.setInt(3, empno);
			
			result = pstmt.executeUpdate();
			if(result < 1) {
				System.out.println("UPDATE FAIL !!!");
			} else {
				System.out.println("UPDATE COMPLETE !!!");
			}
			
		} catch(SQLException e) {
			System.out.println("UPDATE ERR: " + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch(SQLException e2) {
				System.out.println("UPDATE CLOSE ERR: " + e2.getMessage());
			}
		}
		
	} // update() END
	
	/* ���ڵ� ���� */
	// delete from employee where empno=?
	// Connection, PreparedStatement, int result
	public void delete() {
		PreparedStatement pstmt = null;
		int empno = 1015;
		
		String query = "delete from employee where empno=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empno);
			
			int result = 0;
			
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("DELETE FAIL !!!");
			} else {
				System.out.println("DELETE COMPLETE !!!");
			}
			
		} catch(SQLException e) {
			System.out.println("DELETE ERR: " + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch(SQLException e2) {
				System.out.println("DELETE CLOSE ERR: " + e2.getMessage());
			} 
		}
	} // delete() END
}
