package com.qq.cstar.speedymeal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qq.cstar.speedymeal.entity.Branch;
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
				m.setCredits(rs.getInt(9));
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

		String sql = "INSERT INTO merchant (username,pwd,email,phone,address,companyName,status,credits) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setString(1, merchant.getUsername());
			ps.setString(2, MD5.getMD5(merchant.getPwd()));
			ps.setString(3, merchant.getEmail());
			ps.setString(4, merchant.getPhone());
			ps.setString(5, merchant.getAddress());
			ps.setString(6, merchant.getCompanyName());
			ps.setInt(7, merchant.getStatus());
			ps.setInt(8, merchant.getCredits());

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

	public Merchant getMerchantByMid(int mid) {

		String sql4Merchant = "SELECT * FROM merchant WHERE mid=?";
		String sql4Branch = "SELECT * FROM branch WHERE mid=?";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql4Merchant);
			ps.setInt(1, mid);
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
				m.setCredits(rs.getInt(9));

				ArrayList<Branch> branches = new ArrayList<Branch>();
				PreparedStatement ps4Branch = dbc.getConn().prepareStatement(sql4Branch);
				ps4Branch.setInt(1, mid);
				ResultSet rs4Branch = ps4Branch.executeQuery();

				if (rs4Branch.next()) {
					Branch b = new Branch();
					b.setBid(rs4Branch.getInt("bid"));
					b.setMid(rs4Branch.getInt("mid"));
					b.setBranchName(rs4Branch.getString("branchName"));
					b.setBranchAddress(rs4Branch.getString("branchAddress"));
					b.setBranchPhone(rs4Branch.getString("branchPhone"));
					b.setBranchLocation((Location) Serialize.readObject((rs4Branch.getString("branchLocation"))));
					b.setBranchDeliveryArea((ArrayList<Location>) Serialize.readObject((rs4Branch.getString("branchDeliveryArea"))));
					branches.add(b);
				}

				rs4Branch.close();
				m.setBranches(branches);
				return m;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean InsertBranch(Branch branch) {

		String sql = "INSERT INTO branch (mid,branchName,branchAddress,branchPhone,branchLocation,branchDeliveryArea,areaType) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, branch.getMid());
			ps.setString(2, branch.getBranchName());
			ps.setString(3, branch.getBranchAddress());
			ps.setString(4, branch.getBranchPhone());
			ps.setString(5, Serialize.writeObject(branch.getBranchLocation()));
			ps.setString(6, Serialize.writeObject(branch.getBranchDeliveryArea()));
			ps.setInt(7, branch.getAreaType());

			int affectedItem = ps.executeUpdate();
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

	public ArrayList<Branch> getAllBranches() {
		String sql = "SELECT M.companyName,B.* FROM merchant M,branch B where M.mid=B.mid";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			return FilledFromResultset(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Branch> getBranchesByMid(int mid) {
		
		String sql = "SELECT M.companyName,B.* FROM merchant M,branch B where M.mid=B.mid AND B.mid=?";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			return FilledFromResultset(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private ArrayList<Branch> FilledFromResultset(ResultSet rs) throws SQLException, Exception{
		ArrayList<Branch> branches = new ArrayList<Branch>();
		
		while(rs.next()) {
			Branch b = new Branch();
			b.setBid(rs.getInt("bid"));
			b.setBranchAddress(rs.getString("branchAddress"));
			b.setBranchDeliveryArea((ArrayList<Location>) Serialize.readObject(rs.getString("branchDeliveryArea")));
			b.setBranchLocation((Location) Serialize.readObject(rs.getString("branchLocation")));
			b.setBranchName(rs.getString("branchName"));
			b.setBranchPhone(rs.getString("branchPhone"));
			b.setMid(rs.getInt("mid"));
			b.setCompanyName(rs.getString("companyName"));
			branches.add(b);
		}
		rs.close();
		return branches;
	}

	public boolean delBranch(int bid) {
		String sql = "DELETE FROM branch WHERE bid=?";
		try {
			PreparedStatement ps = dbc.getConn().prepareStatement(sql);
			ps.setInt(1, bid);

			int affectedItem = ps.executeUpdate();
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
