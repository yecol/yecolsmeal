<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="head">
<%@taglib uri="/struts-tags" prefix="s" %>
<% HttpSession login_session = request.getSession(false);
     if(login_session != null&&login_session.getAttribute("SpeedyMeal_Session_User") != null)
	 { %>
	 欢迎您  <s:property value="user.username" /> <a href="#">我的订单</a> <a href="#">完善我的资料</a> <a href="#">购物车</a> <a href="#">退出</a>
  <% }  
  else if(login_session != null&&login_session.getAttribute("SpeedyMeal_Session_Merchant")!=null) { %>
         欢迎您  <s:property value="merchant.username" /> <a href="#">分店管理</a> <a href="#">菜单管理</a> <a href="#">完善资料</a> <a href="#">退出</a>
  <% } 
  
  else { %>
   你还未登录 请先登录
  <% }%></div>