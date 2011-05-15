package com.qq.cstar.speedymeal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.util.MD5;
import com.qq.cstar.speedymeal.util.Serialize;

public class MerchantDao {

	
	DbConnection dbc;

	public MerchantDao() {
		dbc = new DbConnection();
	}

	public Merchant getUniqueUserByName(String username) {
		
		String sql = "SELECT * FROM merchant WHERE username=?";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Merchant m = new Merchant();
				m.setMid(rs.getInt(1));
				m.setUsername(rs.getString(2));
				m.setPwd(rs.getString(3));
				m.setEmail(rs.getString(4));
				m.setPhone(rs.getString(5));
				m.setAddress(rs.getString(6));
				m.setCompanyName(rs.getString(7));
				m.setStatus(rs.getInt(8));
				m.setLocation((Location) Serialize.readObject(rs.getString(9)));
				m.setDeliveryArea((ArrayList<Location>) Serialize.readObject(rs.getString(10)));
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}


	public Merchant insertMerchant(Merchant merchant) {
		
		String sql = "INSERT INTO merchant (username,pwd,email,phone,address,companyName,status,location,deliveryArea) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setString(1, merchant.getUsername());
			ps.setString(2, MD5.getMD5(merchant.getPwd()));
			ps.setString(3, merchant.getEmail());
			ps.setString(4, merchant.getPhone());
			ps.setString(5, merchant.getAddress());
			ps.setString(6, merchant.getCompanyName());
			ps.setInt(7, merchant.getStatus());
			ps.setString(8, Serialize.writeObject(merchant.getLocation()));
			ps.setString(9, Serialize.writeObject(merchant.getDeliveryArea()));

			int affectedItem = ps.executeUpdate();
			if (affectedItem == 1) {
				return merchant;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
