package com.qq.cstar.speedymeal.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnection {

	private Connection conn;
	private Context initCtx;

	public DbConnection() {
		conn = null;
		try {
			initCtx = new javax.naming.InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void createConn() {
		try {
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/speedymeal");
			this.conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		if (conn == null) {
			createConn();
		}
		return this.conn;
	}
	
	public void freeConn(){
		this.conn = null;
	}

}
