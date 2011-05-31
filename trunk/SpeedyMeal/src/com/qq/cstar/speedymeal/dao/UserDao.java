package com.qq.cstar.speedymeal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qq.cstar.speedymeal.util.MD5;
import com.qq.cstar.speedymeal.util.Serialize;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.User;

public class UserDao {

	DbConnection dbc;

	public UserDao() {
		dbc = new DbConnection();
	}

	public User insertUser(User user) {
		String sql = "INSERT INTO user (username,pwd,email,phone,credit,status,location,address) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, MD5.getMD5(user.getPwd()));
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setInt(5, user.getCredit());
			ps.setInt(6, user.getStatus());
			ps.setString(7, Serialize.writeObject(user.getLocation()));
			ps.setString(8, user.getAddress());

			System.out.println(ps.toString());
			int affectedItem = ps.executeUpdate();
			ps.close();
			if (affectedItem == 1) {
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.freeConn();
		}
		return null;
	}

	public User updateUser(User user) {
		String sql = "UPDATE user SET username=?,pwd=?,email=?,phone=?,credit=?,status=?,location=?,address=? WHERE uid=?";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, MD5.getMD5(user.getPwd()));
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setInt(5, user.getCredit());
			ps.setInt(6, user.getStatus());
			ps.setString(7, Serialize.writeObject(user.getLocation()));
			ps.setString(8, user.getAddress());
			ps.setInt(9, user.getUid());
			int affectedItem = ps.executeUpdate();
			ps.close();
			if (affectedItem == 1) {
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.freeConn();
		}
		return null;
	}

	public boolean deleteUser(User user) {
		return false;
	}

	public User getUniqueUserByName(String username) {
		String sql = "SELECT * FROM user WHERE username=?";
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
				u.setLocation((Location) Serialize.readObject(rs.getString(8)));
				u.setAddress(rs.getString(9));
				ps.close();
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.freeConn();
		}
		return null;
	}

	public ArrayList<User> getUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM user";
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
				u.setLocation((Location) Serialize.readObject(rs.getString(8)));
				u.setAddress(rs.getString(9));
				userList.add(u);
				System.out.println(u.toString());
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.freeConn();
		}
		return userList;
	}

}
