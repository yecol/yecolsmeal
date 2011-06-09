<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../include/HTMLHead.jsp" />
<script src="js/ditu.js"></script>
<body onload="init()">
	<div id="wrapper">
		<jsp:include page="../include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div id="mer_mgr" class="sidebar_block">
						<div class="gTitle">
						         用户管理
						</div>
						<a href="SearchAction!loginedList" class="mgr_m">查找快餐</a>
						<a href="javascript:ajaxLoad('MerchantAction!listMenus');"
							class="mgr_m">订单跟踪</a>
						<a href="#" class="mgr_m">资料管理</a>
						<a href="UserAction!logout" class="mgr_m">退出登录</a>
					</div>
					<!--mer_mgr-->

					<jsp:include page="../include/SideFooter.jsp" />
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
	</div>
</body>
</html>

