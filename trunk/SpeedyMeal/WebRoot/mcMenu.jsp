<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib uri="/struts-tags" prefix="s"%>

<jsp:include page="WEB-INF/include/HTMLHead.jsp" />

<script src="js/addBranch.js"></script>

<body onload="init()">
	<div id="wrapper">
		<jsp:include page="WEB-INF/include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<p>
						点此
						<a href="merchant-acts!mgr" class="n">返回 </a> 商户管理首页
					</p>
					<div id="merchant_add_menu_form" class="sidebar_block">
						<div class="gTitle">
							添加菜单
						</div>
						<s:actionerror />

						<s:form action="merchant-acts!addMenu">
							<s:textfield name="menu.menuItemName" label="名称" cssStyle="ib" />
							<s:textfield name="menu.menuItemPrice" label="单价" cssStyle="ib" />
							<s:hidden name="menu.mid" label="单价" value="1" />
							<s:submit value='' cssClass="smt_submit" />
						</s:form>
					</div>
					<div id="menu" class="sidebar_block">
						<div class="gTitle">
							已有菜单
						</div>
						<table id="orderInfo">
							<tr>
								<td colspan="4">
									<div class="tdHeadCnt">
										菜单信息
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									订单ID123
								</td>
								<td width="63">
									15元
								</td>
								<td width="63">
									删除
								</td>
							</tr>
							<tr>
								<td colspan="2">
									订单ID123
								</td>
								<td width="63">
									15元
								</td>
								<td width="63">
									删除
								</td>
							</tr>
							<tr>
								<td colspan="2">
									订单ID123
								</td>
								<td width="63">
									15元
								</td>
								<td width="63">
									删除
								</td>
							</tr>
							<tr>
								<td colspan="2">
									订单ID123
								</td>
								<td width="63">
									15元
								</td>
								<td width="63">
									删除
								</td>
							</tr>

						</table>
					</div>
					<!--menu-->
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
		add
	</div>
</body>
</html>


