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
					<div id="merchant_register_form" class="sidebar_block">
					    <s:actionerror />
						<s:form action="merchant-acts!register">
							<s:textfield name="merchant.username" label="用户名" cssStyle="inputBox"/>
							<s:password name="merchant.pwd" label="密码" cssStyle="inputBox"/>
							<s:textfield name="merchant.email" label="Email" cssStyle="inputBox"/>
							<s:textfield name="merchant.phone" label="电话号码" cssStyle="inputBox"/>
							<s:textfield name="merchant.companyName" label="公司名称" cssStyle="inputBox"/>
							<s:submit />
						</s:form>
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


