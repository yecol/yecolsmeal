package com.qq.cstar.speedymeal.intercepter;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qq.cstar.speedymeal.entity.Merchant;

public class MerchantInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	// 拦截Action处理的拦截方法
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		Merchant merchant = (Merchant) session.get("SpeedyMeal_Session_Merchant");
		// 如果没有登陆，
		if (merchant != null) {
			return invocation.invoke();
		}// 没有登陆，将服务器提示设置成一个HttpServletRequest属性
		else
			return "login";
	}
}