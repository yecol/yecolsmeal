<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="com.qq.cstar.speedymeal.entity.*,java.util.ArrayList"%>
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
					<div id="order_info" class="sidebar_block">
						<div class="gTitle">
							购物车
						</div>
						<%
							HttpSession sc_session = request.getSession();
							ShoppingCart cart = (ShoppingCart) sc_session.getAttribute("shoppingCart");
							User user = (User) sc_session.getAttribute("SpeedyMeal_Session_User");
							if (cart == null) {
						%>

						<p>
							购物车为空
						</p>
						<%
							} else {
								ArrayList<OrderItem> itemsOrdered = cart.getOrderedItems();
								if (itemsOrdered.size() == 0) {
						%><p>
							购物车为空
						</p>
						<%
							} else {
						%>



						<table id="orderInfo">
							<tr>
								<td colspan="4">
									<div class="tdHeadCnt">
										餐饮提供方
									</div>
								</td>
							</tr>
							<tr>
								<td width="63">
									名称
								</td>
								<td colspan="3">
									<%=cart.getBranch().getCompanyName() + " " + cart.getBranch().getBranchName()%>
								</td>
							</tr>
							<tr>
								<td width="63">
									电话
								</td>
								<td colspan="3">
									<%=cart.getBranch().getBranchPhone()%>
								</td>
							</tr>
							<tr>
								<td width="63">
									地址
								</td>
								<td colspan="3">
									<%=cart.getBranch().getBranchAddress()%>
								</td>
							</tr>
							<tr>
								<td colspan="4">
									<div class="tdHeadCnt">
										购物车明细
									</div>
								</td>

							</tr>
							<tr>
								<td colspan="2">
									美食名称
								</td>
								<td width="63">
									单价
								</td>
								<td width="63">
									份数
								</td>
							</tr>

							<%
								OrderItem oi;
										for (int i = 0; i < itemsOrdered.size(); i++) {
											oi = itemsOrdered.get(i);
							%>


							<tr>
								<td colspan="2">
									<%=oi.getMenu().getMenuItemName()%>
								</td>
								<td width="63">
									<%=oi.getMenu().getMenuItemPrice()%>
								</td>
								<td width="63">
									<form action="UserAction!addToCart" method="post">
										<INPUT TYPE="HIDDEN" NAME="bid"
											VALUE="<%=cart.getBranch().getBid()%>" />
										<INPUT TYPE="HIDDEN" NAME="meid"
											VALUE="<%=oi.getMenu().getMeid()%>" />
										<INPUT TYPE="TEXT" NAME="itemNum" SIZE=1
											VALUE="<%=oi.getPieces()%> " />
										<INPUT TYPE="SUBMIT" VALUE="更改" />
									</form>
								</td>
							</tr>
							<%
								}
							%>
							<tr>
								<td width="63">
									总价
								</td>
								<td colspan="3">

									<%=sc_session.getAttribute("shoppingCart_totalPrice")%>
								</td>
							</tr>
						</table>

						<%
							}
							}
						%>

						<p class="navP">
							<a href="SearchAction!loginedList" class="n">重新选择商家</a>
						</p>
						<p class="navP">
							<a href="SearchAction!loginedList" class="n">继续在该店订餐</a>
						</p>
						<p class="navP">
							<a href="UserNavi!order" class="n">提交订单</a>
						</p>
					</div>
					<!--order_info-->
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
		<div id="user_location">
			<%=user.getLocation()%>
		</div>
		<div id="b_location">
			<%=cart.getBranch().getBranchLocation()%>
		</div>
		<div id="b_dev_vertexs">
			<%=cart.getBranch().getBranchDeliveryArea().toString()%>
		</div>
	</div>
</body>
</html>