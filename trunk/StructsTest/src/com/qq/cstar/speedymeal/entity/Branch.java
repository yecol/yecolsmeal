package com.qq.cstar.speedymeal.entity;

import java.util.ArrayList;

public class Branch {
	// �ֵ���

	public static final int CIRCLE=0;
	public static final int POLYGON=1;
	
	// �־û�����
	private int bid;// �ֵ��ʶ��
	private int mid;// �̻�ID
	private String branchName;// �ֵ�����
	private String branchAddress;// �ֵ��ַ
	private String branchPhone;// �ֵ�绰
	private Location branchLocation;// �ֵ�����
	private int AreaType;//������������
	private ArrayList<Location> branchDeliveryArea;// ���ͷ�Χ

	// �ǳ־û�����
	private String companyName;

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getAreaType() {
		return AreaType;
	}

	public void setAreaType(int areaType) {
		AreaType = areaType;
	}

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", branchAddress=" + branchAddress + ", branchDeliveryArea=" + branchDeliveryArea + ", branchLocation="
				+ branchLocation + ", branchName=" + branchName + ", branchPhone=" + branchPhone + ", mid=" + mid + "]";
	}

}