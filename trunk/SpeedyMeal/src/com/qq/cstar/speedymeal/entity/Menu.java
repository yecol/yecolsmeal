package com.qq.cstar.speedymeal.entity;

public class Menu {
	// 菜单项类
	private int meid;// 标识符
	private int mid;// 所属商户ID
	private String menuItemName;// 菜单名
	private double menuItemPrice;// 价格
	
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
