package com.freeflux.db;

// DB 관련 쿼리 정리
public interface Querys {
	// 테이블 명
	public static final String TABLE_NAME = "guest";
	
	// 데이터 역순으로 전부 뽑아오기
	public final String QUERY_SELECT_ALL_DESC = "select idx, name, title, moment, hit from " + TABLE_NAME + " order by idx desc";
	public final String QUERY_SELECT_ONE = "select * from " + TABLE_NAME + " where idx = ?";
	public final String QUERY_INSERT = "insert into " + TABLE_NAME + "(name, title, content, moment, hit) values (?, ?, ?, now(), 0)";
	public final String QUERY_UPDATE = "update " + TABLE_NAME + " set name = ?, title = ?, content = ? where idx = ?";
	public final String QUERY_UPDATE_HIT = "update " + TABLE_NAME + " set hit = ? where idx = ?";
	public final String QUERY_DELETE = "delete from " + TABLE_NAME + " where idx = ?";
 	
}
