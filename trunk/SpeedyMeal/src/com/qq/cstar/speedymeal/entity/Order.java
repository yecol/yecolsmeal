package com.qq.cstar.speedymeal.entity;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	// 订单类
	private int oid;
	private int uid;// 用户外键
	private int mid;// 商户外键
	private int status;
	private Date orderTime;
	private ArrayList<OrderItem> orderItems;//包含的菜单项

	public Order(int oid, int uid, int mid, int status, Date orderTime,
			ArrayList<OrderItem> orderItems) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.mid = mid;
		this.status = status;
		this.orderTime = orderTime;
		this.orderItems = orderItems;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [mid=" + mid + ", oid=" + oid + ", orderItems="
				+ orderItems + ", orderTime=" + orderTime + ", status="
				+ status + ", uid=" + uid + "]";
	}

	
}
