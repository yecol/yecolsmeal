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
					<div id="mer_mgr" class="sidebar_block">
						<div class="gTitle">
							商家管理
						</div>
						<a href="#" class="mgr_m">商户信息更改</a>
						<a href="#" class="mgr_m">菜单信息管理</a>
						<a href="#" class="mgr_m">订单信息管理</a>
						<a href="javascript:ajaxLoad('ax-branches-mgr!listBranches');"
							class="mgr_m">分店信息管理</a>
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
		<s:iterator value="branches" id="item">
			<div class="list_single">
					<div class="ls_h_mer" id="<s:property value='#item.bid' />">
						<s:property value='#item.branchName' />
					</div>
					<div class="ls_h_bra">
						<s:property value='#item.branchPhone' />
					</div>
					<div class="ls_h_dis">
						<s:property value='#item.branchAddress' />
					</div>
					<div id="<s:property value='#item.bid' />_type">
					    <s:property value='#item.areaType' />
					</div>
					<div id="<s:property value='#item.bid' />_lat">
						<s:property value='#item.branchLocation.latitude' />
					</div>
					<div id="<s:property value='#item.bid' />_lon">
						<s:property value='#item.branchLocation.longitude' />
					</div>
					<div id="<s:property value='#item.bid' />_dev_vertexs">
						<s:property value='#item.branchDeliveryArea.toString()' />
					</div>
			</div>
		</s:iterator>
	</div>
</body>
</html>

