package com.qq.cstar.speedymeal.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.service.UserService;

@Results( { @Result(name = "success", location = "/usMgr.jsp"),
		@Result(name = "login", location = "/login.jsp"),
		@Result(name = "register", location = "/register.jsp"),
		@Result(name = "index", location = "/index.jsp") })
public class UserActs extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private UserService userService = new UserService();
	private HttpServletRequest request;

	public String login() {
		if (user == null) {
			System.out.println("debug info: user == null");
			return null;
		}
		// 用户登录
		user = userService.loginByUsername(user.getUsername(), user.getPwd());
		if (user != null) {

			ActionContext.getContext().getSession().put(
					"SpeedyMeal_Session_User", user);
			System.out.println("return SUCCESS!");
			return SUCCESS;
		} else {
			addActionError("用户名或密码错误");
			return LOGIN;
		}

	}

	public String logout() {
		ActionContext.getContext().getSession().put("SpeedyMeal_Session_User",
				null);
		return "index";
	}

	public String register() {
		if (request == null) {
			System.out.println("Debug info: request == null");
			return null;
		}
		// 用户注册
		request = ServletActionContext.getRequest();
		double latitude = Double.parseDouble(request.getParameter("r_lat")
				.trim());
		double longitude = Double.parseDouble(request.getParameter("r_lon")
				.trim());

		user.setLocation(new Location(latitude, longitude));
		user = userService.registerUser(user);
		if (user != null) {
			ActionContext.getContext().getSession().put(
					"SpeedyMeal_Session_User", user);
			return SUCCESS;
		} else {
			addActionError("注册失败！请重新注册!");
			return "register";
		}
	}

	public String update() {
		// 用户更新资料
		return null;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

}
