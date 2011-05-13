package com.qq.cstar.speedymeal.actions;


import com.opensymphony.xwork2.ActionContext;
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

	public String login() {
		// 用户登录
		user = userService.loginByUsername(user.getUsername(), user.getPwd());
		if (user != null) {
			// HttpSession session=(HttpSession) request.getSession();
			// s.setAttribute(arg0, arg1)
			return SUCCESS;
		} else {
			return LOGIN;
		}

	}

	public String register() {
		// 用户注册
		System.out.println("before register:" + user.getAddress());
		user = userService.registerUser(user);
		if (user != null) {
			return "register-success";
		} else {
			addActionError("用户名已存在,请重新选择用户名!");
			return LOGIN;
		}
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

}
