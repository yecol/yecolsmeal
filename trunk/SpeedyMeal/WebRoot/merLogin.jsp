<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/include/HTMLHead.jsp" />
<body onload="init()">
	<div id="wrapper">
		<jsp:include page="WEB-INF/include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div class="gTitle">
						商家登录
					</div>
					<div id="login_form" class="sidebar_block">
						<s:actionerror />
						<s:form action="merchant-acts!login">
							<s:textfield name="merchant.username" label="用户名" cssClass="ib" />
							<s:password name="merchant.pwd" label="密码" cssClass="ib" />
							<s:submit value="" cssClass="smt_signin" />
						</s:form>
						<p>
							还未加入SpeedyMeal？现在就免费
							<a href="merRegister.jsp" class="n">申请加入</a> 
							或者
							<a href="index.jsp" class="n">返回</a> 首页。
						</p>

					</div>

					<jsp:include page="WEB-INF/include/SideFooter.jsp" />
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
		<div id="page"></div>
	</div>
</body>
</html>

