package com.qq.cstar.speedymeal.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.Branch;

public class DispBranches {

	public static void display(HttpServletResponse response,ArrayList<Branch> branches){
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out
				.print("<div class='gTitle'> 分店管理 </div><div id='branchList' class='sidebar_block'><p> <a href='mcAddBranch.jsp' class='n'>添加</a>新的分店。或者<a href='merchant-acts!mgr' class='n'>返回</a>管理页。 </p>");
		if (branches.size() != 0) {
			System.out.println("size="+branches.size());
			for (int index = 0; index < branches.size(); index++) {
				out.print("<div class='list_single'><div class='ls_head'>");
				out.print("<div class='ls_h_mer' >" + (index + 1) + ". " + branches.get(index).getBranchName() + "</div>");
				out.print("<div class='ls_h_bra'>" + branches.get(index).getBranchPhone() + "</div>");
				out.print("<div class='ls_h_dis'>" + branches.get(index).getBranchAddress() + "</div>");
				out
						.print("<div class='ls_h_opr'><a href='javascript:ajaxLoad(\"merchant-acts!delBranch?bid="+branches.get(index).getBid()+"\");'"+"class='mer_del_a' id='del"+index+"'>删除</a><a href='#' class='opr_a'>更新</a></div><div class='clear'></div></div>");
				out.print("<div class='hidden' id='"+index+"'>");
//				out.print("<div class='hidden' >" + "<div id='type'>" + branches.get(index).getAreaType() + "</div>" + "<div id='lat'>" + branches.get(index).getBranchLocation().getLatitude() + "</div>" + "<div id='lon'>"
//						+ branches.get(index).getBranchLocation().getLongitude() + "</div>");
//
//				StringBuffer vertexs = new StringBuffer();
//				boolean first = true;
//				for (Location l : branches.get(index).getBranchDeliveryArea()) {
//					if (!first) {
//						vertexs.append(',');
//					} else {
//						first = false;
//					}
//					vertexs.append(l.getLatitude());
//					vertexs.append(",");
//					vertexs.append(l.getLongitude());
//				}

//				out.print("<div id='dev_vertexs'>" + vertexs.toString() + "</div></div></div>");
				out.print("</div></div>");
			}
		}
		
		out.print("</div><!--branchlist--><div id='footer'></div>");
	}
}
