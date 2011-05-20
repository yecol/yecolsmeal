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
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.service.MerchantService;

@Results( { @Result(name = "success", location = "/WEB-INF/content/merchantMgr.jsp"), @Result(name = "register", location = "/merchantRegister.jsp"),
		@Result(name = "login", location = "/merchantLogin.jsp"), @Result(name = "merchantMgr", location = "/WEB-INF/content/merchantMgr.jsp") })
public class MerchantActs extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Merchant merchant;
	private Branch branch;
	private MerchantService merchantService = new MerchantService();

	public String login() {
		// 商户登录
		merchant = merchantService.loginByUsername(merchant.getUsername(), merchant.getPwd());
		if (merchant != null) {
			ActionContext.getContext().getSession().put("SpeedyMeal_Session_Merchant", merchant);
			return SUCCESS;
		} else {
			addActionError("用户名或密码错误");
			return LOGIN;
		}
	}

	public String register() {
		// 商户注册
		merchant = merchantService.registerMerchant(merchant);
		if (merchant != null) {
			ActionContext.getContext().getSession().put("SpeedyMeal_Session_Merchant", merchant);
			return SUCCESS;
		} else {
			addActionError("注册失败");
			return "register";
		}
	}

	public String addBranch() {
		Merchant merchant = (Merchant) ActionContext.getContext().getSession().get("SpeedyMeal_Session_Merchant");
		HttpServletRequest request = ServletActionContext.getRequest();
		branch = new Branch();
		branch.setBranchName(request.getParameter("branchName").trim());
		branch.setBranchAddress(request.getParameter("branchAddress").trim());
		branch.setBranchPhone(request.getParameter("branchPhone").trim());
		branch.setBranchLocation(new Location(Double.parseDouble(request.getParameter("bla").trim()), Double.parseDouble(request.getParameter("blo")
				.trim())));
		branch.setMid(merchant.getMid());
		branch.setAreaType(Integer.parseInt(request.getParameter("areaType").trim()));
		String[] alas = request.getParameterValues("alas");
		String[] alos = request.getParameterValues("alos");
		ArrayList<Location> branchDeliveryArea = new ArrayList<Location>();
		for (int i = 0; i < alas.length; i++) {
			branchDeliveryArea.add(new Location(Double.parseDouble(alas[i]), Double.parseDouble(alos[i])));
		}
		branch.setBranchDeliveryArea(branchDeliveryArea);

		if (merchantService.addNewBranch(branch) == true) {
			return "merchantMgr";
		} else {
			addActionError("添加新的分店发生错误");
			return "addBranch";
		}

	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Branch getBranch() {
		return this.branch;
	}
}
