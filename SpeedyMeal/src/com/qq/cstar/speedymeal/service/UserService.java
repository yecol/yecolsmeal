﻿package com.qq.cstar.speedymeal.service;

import java.util.ArrayList;

import com.qq.cstar.speedymeal.dao.MenuDao;
import com.qq.cstar.speedymeal.dao.OrderDao;
import com.qq.cstar.speedymeal.dao.UserDao;
import com.qq.cstar.speedymeal.entity.Menu;
import com.qq.cstar.speedymeal.entity.ShoppingCart;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.util.MD5;

public class UserService {
	
	private UserDao userDao=new UserDao();
	private MenuDao menuDao=new MenuDao();
	private OrderDao orderDao=new OrderDao();
	
	public User loginByUsername(String username,String pwd){
		//登录
		User user=userDao.getUniqueUserByName(username);
		if(user!=null&&user.getPwd().equals(MD5.getMD5(pwd))){
			user.setPwd(null);
			System.out.println("登录成功");
			return user;
			//当用户名和密码正确时登录成功，设空密码并返回对象
		}
		else {
			System.out.println("登录失败");
			//登录失败
			return null;
		}
		
	}
	
	public User registerUser(User user){
		User registeredUser=userDao.insertUser(user);
		if(registeredUser!=null){
			registeredUser.setPwd(null);
			return registeredUser;
			//当注册成功，设空密码并返回对象
		}
		else return null;
		//注册失败，返回空对象
	}
	
	//获得菜单
	public Menu getMenu(int meid) {
		Menu menu = menuDao.getMenu(meid);
		return menu;
	}

	public void addToOrder(ShoppingCart cart, User user) {
		// TODO Auto-generated method stub
		
		orderDao.addOrder(user.getUid(),cart.getBranch().getMid(),cart.getBranch().getBid(),cart.getOrderedItems());
	}
	


}
