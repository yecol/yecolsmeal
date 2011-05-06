package com.qq.cstar.speedymeal.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.sql.DataSource;

public class DbConnection {
	
	private Connection conn;
	
	public void createConn(){
		try{
			Context initCtx=new javax.naming.InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:comp/env");
			DataSource ds=(DataSource)envCtx.lookup("jdbc/speedymeal");
			conn=ds.getConnection();
			System.out.println("create a new conn");
		}catch(Exception e){
			System.out.println("failed to create a new conn");
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
