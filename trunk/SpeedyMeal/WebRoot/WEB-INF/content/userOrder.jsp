<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="com.qq.cstar.speedymeal.entity.*,java.util.ArrayList"%>
<jsp:include page="../include/HTMLHead.jsp" />

<script src="js/ditu.js"></script>

<body onload="init()">
	<div id="wrapper">
		<jsp:include page="../include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div id="order_info" class="sidebar_block">
						<div class="gTitle">
							提交订单
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
										订单人信息
									</div>
								</td>
							</tr>
							<tr>
								<td width="63">
									用户名
								</td>
								<td colspan="3">
								<%= user.getUsername() %>
								</td>
							</tr>
							<tr>
								<td width="63">
									联系电话
								</td>
								<td colspan="3">
									<%= user.getPhone() %>
								</td>
							</tr>
							<tr>
								<td width="63">
									递送地址
								</td>
								<td colspan="3">
									<%= user.getAddress() %>
								</td>
							</tr>
						
						
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
									<%=cart.getBranch().getCompanyName()+" "+ cart.getBranch().getBranchName() %>
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
									<%=cart.getBranch().getBranchAddress() %>
								</td>
							</tr>
							<tr>
								<td colspan="4">
									<div class="tdHeadCnt">
										订单明细
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
									<%=oi.getPieces()%>
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

                    <p class="navP"><a href="list-availables!loginedList" class="n">重新订餐</a><a href="user-acts!cartToOrder">提交订单</a></p>
					</div>
					<!--order_info-->
					<jsp:include page="../include/SideFooter.jsp" />
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