package com.qq.cstar.speedymeal.entity;

public class User {
	// �û���

	private int uid;// �û���ʶ��
	private String username;
	private String pwd;
	private String email;
	private String phone;
	private int credit;
	private int status;// �ʻ�״̬
	private Location location;// Ĭ�������ַ
	private String address;// ��ַ
	

	public User() {
		super();
	}

	public User(int uid, String username, String pwd, String email,
			String phone, int credit, int status, Location location,
			String address) {
		super();
		this.uid = uid;
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.credit = credit;
		this.status = status;
		this.location = location;
		this.address = address;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [address=" + address + ", credit=" + credit + ", email="
				+ email + ", location=" + location + ", phone=" + phone
				+ ", pwd=" + pwd + ", status=" + status + ", uid=" + uid
				+ ", username=" + username + "]";
	}

}
