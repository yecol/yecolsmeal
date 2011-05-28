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
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.Merchant;
import com.qq.cstar.speedymeal.service.MerchantService;

@Results( { @Result(name = "success", location = "/mcMgr.jsp"), @Result(name = "register", location = "/merRegister.jsp"),
		@Result(name = "login", location = "/merLogin.jsp") })
public class MerchantActs extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Merchant merchant;
	private Branch branch;
	private MerchantService merchantService = new MerchantService();
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String login() {
		// �̻���¼
		merchant = merchantService.loginByUsername(merchant.getUsername(), merchant.getPwd());
		if (merchant != null) {
			ActionContext.getContext().getSession().put("SpeedyMeal_Session_Merchant", merchant);
			return SUCCESS;
		} else {
			addActionError("�û������������!");
			return LOGIN;
		}
	}

	public String register() {
		// �̻�ע��
		merchant = merchantService.registerMerchant(merchant);
		if (merchant != null) {
			ActionContext.getContext().getSession().put("SpeedyMeal_Session_Merchant", merchant);
			return SUCCESS;
		} else {
			addActionError("ע��ʧ��");
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
		String[] vertexs = request.getParameter("vertexs").trim().split(",");
		ArrayList<Location> branchDeliveryArea = new ArrayList<Location>();
		for (int i = 0; i < vertexs.length; i += 2) {
			branchDeliveryArea.add(new Location(Double.parseDouble(vertexs[i]), Double.parseDouble(vertexs[i + 1])));
		}
		branch.setBranchDeliveryArea(branchDeliveryArea);

		if (merchantService.addNewBranch(branch) == true) {
			return "merchantMgr";
		} else {
			addActionError("����µķֵ귢������");
			return "addBranch";
		}

	}

	public String delBranch() {
		request = ServletActionContext.getRequest();
		int bid = Integer.parseInt(request.getParameter("bid").trim());
		boolean delSuccess = merchantService.delBranch(bid);
		if(delSuccess=false){
			addActionError("ɾ���ֵ���Ϣʧ�ܣ�");
		}
		//���¶�ȡ��ʾ�ֵ���Ϣ
		merchant = (Merchant) ActionContext.getContext().getSession().get("SpeedyMeal_Session_Merchant");
		ArrayList<Branch> branches = merchantService.getAllBranches(merchant.getMid());
		response = ServletActionContext.getResponse();
		//������ʾģ��
		DispBranches.display(response, branches);
		
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
}
