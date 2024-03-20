package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.freeflux.db.MySQLConnector;
import com.freeflux.db.Querys;
import com.freeflux.dto.GuestClass;

/** Table(guest)의 모든 레코드를 읽기 **/
// 1. mySQL 접속 => Connection
// 2. Connection => Statement
// 3. select (필드명...) from guest order by desc
// 4. ResultSet = StatementexcuteQuery(쿼리)
// 5. ResultSet 레코드 여부 확인
// 6. 레코드가 없으면 : 게시된 글이 없습니다..
// 6-1. 레코드 존재 여부를 어떻게 확인하는가? => .next()로 확인하기에는 포커스가 하나씩 내려가기에 첫 데이터를 읽는 것이 불가함
// 6-2. 그래서 만들어진 것이 previous
// 7. 레코드가 있으면 : while문으로 레포 다 읽어두기(rs.next())
// 8. while문 내부
// 8-1. 레코드를 하나의 객체로...
// 8-2. 객체를 꺼낼 때마다 하나의 레코드를 객체로 만들어 arrayList에 추가함
// 9. 최종적으로 arrayList를 리턴
public class ListController extends MySQLConnector implements Querys {
	Connection conn = null;
	
	// 초기 생성자
	public ListController() {
		this.conn = connect();
	}

	// 게시물 전체 데이터 불러오기
	public ArrayList<GuestClass> list() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<GuestClass> guestData = new ArrayList<GuestClass>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(QUERY_SELECT_ALL_DESC);
//			if (rs.previous()) {
//				while(rs.next()) {
//					guestData.add(new GuestClass(
//							Integer.parseInt(rs.getString("idx")),
//							rs.getString("name"), rs.getString("title"), 
//							rs.getString("content"), rs.getString("moment"), 
//							Integer.parseInt(rs.getString("hit"))));
//				}
//			}
			GuestClass guest = null;
			while(rs.next()) {
				guest = new GuestClass();
				
				guest.setIdx(rs.getInt(1)); // idx
				guest.setName(rs.getString(2)); // name
				guest.setTitle(rs.getString(3)); // title
				guest.setMoment(rs.getString(4)); // moment
				guest.setHit(rs.getInt(5)); // hit
				
				guestData.add(guest);
			}
		} catch (SQLException e) {
			System.out.println("SELECT ALL ERR" +  e.getMessage());
		} finally {
			close(conn, stmt, rs);
		}
		
		System.out.println("ListController => list()");
		
		return guestData;
	} // list() END
}
