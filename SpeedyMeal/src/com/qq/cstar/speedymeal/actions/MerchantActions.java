package com.qq.cstar.speedymeal.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.display.DispBranches;
import com.qq.cstar.speedymeal.display.DispMenus;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.Menu;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.service.MerchantService;


public class MerchantActions extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Merchant merchant;
	private Branch branch;
	private Menu menu;
	private MerchantService merchantService = new MerchantService();
	private HttpServletRequest request;
	private HttpServletResponse response;
	public ArrayList<Branch> branches;

	public String login() {
		if (merchant == null) {
			System.out.println("debug info: merchant == null");
			return null;
		}

		// 商户登录
		merchant = merchantService.loginByUsername(merchant.getUsername(),
				merchant.getPwd());
		if (merchant != null) {
			ActionContext.getContext().getSession().put(
					"SpeedyMeal_Session_Merchant", merchant);
			branches = merchantService.getAllBranches(merchant.getMid());
			return SUCCESS;
		} else {
			addActionError("用户名或密码错误!");
			return LOGIN;
		}
	}

	public String logout() {
		ActionContext.getContext().getSession().put(
				"SpeedyMeal_Session_Merchant", null);
		return "index";
	}

	public String mgr() {
		// 商户登录后回到管理页面
		merchant = (Merchant) ActionContext.getContext().getSession().get(
				"SpeedyMeal_Session_Merchant");
		branches = merchantService.getAllBranches(merchant.getMid());
		return SUCCESS;
	}

	public String register() {
		// 商户注册
		merchant = merchantService.registerMerchant(merchant);
		if (merchant != null) {
			ActionContext.getContext().getSession().put(
					"SpeedyMeal_Session_Merchant", merchant);
			return SUCCESS;
		} else {
			addActionError("注册失败");
			return "register";
		}
	}

	public String addBranch() {
		Merchant merchant = (Merchant) ActionContext.getContext().getSession()
				.get("SpeedyMeal_Session_Merchant");
		HttpServletRequest request = ServletActionContext.getRequest();
		if (request == null) {
			System.out.println("Debug info: request == null");
			return null;
		}
		branch = new Branch();
		branch.setBranchName(request.getParameter("branchName").trim());
		branch.setBranchAddress(request.getParameter("branchAddress").trim());
		branch.setBranchPhone(request.getParameter("branchPhone").trim());
		branch.setBranchLocation(new Location(Double.parseDouble(request
				.getParameter("bla").trim()), Double.parseDouble(request
				.getParameter("blo").trim())));
		branch.setMid(merchant.getMid());
		branch.setAreaType(Integer.parseInt(request.getParameter("areaType")
				.trim()));
		String[] vertexs = request.getParameter("vertexs").trim().split(",");
		ArrayList<Location> branchDeliveryArea = new ArrayList<Location>();
		for (int i = 0; i < vertexs.length; i += 2) {
			branchDeliveryArea.add(new Location(Double.parseDouble(vertexs[i]),
					Double.parseDouble(vertexs[i + 1])));
		}
		branch.setBranchDeliveryArea(branchDeliveryArea);

		if (merchantService.addNewBranch(branch) == true) {
			branches = merchantService.getAllBranches(merchant.getMid());
			// DispBranches.display(response, branches);
			return SUCCESS;
		} else {
			addActionError("添加新的分店发生错误");
			return "addBranch";
		}

	}

	public String addMenu() {
		if (menu == null) {
			System.out.println("Debug info: menu == null");
			return null;
		}
		Merchant merchant = (Merchant) ActionContext.getContext().getSession()
				.get("SpeedyMeal_Session_Merchant");
		ArrayList<Menu> menus;
		if (merchantService.addNewMenu(menu) == true) {
			menus = merchantService.getMenus(merchant.getMid());
			response = ServletActionContext.getResponse();
			DispMenus.display(response, menus, merchant.getMid());
			return SUCCESS;
		} else {
			addActionError("添加新的菜单发生错误");
			return null;
		}

	}
	
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

	public String delBranch() {
		request = ServletActionContext.getRequest();
		if (request == null) {
			System.out.println("Debug info: request == null");
			return null;
		}
		int bid = Integer.parseInt(request.getParameter("bid").trim());
		boolean delSuccess = merchantService.delBranch(bid);
		if (delSuccess = false) {
			addActionError("删除分店信息失败！");
		}
		// 重新读取显示分店信息
		merchant = (Merchant) ActionContext.getContext().getSession().get(
				"SpeedyMeal_Session_Merchant");
		ArrayList<Branch> branches = merchantService.getAllBranches(merchant
				.getMid());
		response = ServletActionContext.getResponse();
		// 调用显示模块
		DispBranches.display(response, branches);

		return null;
	}

	public String delMenu() {
		request = ServletActionContext.getRequest();
		int meid = Integer.parseInt(request.getParameter("meid").trim());
		boolean delSuccess = merchantService.delMenu(meid);
		if (delSuccess = false) {
			addActionError("删除菜单信息失败！");
		}
		// 重新读取显示分店信息
		merchant = (Merchant) ActionContext.getContext().getSession().get(
				"SpeedyMeal_Session_Merchant");
		ArrayList<Menu> menus = merchantService.getMenus(merchant.getMid());
		response = ServletActionContext.getResponse();
		// 调用显示模块
		DispMenus.display(response, menus, merchant.getMid());
		return null;
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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public ArrayList<Branch> getBranches() {
		return branches;
	}

	public void setBranches(ArrayList<Branch> branches) {
		this.branches = branches;
	}
}
