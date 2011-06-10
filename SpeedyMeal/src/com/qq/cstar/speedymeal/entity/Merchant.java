package com.qq.cstar.speedymeal.entity;

import java.util.ArrayList;

public class Merchant {
	// �̻���
	private int mid;// �̻���ʶ��
	private String username;// �û���
	private String pwd;// ����
	private String email;
	private String phone;
	private String address;
	private String companyName;// ��˾����
	private int status;// �ʻ�״̬
	private int credits;// ���û���
	private ArrayList<Branch> branches;
	private String pic;

	public Merchant() {
		super();
	}

	public Merchant(int mid, String username, String pwd, String email,
			String phone, String address, String companyName, int status,
			int credits, ArrayList<Branch> branches, String pic) {
		super();
		this.mid = mid;
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.companyName = companyName;
		this.status = status;
		this.credits = credits;
		this.branches = branches;
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public ArrayList<Branch> getBranches() {
		return branches;
	}

	public void setBranches(ArrayList<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Merchant [address=" + address + ", branches=" + branches + ", companyName=" + companyName + ", credits=" + credits + ", email="
				+ email + ", mid=" + mid + ", phone=" + phone + ", pwd=" + pwd + ", status=" + status + ", username=" + username + "]";
	}

}
