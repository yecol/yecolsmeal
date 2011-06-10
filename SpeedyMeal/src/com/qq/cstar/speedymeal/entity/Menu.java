package com.qq.cstar.speedymeal.entity;

import java.io.Serializable;

public class Menu implements Serializable{
	// �˵�����
	private int meid;// ��ʶ��
	private int mid;// �����̻�ID
	private String menuItemName;// �˵���
	private String menuPic;// �˵�ͼƬ·��
	private double menuItemPrice;// �۸�
	
	public Menu() {
		super();
	}

	public Menu(int meid, int mid, String menuItemName, String menuPic, double menuItemPrice) {
		super();
		this.meid = meid;
		this.mid = mid;
		this.menuItemName = menuItemName;
		this.menuPic = menuPic;
		this.menuItemPrice = menuItemPrice;
	}

	public int getMeid() {
		return meid;
	}

	public void setMeid(int meid) {
		this.meid = meid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public double getMenuItemPrice() {
		return menuItemPrice;
	}

	public void setMenuItemPrice(double menuItemPrice) {
		this.menuItemPrice = menuItemPrice;
	}

	public String getMenuPic() {
		return menuPic;
	}

	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}

	@Override
	public String toString() {
		return "Menu [meid=" + meid + ", menuItemName=" + menuItemName
				+ ", menuItemPrice=" + menuItemPrice + ", menuPic=" + menuPic
				+ ", mid=" + mid + "]";
	}



}
