package com.qq.cstar.speedymeal.entity;

import java.util.ArrayList;

public class Order {
	//订单类
	private int oid;
	private int uid;//用户外键
	private int mid;//商户外键
	private int status;//商户外键
	private ArrayList<OrderItem> orderItems;

}
