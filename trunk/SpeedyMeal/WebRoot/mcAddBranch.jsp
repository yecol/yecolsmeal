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
					<div id="merchant_add_branch_form" class="sidebar_block">
					    <s:actionerror />
						<s:form action="merchant-acts!addBranch">						    
							<s:textfield name="branchName" label="分店名称" cssStyle="inputBox"/>
							<s:textfield name="branchAddress" label="分店地址" cssStyle="inputBox"/>
							<s:textfield name="branchPhone" label="电话号码" cssStyle="inputBox"/>
							<s:hidden name="areaType" id="br_areaType" value="0" />
							<s:hidden name="bla" id="br_la" value="0" />
							<s:hidden name="blo" id="br_lo" value="0" />
							<s:hidden name="alas" cssClass="ba_las" value="0" />
							<s:hidden name="alos" cssClass="la_los" value="0" />
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


