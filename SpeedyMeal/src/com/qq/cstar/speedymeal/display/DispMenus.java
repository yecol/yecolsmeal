package com.qq.cstar.speedymeal.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Menu;

public class DispMenus {

	public static void display(HttpServletResponse response, ArrayList<Menu> menus, int mid) {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print("<p>���<a href='merchant-acts!mgr' class='n'>���� </a> �̻�������ҳ</p>");
		out.print("<div id='merchant_add_menu_form' class='sidebar_block'><div class='gTitle'>���Ӳ˵�</div>");
		out
				.print("<form id='merchant-acts' name='merchant-acts' action='/SpeedyMeal/merchant-acts!addMenu.action' method='post'><table class='wwFormTable'><tbody><tr><td class='tdLabel'><label for='merchant-acts_menu_menuItemName' class='label'>����:</label></td><td><input type='text' name='menu.menuItemName' value='' id='merchant-acts_menu_menuItemName' class='ib'></td></tr><tr><td class='tdLabel'><label for='merchant-acts_menu_menuItemPrice' class='label'>����:</label></td><td><input type='text' name='menu.menuItemPrice' value='' id='merchant-acts_menu_menuItemPrice' class='ib' /></td></tr><input type='hidden' name='menu.mid' value='"
						+ mid
						+ "' id='merchant-acts_menu_mid'><tr><td colspan='2'><div align='right'><input type='submit' id='merchant-acts_0' value='' class='smt_submit'></div></td></tr></tbody></table></form></div>");

		out
				.print("<div id='menu' class='sidebar_block'><div class='gTitle'>���в˵�</div><table id='orderInfo'><tr><td colspan='4'><div class='tdHeadCnt'>�˵���Ϣ</div></td></tr>");
		if (menus.size() != 0) {
			for (int index = 0; index < menus.size(); index++) {
				out.print("<tr><td colspan='2'>");
				out.print(menus.get(index).getMenuItemName());
				out.print("</td><td width='63'>");
				out.print(menus.get(index).getMenuItemPrice() + "Ԫ");
				out.print("</td><td width='63'>");
				out.print("<a href='javascript:ajaxLoad(\"merchant-acts!delMenu?meid=" + menus.get(index).getMeid() + "\");'"
						+ "class='menu_del_a' id='del" + index + "'>ɾ��</a>");
				out.print("</td></tr>");
			}
		}

		out.print("</table></div><div id='footer'></div>");
	}
}