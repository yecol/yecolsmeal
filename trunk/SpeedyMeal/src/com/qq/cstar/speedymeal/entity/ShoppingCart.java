package com.qq.cstar.speedymeal.entity;

import java.util.ArrayList;

public class ShoppingCart {
	private Branch branch;


	private ArrayList<OrderItem> itemsOrdered;

	public ShoppingCart() {
		itemsOrdered = new ArrayList();
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			totalPrice += itemsOrdered.get(i).getTotalCost();
		}
		return totalPrice;
	}

	public int getTotalLength() {
		int totalLength = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			totalLength += itemsOrdered.get(i).getPieces();
		}
		return totalLength;
	}

	public synchronized void addItem(Menu menu) {
		boolean flag=true;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getMenu().getMeid() == menu.getMeid()) {
				itemsOrdered.get(i).addPieces();
				flag=false;
			}
		}
		if(flag){
			itemsOrdered.add(new OrderItem(menu, 1));
		}
		return;
	}

	public synchronized void updateItem(int meid, int num) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getMenu().getMeid() == meid) {
				if (num == 0)
					itemsOrdered.remove(i);
				else
					itemsOrdered.get(i).setPieces(num);
				return;
			}
		}

	}
	
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}	

	public ArrayList<OrderItem> getOrderedItems() {
		return this.itemsOrdered;
	}

	@Override
	public String toString() {
		return "ShoppingCart [itemsOrdered=" + itemsOrdered + "]";
	}

}
