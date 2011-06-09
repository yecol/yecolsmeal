package com.qq.cstar.speedymeal.intercepter;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qq.cstar.speedymeal.entity.User;

public class UserInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	// ����Action��������ط���
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		User user = (User) session.get("SpeedyMeal_Session_User");
		// ���û�е�½��
		if (user != null) {
			return invocation.invoke();
		}// û�е�½������������ʾ���ó�һ��HttpServletRequest����
		else
			return "login";
	}
}