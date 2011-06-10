<%@ page language="java" import="java.util.*,com.qq.cstar.speedymeal.entity.*" pageEncoding="UTF-8"%>
<div id="head">
	<div class="headContent">
		<%@taglib uri="/struts-tags" prefix="s"%>
		<%
			HttpSession sm_session = request.getSession(false);
			if (sm_session != null && sm_session.getAttribute("SpeedyMeal_Session_User") != null) {
		%>
		欢迎您
		<% User user = (User)sm_session.getAttribute("SpeedyMeal_Session_User"); %>
		<%=user.getUsername() %>
		<a href="UserNavi!manage.action" class="h">管理首页</a>
		<a href="index.jsp" class="h">完善我的资料</a>

		<%
			if (sm_session.getAttribute("shoppingCart_totalLength") == null) {
		%>
		<a href="index.jsp" class="h">购物车</a>
		<%
			} else {
		%>
		<a href="UserNavi!cart.action" class="n">购物车(<%=sm_session.getAttribute("shoppingCart_totalLength")%>)</a>
		<%
			}
		%>
		<a href="UserAction!logout.action" class="h">退出</a>
		<%
			} else if (sm_session != null && sm_session.getAttribute("SpeedyMeal_Session_Merchant") != null) {
		%>
		欢迎您
		<% Merchant merchant = (Merchant)sm_session.getAttribute("SpeedyMeal_Session_Merchant"); %>
		<%=merchant.getUsername() %>
		<a href="MerchantNavi!manage.action" class="n">管理首页</a>
		<a href="MerchantAction!logout.action" class="n">退出</a>
		<%
			}

			else {
		%>
		您还未登录 请先
		<a href="login.jsp" class="n">登录</a> 或者
		<a href="register.jsp" class="n">注册</a>一个新帐户
		<%
			}
		%>
	</div>
</div>