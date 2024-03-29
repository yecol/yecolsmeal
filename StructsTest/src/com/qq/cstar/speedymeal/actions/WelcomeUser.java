package com.qq.cstar.speedymeal.actions;


import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.dao.UserDao;

public class WelcomeUser extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String message;	

	public String execute() {
		message = "Welcome " + userName;
		return SUCCESS;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public String getMessage() {
		return message;
	}

}
