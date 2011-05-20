<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="/WEB-INF/include/HTMLHead.jsp" />
<body onload="init()">
	<div id="wrapper">
		<jsp:include page="/WEB-INF/include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div id="merchant_nav" class="sidebar_block">
						<a href="#" class="merchant_nav_a">管理资料</a>
						<a id="merchant_branches_mgr" href="#" class="merchant_nav_a">管理分店</a>
						<a href="#" class="merchant_nav_a">管理菜单</a>
						<a href="#" class="merchant_nav_a">管理订单</a>
					</div>
					<div id="index_opt1" class="sidebar_block">
						将标记拖曳到右边告诉我们你的位置
					</div>
					<div id="index_opt2" class="sidebar_block">
						<h1>hello111 ${merchant.username}+<s:property value="merchant.location" />+<s:property value="merchant.address" /></h1>
<h1>hello ${merchant.username}+${merchant.email}
                      <a id="ListAvailables" href="/StructsTest/list-availables">点击查询</a></h1>
						<br />
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