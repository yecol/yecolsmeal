package com.qq.cstar.speedymeal.actions;

import com.opensymphony.xwork2.ActionSupport;

public class UserRedirect extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String manage() {
		return "managePage";
	}
	
	public String order(){
		return "orderPage";
	}
}
