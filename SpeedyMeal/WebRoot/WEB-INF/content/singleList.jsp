<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="../include/HTMLHead.jsp" />
<script src="js/showMerchantBranches.js"></script>
<body onload="init()">
	<div id="wrapper">
		<jsp:include page="../include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div id="avilist" class="sidebar_block">
						<div class="gTitle">
							可达外卖
						</div>

					
							<div class="list_single">
								<div class="ls_head">
									<div class="ls_h_mer" id="ls_h_mer">
										<s:property value='branch.companyName' />
									</div>
									<div class="ls_h_bra" id="ls_h_bra">
										<s:property value='branch.branchName' />
									</div>
									<div class="ls_h_dis" id="ls_h_phone">
										电话  <s:property value='branch.branchPhone' />
									</div>
									<div class="ls_h_dis" id="ls_h_dis">
										距离您的位置大约有<s:property value='branch.distance' />米
									</div>
									<div class="hidden">
								    	<div class="location" id="location">
								     	    <s:property value='branch.branchLocation' />
								    	</div>
								    	<div class="deliveryArea" id="dev_vertexs">
								     	    <s:property value='branch.branchDeliveryArea.toString()' />
								    	</div>
								    	<div id="ls_h_addr">
								     	    <s:property value='branch.branchAddress' />
								    	</div>
									</div>
									<div class="clear"></div>
								</div>

								<div class="menus"> 
								    <s:iterator value="branch.menus" id="menu" status="stat">
									<li>
										<span class="ls_m_t"><s:property value='#menu.menuItemName' /></span><span class="ls_m_r"><a
											href="UserAction!addToCart.action?bid=<s:property value='branch.bid' />&meid=<s:property value='#menu.meid' />" class="buy"></a><span>￥<s:property value='#menu.menuItemPrice' /></span> </span>
									</li>
									</s:iterator>
									
									<div class="clear"></div>
								</div>
							</div>
							<!--listSingle-->

                        <%
                        HttpSession sm_session = request.getSession(false);
                        if (sm_session != null && sm_session.getAttribute("SpeedyMeal_Session_User") != null){ %>
                        <p>返回<a href="SearchAction!loginedList.action" class="n">全部列表</a>页面</p>
                        <%}else {%>
                        <p>返回<a href="index.html" class="n">首页</a>重新搜索</p>           
                        <%} %>
						<jsp:include page="../include/SideFooter.jsp" />
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
	<div id="u_lat"><s:property value='location.getLatitude()' /></div>
	<div id="u_lng"><s:property value='location.getLongitude()' /></div>

	</div>
</body>
</html>

