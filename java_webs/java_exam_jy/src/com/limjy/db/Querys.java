package com.limjy.db;

// 쿼리문 보관 클래스
public interface Querys {
	// table name
	public static final String TABLE_NAME = "cafe_jy";
	
	// insert
	public static final String QUERY_INSERT = "insert into " + TABLE_NAME + " (order_id, order_date, category, item, price) values (?, ?, ?, ?, ?)";
	
	// count
	public static final String QUERY_COUNT_ALL = "select count(*) from " + TABLE_NAME;
	
	// delete all
	public static final String QUERY_DELETE_ALL = "delete from " + TABLE_NAME;

	// update
	public static final String QUERY_UPDATE_ITEM = "update " + TABLE_NAME + " set item = ? where item = ?";
}
