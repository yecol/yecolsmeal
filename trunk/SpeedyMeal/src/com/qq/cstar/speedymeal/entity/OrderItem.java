package com.qq.cstar.speedymeal.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
	// 订单项类
	private Menu menu;// 菜单项
	private int pieces;// 份数

	public OrderItem(Menu menu, int pieces) {
		super();
		this.menu = menu;
		this.pieces = pieces;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	public void addPieces() {
		this.pieces = this.pieces + 1;
	}

	public double getTotalCost() {
		return this.menu.getMenuItemPrice() * this.pieces;
	}

	@Override
	public String toString() {
		return "OrderItem [menu=" + menu + ", pieces=" + pieces + "]";
	}

}
