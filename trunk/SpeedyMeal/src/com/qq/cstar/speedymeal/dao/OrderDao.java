package com.qq.cstar.speedymeal.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.OrderItem;
import com.qq.cstar.speedymeal.util.Serialize;

public class OrderDao {

	DbConnection dbc;

	public OrderDao() {
		dbc = new DbConnection();
	}

	public boolean addOrder(int uid,int mid,int bid, ArrayList<OrderItem> orderItems) {
		String sql = "INSERT INTO invoice (uid,mid,bid,orderTime,orderItems) VALUES (?,?,?,NOW(),?)";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, mid);
			ps.setInt(3, bid);
			ps.setString(4, Serialize.writeObject(orderItems));
			
			int affectedItem = ps.executeUpdate();

			if (affectedItem == 1) {
				ps.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.freeConn();
		}
		return false;
	}
	
}
