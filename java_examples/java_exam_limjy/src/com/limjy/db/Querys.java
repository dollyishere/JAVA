package com.limjy.db;

//쿼리문 상수로 저장
public interface Querys {
	// table name
	public static final String TABLE_NAME = "cafe_jy";
	// create
	public static final String QUERY_INSERT = "insert into " + TABLE_NAME + " (order_id, order_date, category, item, price) values (?, ?, ?, ?, ?)";
	// read
	public static final String QUERY_SELECT_ALL = "select * from " + TABLE_NAME;
	public static final String QUERY_SELECT_ONE = "select * from " + TABLE_NAME + " where order_no=?";
	// get sum value by case
	public static final String QUERY_SUM_CASE = "select sum(price) as case_sum from " + TABLE_NAME + " where ";
	public static final String QUERY_SUM_CASE_SUB = "select sum(price) as case_sum from " + TABLE_NAME + " where substring(order_date, ?, ?) = ?";
	// delete all
	public static final String QUERY_DELETE_ALL = "delete from " + TABLE_NAME;
	// count
	public static final String QUERY_COUNT_ALL = "select count(*) from " + TABLE_NAME;
	// average (only date)
	public static final String QUERY_AVG_SUB = "select avg(price) from " + TABLE_NAME + " where substring(order_date, ?, ?) = ?";
}
