package com.qq.cstar.speedymeal.actions;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.cstar.speedymeal.entity.Branch;
import com.qq.cstar.speedymeal.entity.Location;
import com.qq.cstar.speedymeal.entity.Menu;
import com.qq.cstar.speedymeal.entity.ShoppingCart;
import com.qq.cstar.speedymeal.entity.User;
import com.qq.cstar.speedymeal.service.ProcessService;
import com.qq.cstar.speedymeal.service.UserService;

@Results( {
		@Result(name = "success", type = "redirect", location = "/usMgr.jsp"),
		@Result(name = "login", location = "/login.jsp"),
		@Result(name = "register", type = "redirect", location = "/register.jsp"),
		@Result(name = "cart", location = "/cart.jsp"),
		@Result(name = "index", type = "redirect", location = "/index.jsp") })
/* @InterceptorRef(value="token") */
public class UserActs extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private UserService userService = new UserService();
	private ProcessService processService = new ProcessService();
	private HttpServletRequest request;

	public String login() {
		System.out.println("time+1:" + new Date());
		if (user == null) {
			System.out.println("debug info: user == null");
			return null;
		}
		// 用户登录
		user = userService.loginByUsername(user.getUsername(), user.getPwd());
		if (user != null) {

			ActionContext.getContext().getSession().put(
					"SpeedyMeal_Session_User", user);
			System.out.println("return SUCCESS!");
			return SUCCESS;
		} else {
			addActionError("用户名或密码错误");
			return LOGIN;
		}
	}

	public String logout() {
		ActionContext.getContext().getSession().put("SpeedyMeal_Session_User",
				null);

		// Is it logical?
		ActionContext.getContext().getSession().put("shoppingCart", null);
		ActionContext.getContext().getSession().put("shoppingCart_totalPrice",
				null);
		ActionContext.getContext().getSession().put("shoppingCart_totalLength",
				null);
		//
		return "index";
	}

	public String register() {
		if (request == null) {
			System.out.println("Debug info: request == null");
			return null;
		}
		// 用户注册
		request = ServletActionContext.getRequest();
		double latitude = Double.parseDouble(request.getParameter("r_lat")
				.trim());
		double longitude = Double.parseDouble(request.getParameter("r_lon")
				.trim());

		user.setLocation(new Location(latitude, longitude));
		user = userService.registerUser(user);
		if (user != null) {
			ActionContext.getContext().getSession().put(
					"SpeedyMeal_Session_User", user);
			return SUCCESS;
		} else {
			addActionError("注册失败！请重新注册!");
			return "register";
		}
	}

	public String addToCart() {
		request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		String branIdString = request.getParameter("bid");
		String menuIdString = request.getParameter("meid");
		if (branIdString == null || menuIdString == null)
			return null;
		int bid = Integer.parseInt(branIdString.trim());
		ShoppingCart cart;
		synchronized (session) {
			cart = (ShoppingCart) session.get("shoppingCart");
			System.out.println("e1");
			if (cart != null && cart.getBranch().getBid() != bid) {
				session.put("shoppingCart", null);
				session.put("shoppingCart_totalPrice", null);
				session.put("shoppingCart_totalLength", null);
				cart = null;
			}
			if (cart == null) {
				cart = new ShoppingCart();
				Branch branch = processService.getBranchByBid(bid);
				cart.setBranch(branch);
				System.out.println("e3");
				session.put("shoppingCart", cart);
				session.put("shoppingCart_totalPrice", cart.getTotalPrice());
				session.put("shoppingCart_totalLength", cart.getTotalLength());
			}

			System.out.println("e4" + menuIdString);
			if (menuIdString != null) {
				int menuId = Integer.parseInt(menuIdString.trim());
				String numItemsString = request.getParameter("itemNum");
				System.out.println("e5" + menuId + "/" + numItemsString);

				if (numItemsString == null) {
					Menu menu = userService.getMenu(menuId);
					cart.addItem(menu);
				} else {
					int numItems;
					try {
						numItems = Integer.parseInt(numItemsString);
					} catch (NumberFormatException nfe) {
						numItems = 1;
					}
					// cart.setNumOrdered(itemID, numItems);
					cart.updateItem(menuId, numItems);
					System.out.println("e7");
				}
				session.put("shoppingCart_totalPrice", cart.getTotalPrice());
				session.put("shoppingCart_totalLength", cart.getTotalLength());
			}
		}
		return "cart";
	}

	public String cartToOrder() {
		Map session = ActionContext.getContext().getSession();
		ShoppingCart cart = (ShoppingCart) session.get("shoppingCart");
		User user = (User) session.get("SpeedyMeal_Session_User");
		userService.addToOrder(cart, user);
		// 清空购物车
		session.put("shoppingCart", null);
		session.put("shoppingCart_totalPrice", null);
		session.put("shoppingCart_totalLength", null);
		return SUCCESS;
	}

	public String update() {
		// 用户更新资料
		return null;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

}
