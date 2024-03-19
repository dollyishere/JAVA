package com.dolly.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dolly.db.MySQLConnector;
import com.dolly.db.Querys;

/**
 * 1. MySQL DB 접속 => Connection
 * 2. select * from member where id='admin' and pw = '1234';
 * 2-1. String query = "select * from member where id=? and pw=?";
 * 2-2 PreparedStatement 객체 = Connection.~(query)
 * 2-3 PreparedStatement.setString(1, ")
 * 2-4 ResultSet 객체 = PreparedStatement 객체 executeQuery();
 * 3. ResultSet => next() => 1 record / 0 하나밖에 없거나, 아무것도 없거나 둘 중 하나
 *  // 조건에 맞는 값이 없어도 무조건 ResultSet은 반환되므로 절대 null과 비교하지 말 것(객체는 만들어졌으나 실제 데이터가 없는 상태일 뿐임)
 * if(ResultSet.next() {
 * 	// 아이디와 비밀번호가 맞았을 경우
 * } else {
 * 	// 아이디와 비밀번호가 틀렸을 경우
 * }
 * **/
public class MemberController extends MySQLConnector {
	/** MYSQLConnector로부터 상속받은 변수 및 메서드 **/
	// public Connection connector = null;
	// public void connect() {}
	// public void close() {}
	

	public MemberController() {
		connect(); // db 접속 완료
	}

	/** id, pw를 비교한 결과를 문자열 형태로 DispatcherServlet에게 반환 **/
	// 로그인 성공 :  SUCCESS / 실패 : FAIL
	public String join(String id, String pw) {
		// close() 해야 할 객체 선언 시, 기본 값을 null로 설정
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null; // String 변수 선언 시, 기본 값을 null로 설정하면 추후 비교가 편리
		// 숫자 관련 변수 선언 시 기본값을 0으로 설정!!
		
		try {
			pstmt = connector.prepareStatement(Querys.SQL_JOIN);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			// 결과 : 1 record 또는 없는 레코드 값 <= rs.next() : true(1) / false(0)
			
			// 변수 안만들고 바로 return하는 방법도 있음!
			
			if (rs.next()) {
				result = "SUCCESS";
			} else {
				result = "FAIL";
			}
			
		} catch (SQLException e) {
			System.out.println("JOIN ERR" + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return result;
	} // join() END
}
