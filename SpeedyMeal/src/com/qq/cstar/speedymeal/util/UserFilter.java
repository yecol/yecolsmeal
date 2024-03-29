package com.qq.cstar.speedymeal.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qq.cstar.speedymeal.entity.User;

public class UserFilter extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	// 拦截Action处理的拦截方法
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		User user = (User) session.get("SpeedyMeal_Session_User");
		// 如果没有登陆，
		if (user != null) { 
			System.out.println("yes");
			return invocation.invoke();
		}// 没有登陆，将服务器提示设置成一个HttpServletRequest属性
		else{
			System.out.println("no");
			return "login";
		}
			
	}
}