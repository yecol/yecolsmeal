<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div id="login_form" class="sidebar_block">
	<s:form action="user-acts!login">
		<s:textfield name="user.username" label="用户名" />
		<s:password name="user.pwd" label="密码" />
		<br />
		<s:submit value="" cssClass="smt_signin" />
	</s:form>
</div>
