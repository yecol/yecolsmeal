<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/include/HTMLHead.jsp" />

<script src="js/register.js"></script>

<body onload="init()">
	<div id="wrapper">
		<jsp:include page="WEB-INF/include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div class="gTitle">
						用户注册
					</div>
					<div id="register_form" class="sidebar_block">
						<s:actionerror />
						<s:form action="UserAction!register" onsubmit = "return isValid(this);">
							<s:textfield name="user.username" label="用户名" cssClass="ib" />
							<s:password name="user.pwd" label="密码" cssClass="ib" />
							<s:textfield name="user.email" label="Email" cssClass="ib" />
							<s:textfield name="user.phone" label="电话" cssClass="ib" />
							<s:textarea name="user.address" label="地址" cssClass="ia" />						
							<s:hidden name="r_lat" value="" />
							<s:hidden name="r_lon" value="" />
							<tr><td align="right"><img src="images/geotag.jpg"/></td><td>在右边地图中点击以标记您的位置</td></tr>
														<s:submit value="" cssClass="smt_register" />
						</s:form>
						<p>
							已经有帐号？从这里
							<a href="login.jsp" class="n">登录</a> 。
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
