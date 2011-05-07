package com.qq.cstar.speedymeal.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.service.UserService;

public class UserActs extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	private User user;
	private UserService userService = new UserService();

	
	public String login(){
		System.out.println("login");
		System.out.println(user.username+user.pwd);
		if(userService.loginByUsername(user.username, user.pwd)!=null){
			System.out.println("login success");
			return SUCCESS;
		}
		else {
			System.out.println("login failed");
			return LOGIN;
		}
			
	}
	
	public void setUser(User user){
		this.user=user;
	}
	
	public User getUser(){
		return this.user;
	}

}
