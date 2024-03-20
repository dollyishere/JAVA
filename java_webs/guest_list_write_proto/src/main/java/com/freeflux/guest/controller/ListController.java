package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.freeflux.guest.dao.MySQLConnector;
import com.freeflux.guest.dao.Querys;
import com.freeflux.guest.dto.Guest;

/** Table(guest) 의 모든 레코드를 읽기 **/
// 1. MySQL 접속 => Connection
// 2. Connection => Statetment
// 3. select (필드명...) from guest order by desc
// 4. ResultSet = Statetment.executeQuery(쿼리)
// 5. ResultSet에 레코드 여부 확인 (list.jsp에서 처리)
// 6. 레코드가 없으면 : 게시된 글이 없습니다.. (list.jsp에서 처리)
// 7. 레코드 존재 : while(ResultSet.next()){ }
// 8. while문 내부
// 8-1. 레코드를 하나의 객체로...
// 8-2. 객체를 ArrayList에 추가

public class ListController extends MySQLConnector implements Querys {
	Connection connector = null;

	public ListController() {
		this.connector = connect();
	}

	public List<Guest> list() {
		ArrayList<Guest> glist = new ArrayList<Guest>();


		System.out.println("ListController => list() END ");
		return glist;
		
	}
}
