package com.freeflux.guest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.freeflux.guest.dao.MySQLConnector;
import com.freeflux.guest.dao.Querys;
import com.freeflux.guest.dto.Guest;

public class InsertController  extends MySQLConnector implements Querys{
	Connection connector = null;

	
	public InsertController() {
		this.connector = connect();
	}

	public int insert(Guest guest) {
		
		int n=0;

		System.out.println("InsertController => insert() END" );
		return n;
	}
}
