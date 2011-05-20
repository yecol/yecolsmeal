<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="WEB-INF/include/HTMLHead.jsp" />
<body onload="init()">
	<div id="wrapper">
		<jsp:include page="WEB-INF/include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div id="index" class="sidebar_block">
						这是一个定餐网站，你可以在这里订餐和查询你的订餐情况。我们希望能改善你的订餐体验。这是一个定餐网站，你可以在这里订餐和查询你的订餐情况。我们希望能改善你的订餐体验。这是一个定餐网站，你可以在这里订餐和查询你的订餐情况。我们希望能改善你的订餐体验。这是一个定餐网站，你可以在这里订餐和查询你的订餐情况。我们希望能改善你的订餐体验。
					</div>
					<div id="index_opt1" class="sidebar_block">
						将标记拖曳到右边告诉我们你的位置
					</div>
					<div id="index_opt2" class="sidebar_block">
						或者登录（注册）你的帐户再进行后续操作
						<br />
						<a id="bt_signin"></a>
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