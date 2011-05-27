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
						商户注册
					</div>
					<div id="register_form" class="sidebar_block">
						<s:actionerror />
						<s:form action="merchant-acts!register">
							<s:textfield name="merchant.username" label="用户名" cssStyle="ib" />
							<s:password name="merchant.pwd" label="密码" cssStyle="ib" />
							<s:textfield name="merchant.email" label="Email" cssStyle="ib" />
							<s:textfield name="merchant.phone" label="电话号码" cssStyle="ib" />
							<s:textarea name="merchant.companyName" label="公司名称"
								cssStyle="ia" />
							<s:textarea name="merchant.companyName" label="公司地址"
								cssStyle="ia" />
							<s:submit value="" cssClass="smt_register" />
						</s:form>
						<p>
							已经有商户帐号？从这里
							<a href="merLogin.jsp" class="n">登录</a> 。
							<br />
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


