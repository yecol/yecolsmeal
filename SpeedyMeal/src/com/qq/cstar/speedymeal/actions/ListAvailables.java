package com.qq.cstar.speedymeal.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.service.ProcessService;

@Results( { @Result(name = "success", location = "/list.jsp")})
public class ListAvailables extends ActionSupport {
	// 获得可用的商铺信息列表

	private static final long serialVersionUID = 1L;
	private ArrayList<Branch> availableBranches;
	private ProcessService processService = new ProcessService();
	private HttpServletRequest request;
	private HttpServletResponse response;
	private User user;

	public String loginedList() {
		user = (User) ActionContext.getContext().getSession().get("SpeedyMeal_Session_User");
		availableBranches = processService.getAvailableBranches(user.getLocation());		
		return SUCCESS;
	}


	public String unLoginList() {
		request = ServletActionContext.getRequest();
		double latitude=Double.parseDouble(request.getParameter("l_lat").trim());
		double longitude=Double.parseDouble(request.getParameter("l_lon").trim());
		
		availableBranches = processService.getAvailableBranches(new Location(latitude, longitude));
		response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		out.print(availableBranches.toString());		
		return null;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}
	

	public ArrayList<Branch> getAvailableBranches() {
		return availableBranches;
	}


	public void setAvailableBranches(ArrayList<Branch> availableBranches) {
		this.availableBranches = availableBranches;
	}
}
