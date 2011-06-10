package com.qq.cstar.speedymeal.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.service.ProcessService;

public class SearchActions extends ActionSupport {
	// 获得可用的商铺信息列表

	private static final long serialVersionUID = 1L;
	private ArrayList<Branch> availableBranches;
	private ProcessService processService = new ProcessService();
	private HttpServletRequest request;
	private User user;
	private Location location;
	private Branch branch;

	public String loginedList() {
		// 已登录用户的可达外卖信息搜索
		user = (User) ActionContext.getContext().getSession().get(
				"SpeedyMeal_Session_User");
		availableBranches = processService.getAvailableBranches(user
				.getLocation());
		location = user.getLocation();
		return SUCCESS;
	}

	public String unLoginList() {
		// 未登录用户的可达外卖信息搜索
		request = ServletActionContext.getRequest();
		double latitude = Double.parseDouble(request.getParameter("l_lat")
				.trim());
		double longitude = Double.parseDouble(request.getParameter("l_lon")
				.trim());

		availableBranches = processService.getAvailableBranches(new Location(
				latitude, longitude));
		location = new Location(latitude, longitude);
		return SUCCESS;
	}

	public String singleList() {
		request = ServletActionContext.getRequest();
		String branchIdString = request.getParameter("bid");
		int bid = Integer.parseInt(branchIdString.trim());
		branch = processService.getBranch(bid);
		return "singlelist";
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
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
