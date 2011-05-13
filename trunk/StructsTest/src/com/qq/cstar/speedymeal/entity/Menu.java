package com.qq.cstar.speedymeal.entity;

public class Menu {
	// �˵�����
	private int meid;// ��ʶ��
	private int mid;// �����̻�ID
	private String MenuItemName;// �˵���
	private double MenuItemPrice;// �۸�
	
	public Menu(int meid, int mid, String menuItemName, double menuItemPrice) {
		super();
		this.meid = meid;
		this.mid = mid;
		MenuItemName = menuItemName;
		MenuItemPrice = menuItemPrice;
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
		return MenuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		MenuItemName = menuItemName;
	}

	public double getMenuItemPrice() {
		return MenuItemPrice;
	}

	public void setMenuItemPrice(double menuItemPrice) {
		MenuItemPrice = menuItemPrice;
	}

	@Override
	public String toString() {
		return "Menu [MenuItemName=" + MenuItemName + ", MenuItemPrice="
				+ MenuItemPrice + ", meid=" + meid + ", mid=" + mid + "]";
	}
	
	
	

}
