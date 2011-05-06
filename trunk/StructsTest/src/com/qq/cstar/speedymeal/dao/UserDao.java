package com.qq.cstar.speedymeal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.User;

public class UserDao {

	DbConnection dbc;

	public UserDao() {
		dbc = new DbConnection();
	}

	public boolean insertUser(User user) {
		return false;
	}

	public boolean updateUser(User user) {
		return false;
	}

	public boolean deleteUser(User user) {
		return false;
	}

	public User getUniqueUserByName(String username) {
		String sql = "select * from user where username=?";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPwd(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setCredit(rs.getInt(6));
				u.setStatus(rs.getInt(7));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<User> getUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "select * from user";
		Statement st;
		try {
			st = dbc.getConn().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setEmail(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setCredit(rs.getInt(6));
				u.setStatus(rs.getInt(7));
				// u.setLocation(rs.getInt(8));
				userList.add(u);
				System.out.println(u.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
