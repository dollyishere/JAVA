package com.dolly.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* 데이터베이스 접속 & 각종 쿼리 실행
  * 데이터에 실제로 접근하는 클래스 => DAO
 * */
public class DataBaseClass {
	public final String DB_Drive = "com.mysql.cj.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost:3306/";
	public final String DB_ADMIN_ID = "root";
	public final String DB_ADMIN_PW = "1234";
	
	
	// java.sql.~~~
	public Connection conn = null;
	
	
	public DataBaseClass() { // 기본 생성자
		
	} // DataBaseClass() END
	
	/* 1. 데이터베이스 접속 메서드 */
	public void connMySQL() {
		try {
			Class.forName(DB_Drive);	// 드라이버 로드
			// Connection 객체 얻기
			conn = DriverManager.getConnection(DB_URL + "test", DB_ADMIN_ID, DB_ADMIN_PW);
			System.out.println("드라이버, 접속 성공 !!!");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound ERR : " + e.getMessage());
			
		} catch (SQLException e2) {
			System.out.println("SQLException ERR : " + e2.getMessage());
		}
	} // connMySQL() END
	
	/* 2. 데이터베이스 내의 테이블 전체 레코드 조회 */
	// select * from employee
	// Connection, Statement(static이기에, 커넥션 도움을 받아야 함), ResultSet
	public void selectAll() {
		Statement stmt = null;
		ResultSet rs = null;
		
		// 자원해제는 성공하든 실패하든 해야 함 => finally
		try {
			stmt = conn.createStatement(); // Statement 객체 생성, 쿼리 문은 나중에 들어가야 함
			// 전체 조회 후, 결과값 저장
			rs = stmt.executeQuery("select * from employee"); // => java 코드 쪽이기 때문에 sql에서 쓰던 것과 달리 세미콜론 안 붙여도 ㅇㅋ
			
			while(rs.next()) { // 읽어들일 레코드가 존재하면 true
				System.out.println(rs.getString("empname") + "\t"); // 조회된 필드 중 emp_name 필드 값만 확인
				System.out.println(rs.getInt("sale")); // 조회된 필드 중 sale 필드 값만 확인
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
	
	/* 3. 데이터베이스 내의 테이블에서 empNo(사원 고유번호 => 변수화)로 조회 */
	// 쿼리문에 변수(검색할 사원 고유 번호)를 입력해야 함
	// 조회는 select * from 테이블명 where empNum = ?
	// 단, 사원번호는 내가 입력한 값
	// ? => String n = "1234";
	// "select * from employee where empno = " + n
	// "select * from employee where empno=" + "1234 => 이렇게 해도 sql은 1234를 숫자가 아니라 문자로 인식
	// 쿼리는 자바 쪽에서 실행되는 게 아니라, mysql쪽에서 실행하는 것
	// 따라서 "select * from employee where empno='1234'"라고 작성해줘야 함
	// 이를 더 쉽게 해주는 게 Prepare
	// Connection, PreparedStatement, ResultSet
	// PreparedStatement는 Connection을 통해 객체를 반환받는다
	// 단, PreparedStatement는 미리 쿼리를 넣어둬야 한다! => 일반 Statement와 차이점
	public void selectOne() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from employee where empno=?";
		
		try {
			pstmt = conn.prepareStatement(query); // => 쿼리문이 미리 들어가 있어야 함
			pstmt.setInt(1, 1001); // 정수 세팅 (물음표에도 인덱스가 붙음, 1부터 시작)
			// pstmt.setString(2, query) => 두 번째 물음표에 쿼리를 넣어달라~는 의미
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

	// 전체 레코드 중 일부분만 조회
	// select * from employee limit 시작 index, 끝 index < == MySQL 전용
	// select * from employee limit ?, ?
	// 오라클에서는 between을 사용함
	public void selectLimit(int startIndex) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from employee limit ?, ?";

		int count = 5;
		
		try {
			pstmt = conn.prepareStatement(query);
			// 첫번째 물음표 값 배정(int)
			pstmt.setInt(1, startIndex);
			// 두번째 물음표 값 배정(int)
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
	
	/* 레코드 추가 */
	// insert into employee (empNo, empName, hireDate, sale) values (1015, 'dolly' 2024-03-12', 500);
	// 					 X	  X		X					X		X
	// (empNo, empName, job, mgr, hireDate, sale, commission, deptNo)
	// (empNo, empName, hireDate, sale)
	// 물음표는 총 4개가 필요
	// 따라서 실제 사용 쿼리는 insert into employee (empNo, empName, hireDate, sale) values (?, ?, ?, ?);가 됨
	// 우리가 사용하는 객체는 pstmt가 됨
	// Connection, PreparedStatement, int result
	// ResultSet은 조회한 결과값만 받아오는 용도!
	public void insert() {
		PreparedStatement pstmt = null;
		int result = 0; // insert into 성공 여부 확인...
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
	
	/* 레코드 수정 */
	// update employee set job=?, mgr=?, commission=0, deptno=20 => 이러면 모든 사원이 다 바뀌어버림
	// where empno = ?로 조건을 걸어줘야 함
	// 사원, 13, 1015
	// Connection, PreparedStatement, int result
	// state는 쿼리 실행하지 않는 한 null이 될 일은 없음
	public void update() {
		PreparedStatement pstmt = null;
		int result = 0; // Update 성공여부 확인
		String job = "사원";
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
	
	/* 레코드 삭제 */
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
