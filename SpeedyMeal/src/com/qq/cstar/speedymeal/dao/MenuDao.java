package com.qq.cstar.speedymeal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.Menu;

public class MenuDao {

	DbConnection dbc;

	public MenuDao() {
		dbc = new DbConnection();
	}

	public ArrayList<Menu> getMenusByMid(int mid) {
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
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.freeConn();
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

	public boolean delMenu(int meid) {
		String sql = "DELETE FROM menu WHERE meid=?";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, meid);
			int affectedItem = ps.executeUpdate();
			if (affectedItem == 1) {
				ps.close();
				return true;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.freeConn();
		}
		return false;

	}

	public Menu getMenu(int meid) {
		String sql = "SELECT * FROM menu WHERE meid=?";
		Menu menu = new Menu();
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, meid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				menu.setMeid(rs.getInt("meid"));
				menu.setMenuItemName(rs.getString("menuItemName"));
				menu.setMenuItemPrice(rs.getDouble("menuItemPrice"));
				menu.setMenuPic(rs.getString("menuPic"));
				menu.setMid(rs.getInt("mid"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.freeConn();
		}
		return menu;
	}

}
