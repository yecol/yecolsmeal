<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/include/HTMLHead.jsp" />

<script src="js/ditu.js"></script>

<body onload="init()">
	<div id="wrapper">
		<jsp:include page="WEB-INF/include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div class="gTitle">
						用户登录
					</div>
					<div id="login_form" class="sidebar_block">
						<s:actionerror />
						<s:form action="user-acts!login">
							<s:token />
							<s:textfield name="user.username" label="用户名" cssClass="ib" />
							<s:password name="user.pwd" label="密码" cssClass="ib" />
							<s:submit value="" cssClass="smt_signin" />
						</s:form>
						<p>
							没有帐号？现在
							<a href="register.jsp" class="n">注册</a> 一个。
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


