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
	private Location location;// �̻�����
	private ArrayList<Location> deliveryArea;// Ͷ����������
	
	

	public Merchant() {
		super();
	}

	public Merchant(int mid, String username, String pwd, String email,
			String phone, String address, String companyName, int status,
			Location location, ArrayList<Location> deliveryArea) {
		super();
		this.mid = mid;
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.companyName = companyName;
		this.status = status;
		this.location = location;
		this.deliveryArea = deliveryArea;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ArrayList<Location> getDeliveryArea() {
		return deliveryArea;
	}

	public void setDeliveryArea(ArrayList<Location> deliveryArea) {
		this.deliveryArea = deliveryArea;
	}

	@Override
	public String toString() {
		return "Merchant [address=" + address + ", companyName=" + companyName
				+ ", deliveryArea=" + deliveryArea + ", email=" + email
				+ ", location=" + location + ", mid=" + mid + ", phone="
				+ phone + ", pwd=" + pwd + ", status=" + status + ", username="
				+ username + "]";
	}

}
