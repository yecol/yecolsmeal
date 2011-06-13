<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="WEB-INF/include/HTMLHead.jsp" />

<script src="js/index.js"></script>

<body>
	<div id="wrapper">
		<jsp:include page="WEB-INF/include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div id="index" class="sidebar_block">
						<div class="gTitle">
							网站介绍
						</div>
						<p>
							SpeedyMeal是一个基于地图的餐饮外卖系统，由商家视图、客户视图、以及配送员视图（Android应用）三部分构成，旨在以B2C的运营模式和B/S构架为商家提供订餐处理和配送指派业务，从而给客户创造出便捷、透明、可跟踪的一站式订餐消费体验。将地理信息和位置服务引入传统订餐和外卖配送系统是该应用的创新点。
						</p>
					</div>
					<div id="opera" class="sidebar_block">
						<div class="gTitle">
							如何操作
						</div>
						<p>
							您可以手动在右边地图上调整位置，确定位置后点击立即搜索按钮进行商户搜索。
							<div id="detectGeo">正在检测您的位置…</div>
							<div id="searchBotton"><a href="SearchAction" onclick="setHref()" id="indexSearchA"></a></div>
						</p>
						<p>
							或者<a href="login.jsp" class="n">登录</a>您的帐号，使用您之前登记的位置信息。还没有帐号？
							<a href="register.jsp" class="n">注册</a>一个吧。
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
	    <input type="text" id="test" value="sss" />
		<div id="l_lat"></div>
		<div id="l_lng"></div>
	</div>
</body>
</html>