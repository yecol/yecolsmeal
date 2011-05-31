package com.qq.cstar.speedymeal.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnection {

	private Connection conn;

	private void createConn() {
		try {
			Context initCtx = new javax.naming.InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/speedymeal");
			this.conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("从连接池获取连接异常：" + e.getMessage());
		}
	}

	public Connection getConn() {
		if (conn == null) {
			createConn();
		}
		return this.conn;
	}

	public void freeConn() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			System.out.println("与连接池断开异常：" + e.getMessage());
		}
		this.conn = null;
	}

}
