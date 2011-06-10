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

						<s:iterator value="availableBranches" id="item" status="merstat">
							<div class="list_single">
								<div class="ls_head">
									<div class="ls_h_mer" id="<s:property value='#merstat.index+1' />_ls_h_mer">
									    <s:property value='#merstat.index+1' />.
										<s:property value='#item.companyName' />
									</div>
									<div class="ls_h_bra" id="<s:property value='#merstat.index+1' />_ls_h_bra">
										<s:property value='#item.branchName' />
									</div>
									<div class="ls_h_dis" id="<s:property value='#merstat.index+1' />_ls_h_phone">
										电话  <s:property value='#item.branchPhone' />
									</div>
									<div class="ls_h_dis" id="<s:property value='#merstat.index+1' />_ls_h_dis">
										距离您的位置大约有<s:property value='#item.distance' />米
									</div>
									<div class="hidden">
								    	<div class="location" id="<s:property value='#merstat.index+1' />_location">
								     	    <s:property value='#item.branchLocation' />
								    	</div>
								    	<div class="deliveryArea" id="<s:property value='#merstat.index+1' />_dev_vertexs">
								     	    <s:property value='#item.branchDeliveryArea.toString()' />
								    	</div>
								    	<div id="<s:property value='#merstat.index+1' />_ls_h_addr">
								     	    <s:property value='#item.branchAddress' />
								    	</div>
									</div>
									<div class="clear"></div>
								</div>

								<div class="menus"> 
								    <s:iterator value="#item.menus" id="menu" status="stat">
								    <s:if test="#stat.index<3">
									<li>
										<span class="ls_m_t"><s:property value='#menu.menuItemName' /></span><span class="ls_m_r"><a
											href="UserAction!addToCart.action?bid=<s:property value='#item.bid' />&meid=<s:property value='#menu.meid' />" class="buy"></a><span>￥<s:property value='#menu.menuItemPrice' /></span> </span>
									</li>
									</s:if>
									</s:iterator>
									
									<a href="SearchAction!singleList.action?bid=<s:property value='#item.bid' />" class="more" id="<s:property value='#merstat.index+1' />_ls_h_menu">全部菜单</a>
									<div class="clear"></div>
								</div>
							</div>
							<!--listSingle-->

						</s:iterator>


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

