package com.qq.cstar.speedymeal.entity;

public class Menu {
	// �˵�����
	private int meid;// ��ʶ��
	private int mid;// �����̻�ID
	private String menuItemName;// �˵���
	private double menuItemPrice;// �۸�
	
	public Menu(int meid, int mid, String menuItemName, double menuItemPrice) {
		super();
		this.meid = meid;
		this.mid = mid;
		this.menuItemName = menuItemName;
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

	@Override
	public String toString() {
		return "Menu [MenuItemName=" + menuItemName + ", MenuItemPrice="
				+ menuItemPrice + ", meid=" + meid + ", mid=" + mid + "]";
	}
	
	
	

}
