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
			System.out.println("�����ӳػ�ȡ�����쳣��" + e.getMessage());
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
			System.out.println("�����ӳضϿ��쳣��" + e.getMessage());
		}
		this.conn = null;
	}

}
