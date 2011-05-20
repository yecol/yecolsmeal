package com.qq.cstar.speedymeal.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.service.ProcessService;

public class BranchesManage extends ActionSupport {
	// 获得可用的商铺信息列表

	private static final long serialVersionUID = 1L;
	private ArrayList<Branch> availableBranches;
	private ProcessService processService = new ProcessService();
	private HttpServletResponse response;
	private Merchant merchant;

	public String execute() {
		merchant=(Merchant)ActionContext.getContext().getSession().get("SpeedyMeal_Session_Merchant");
		ArrayList<Branch> branches=processService.getAllBranches(merchant.getMid());
		
		response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		out.print(branches.toString());		
		return null;
	}

	public void setUser(Merchant merchant) {
		this.merchant = merchant;
	}

	public Merchant getMerchant() {
		return this.merchant;
	}
}
