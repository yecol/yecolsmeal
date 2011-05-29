package com.qq.cstar.speedymeal.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.sql.DataSource;

public class DbConnection {
	
	private Connection conn;
	
	private void createConn(){
		try{
			Context initCtx=new javax.naming.InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			DataSource ds=(DataSource)envCtx.lookup("jdbc/speedymeal");
			conn=ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Connection getConn(){
		if(conn== null){
			createConn();
		}
		return this.conn;
	}

}
