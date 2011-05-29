<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="head"><div class="headContent"> 
<%@taglib uri="/struts-tags" prefix="s" %>
<% HttpSession login_session = request.getSession(false);
     if(login_session != null&&login_session.getAttribute("SpeedyMeal_Session_User") != null)
	 { %>
	 欢迎您  <s:property value="user.username" /> <a href="#" class="n">我的订单</a> <a href="#" class="n">完善我的资料</a> <a href="#" class="n">购物车</a> <a href="#" class="n">退出</a>
  <% }  
  else if(login_session != null&&login_session.getAttribute("SpeedyMeal_Session_Merchant")!=null) { %>
         欢迎您  <s:property value="merchant.username" /> <a href="merchant-acts!mgr" class="n">管理首页</a> <a href="merchant-acts!logout" class="n">退出</a>
  <% } 
  
  else { %>
   您还未登录 请先<a href="login.jsp" class="n">登录</a> 或者<a href="register.jsp" class="n">注册</a>一个新帐户
  <% }%></div></div>