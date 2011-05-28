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
					<div id="mer_mgr" class="sidebar_block">
						<div class="gTitle">
							商家管理
						</div>
						<a href="#" class="mgr_m">商户信息更改</a>
						<a href="#" class="mgr_m">菜单信息管理</a>
						<a href="#" class="mgr_m">订单信息管理</a>
						<a href="#" id="merchant_branches_mgr" class="mgr_m">分店信息管理</a>
						<a href="index.jsp" class="mgr_m">返回首页</a>
						<a href="#" class="mgr_m">退出登录</a>
					</div>
					<!--mer_mgr-->

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

