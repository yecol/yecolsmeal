package com.qq.cstar.speedymeal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.Menu;
import com.qq.cstar.speedymeal.util.MD5;
import com.qq.cstar.speedymeal.util.Serialize;

public class MenuDao {

	DbConnection dbc;

	public MenuDao() {
		dbc = new DbConnection();
	}

	public ArrayList<Menu> getMenus(int mid) {
		String sql = "SELECT * FROM menu WHERE mid=?";
		ArrayList<Menu> menus = new ArrayList<Menu>();
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setMeid(rs.getInt("meid"));
				menu.setMenuItemName(rs.getString("menuItemName"));
				menu.setMenuItemPrice(rs.getDouble("menuItemPrice"));
				menu.setMenuPic(rs.getString("menuPic"));
				menu.setMid(mid);
				menus.add(menu);
			}
			dbc.freeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}

	public boolean insertMenu(Menu menu) {
		String sql = "INSERT INTO menu (mid,menuItemName,menuItemPrice,menuPic) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, menu.getMid());
			ps.setString(2, menu.getMenuItemName());
			ps.setDouble(3, menu.getMenuItemPrice());
			ps.setString(4, menu.getMenuPic());

			System.out.println(ps.toString());
			int affectedItem = ps.executeUpdate();
			
			if (affectedItem == 1) {
				dbc.freeConn();
				return true;
			}
			dbc.freeConn();						
		} catch (SQLException e) {
			dbc.freeConn();
			e.printStackTrace();
		} catch (Exception e) {
			dbc.freeConn();
			e.printStackTrace();
		}
		return false;
	}

	public boolean delMenu(int meid) {
		String sql = "DELETE FROM menu WHERE meid=?";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, meid);
			int affectedItem = ps.executeUpdate();
			dbc.freeConn();
			if (affectedItem == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
