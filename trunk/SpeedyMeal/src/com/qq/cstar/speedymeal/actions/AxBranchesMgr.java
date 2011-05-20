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
import com.qq.cstar.speedymeal.service.MerchantService;
import com.qq.cstar.speedymeal.service.ProcessService;

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
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print("<table class='sidebar_mgr_table'>");
		if(branches.size()==0){
			out.print("<tr>暂无店铺信息</tr>");
		}
		for (int index = 0; index < branches.size(); index++) {
			out.print("<tr>");
			out.print("<td>" + (index + 1) + "<td>");
			out.print("<td>" + branches.get(index).getBranchName() + "<td>");
			out.print("<td>" + branches.get(index).getBranchAddress() + "<td>");
			out.print("<div class='hidden'>" + "<div class='i_lat'>" + branches.get(index).getBranchLocation().getLatitude() + "</div>"
					+ "<div class='i_lon'>" + branches.get(index).getBranchLocation().getLongitude() + "</div>" + "</div>");
			out.print("<td><a href='#' class='mgr_button'>更新</a> <a href='#' class='mgr_button'>删除</a><td>");
		}
		out.print("</table>");
		out.print("<a href='/SpeedyMeal/mcAddBranch.jsp'>添加新的分店</a>");
		return null;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Merchant getMerchant() {
		return this.merchant;
	}
}
