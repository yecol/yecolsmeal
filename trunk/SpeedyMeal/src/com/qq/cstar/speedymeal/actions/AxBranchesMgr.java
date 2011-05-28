package com.qq.cstar.speedymeal.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.display.DispBranches;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.service.MerchantService;

public class AxBranchesMgr extends ActionSupport {
	// 获得可用的商铺信息列表

	private static final long serialVersionUID = 1L;
	private MerchantService merchantService = new MerchantService();
	private HttpServletResponse response;
	private Merchant merchant;

	public String listBranches() {
		merchant = (Merchant) ActionContext.getContext().getSession().get("SpeedyMeal_Session_Merchant");

		ArrayList<Branch> branches = merchantService.getAllBranches(merchant.getMid());
		response = ServletActionContext.getResponse();
		//调用显示模块
		DispBranches.display(response, branches);
		
		return null;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Merchant getMerchant() {
		return this.merchant;
	}
}
