<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@taglib uri="/struts-tags" prefix="s"%>
	
<jsp:include page="WEB-INF/INCLUDE/HTMLHead.jsp" />
<body onload="init()">
	<div id="wrapper">
		<jsp:include page="WEB-INF/INCLUDE/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div id="merchant_login_form" class="sidebar_block">
						<s:form action="merchant-acts!login">
							<s:textfield name="merchant.username" label="用户名" />
							<s:password name="merchant.pwd" label="密码" />
							<br />
							<s:submit value="" cssClass="smt_signin" />
						</s:form>
					</div>
				</div>
				<!--sidebar_body-->
			</div>
			<!--Sidebar-->
			<div id="container">
			</div>
			<!--Container-->
		</div>
		<!--PageBody-->
	</div>
	<!--wrapper-->
	<div id="interactive" class="hidden">
		地图所要读取的交互数据都放在这里
	</div>
</body>
</html>

