package com.qq.cstar.speedymeal.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.display.DispBranches;
import com.qq.cstar.speedymeal.display.DispMenus;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Menu;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.service.MerchantService;

public class MerchantMgr extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private MerchantService merchantService = new MerchantService();
	private HttpServletResponse response;
	private Merchant merchant;

	// 获得可用的分店商铺信息列表
	public String listBranches() {
		merchant = (Merchant) ActionContext.getContext().getSession().get("SpeedyMeal_Session_Merchant");
		ArrayList<Branch> branches = merchantService.getAllBranches(merchant.getMid());
		response = ServletActionContext.getResponse();
		// 调用显示模块
		DispBranches.display(response, branches);
		return null;
	}

	// 获得菜单列表
	public String listMenus() {
		merchant = (Merchant) ActionContext.getContext().getSession().get("SpeedyMeal_Session_Merchant");
		ArrayList<Menu> menus = merchantService.getMenus(merchant.getMid());
		response = ServletActionContext.getResponse();
		// 调用显示模块
		DispMenus.display(response, menus,merchant.getMid());
		return null;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Merchant getMerchant() {
		return this.merchant;
	}
}
