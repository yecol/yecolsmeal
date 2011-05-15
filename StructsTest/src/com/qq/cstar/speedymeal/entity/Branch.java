package com.qq.cstar.speedymeal.entity;

import java.util.ArrayList;

public class Branch {
	// 分店类

	private int bid;// 分店标识符
	private int mid;// 商户ID
	private String branchName;// 分店名称
	private String branchAddress;// 分店地址
	private String branchPhone;// 分店电话
	private Location branchLocation;// 分店坐标
	private ArrayList<Location> branchDeliveryArea;// 外送范围

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getBranchPhone() {
		return branchPhone;
	}

	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	public Location getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(Location branchLocation) {
		this.branchLocation = branchLocation;
	}

	public ArrayList<Location> getBranchDeliveryArea() {
		return branchDeliveryArea;
	}

	public void setBranchDeliveryArea(ArrayList<Location> branchDeliveryArea) {
		this.branchDeliveryArea = branchDeliveryArea;
	}

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", branchAddress=" + branchAddress + ", branchDeliveryArea=" + branchDeliveryArea + ", branchLocation="
				+ branchLocation + ", branchName=" + branchName + ", branchPhone=" + branchPhone + ", mid=" + mid + "]";
	}

}
