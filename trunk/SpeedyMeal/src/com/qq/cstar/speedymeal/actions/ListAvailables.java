package com.qq.cstar.speedymeal.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.service.ProcessService;

@Results( { @Result(name = "success", location = "/list.jsp") })
public class ListAvailables extends ActionSupport {
	// 获得可用的商铺信息列表

	private static final long serialVersionUID = 1L;
	private ArrayList<Branch> availableBranches;
	private ProcessService processService = new ProcessService();
	private HttpServletRequest request;
	private User user;
	private Location location;

	public String loginedList() {
		// 已登录用户的可达外卖信息搜索
		user = (User) ActionContext.getContext().getSession().get("SpeedyMeal_Session_User");
		availableBranches = processService.getAvailableBranches(user.getLocation());
		location = user.getLocation();
		return SUCCESS;
	}

	public String unLoginList() {
		// 未登录用户的可达外卖信息搜索
		request = ServletActionContext.getRequest();
		double latitude = Double.parseDouble(request.getParameter("l_lat").trim());
		double longitude = Double.parseDouble(request.getParameter("l_lon").trim());

		availableBranches = processService.getAvailableBranches(new Location(latitude, longitude));
		location = new Location(latitude, longitude);
		return SUCCESS;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ArrayList<Branch> getAvailableBranches() {
		return availableBranches;
	}

	public void setAvailableBranches(ArrayList<Branch> availableBranches) {
		this.availableBranches = availableBranches;
	}
}
