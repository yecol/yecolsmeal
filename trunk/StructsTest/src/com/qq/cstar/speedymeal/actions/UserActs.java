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
		//用户登录
		if(userService.loginByUsername(user.getUsername(), user.getPwd())!=null){
			return SUCCESS;
		}
		else {
			return LOGIN;
		}
			
	}
	
	public String register(){
		//用户注册
		//TODO
		return null;
	}
	
	public void setUser(User user){
		this.user=user;
	}
	
	public User getUser(){
		return this.user;
	}

}
