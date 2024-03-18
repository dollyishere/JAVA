package com.dolly;

import java.util.Scanner;

import com.dolly.db.DataBaseClass;

/*
 * Controller
 * Dispacher class
 * */
public class MainClass {

	public static void main(String[] args) {
		DataBaseClass dbc = new DataBaseClass();
		dbc.connMySQL(); // 드라이버 로드 및 접속
		/* 데이터베이스 C(create) R(read) U(update) D(delete 연습) */
//		dbc.selectAll(); // 전체 레코드 조회
//		dbc.selectOne(); // 하나의 레코드 조회
//		dbc.selectLimit(300); // 전체 레코드 중 일부 레코드들만 조회
//		dbc.insert(); // 레코드 추가
//		dbc.update(); // 레코드 수정
//		dbc.delete(); // 레코드 삭제
		
		Scanner sc = new Scanner(System.in);
		
		/* switch ~ case */
		// switch의 각 case가 가진 값은 다 틀려야 함
		// case는 다 break가 걸려야 함
		int key = 1;
		boolean status = true;
		
		
		while(status) {
			System.out.println("아래 메뉴에서 작업할 번호를 입력해 주세요...");
			System.out.println("1. 전체조회 / 2. 레코드 삽입 / 3. 레코드 수정 / 4. 레코드 삭제 / 5. 작업 종료");
			System.out.println("------------------------------------------------------------------------------");
			
			key = sc.nextInt();
			
			switch(key) {
			case 1:
				System.out.println("전체조회 화면.");
				dbc.selectAll();
				break;
			case 2:
				System.out.println("레코드 삽입.");
				dbc.insert();
				break;
			case 3:
				System.out.println("레코드 수정.");
				dbc.update();
				break;
			case 4:
				System.out.println("레코드 삭제.");
				dbc.delete();
				break;
			default:
				status = false;
				break;
			} // switch (key) END
		} // while(status) END
		
		sc.close();
		System.out.println("종료되었습니다.");
		
//		// 1. 드라이버 로드
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("드라이버 로드 성공");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//	
//	
//		// 2. Connection 객체 반환 받기 => java.sql.Connection
//		Connection conn = null;
//		
//		try {
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
//			// Access denied for user 'root'@'localhost' (using password: YES)
//			System.out.println("DB 접속 성공");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		
//		// 3. SQL 쿼리 객체
//		Statement stmt = null; // java.sql.Statement
//		try {
//			stmt = conn.createStatement(); // Statement 객체는 생성 시, 쿼리문을 사용하지 않는다
//			System.out.println("Statement 객체 생성 완료");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		// 4. 생성된 Statement 객체에 쿼리 전달
//		String query = "select * from tbl";
//		ResultSet rs = null;
//		try {
//			rs = stmt.executeQuery(query); // select ~ from ~ 전용
//			System.out.println("조회 성공");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		// 5. 조회된 결과(ResultSet 객체)의 레코드값 확인
//		try {
//			while(rs.next()) {
//				System.out.println(rs.getString("id") + " : " + rs.getString("name"));
//				System.out.println(rs.getString(1) + " : " + rs.getString(2));
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		// 6. 사용이 완료된 DB 자원 해제
//		try {
//			rs.close();
//			stmt.close();
//			conn.close();
//			System.out.println("자원해제 성공");
//		} catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
		
	}
} // main() END
