<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib uri="/struts-tags" prefix="s"%>

<jsp:include page="../include/HTMLHead.jsp" />

<script src="js/addBranch.js"></script>

<body onload="init()">
	<div id="wrapper">
		<jsp:include page="../include/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div class="gTitle">
						添加分店
					</div>
					<div id="merchant_add_branch_form" class="sidebar_block">

						<s:actionerror />
						<s:form action="MerchantAction!addBranch" onsubmit="return isValid(this);">
							<s:textfield name="branchName" label="分店名称" cssStyle="ib" />
							<s:textfield name="branchAddress" label="分店地址" cssStyle="ib" />
							<s:textfield name="branchPhone" label="电话号码" cssStyle="ib" />
							<tr>
								<td align="right">
									<img src="images/geotag.jpg" />
								</td>
								<td>
									在右边地图中点击以标记您的位置
									<br>
									</>并圈定该分店的送货范围
								</td>
							</tr>
							<s:hidden name="areaType" id="br_areaType" value="0" />
							<s:hidden name="bla" id="br_la" value="" />
							<s:hidden name="blo" id="br_lo" value="" />
							<s:hidden name="vertexs" id="dev_vertexs" value="" />
							<!-- <s:div id="dev_vertexs"></s:div> -->
							<s:submit value='' cssClass="smt_submit" />
						</s:form>
						<p>
							点此
							<a href="MerchantNavi!manage" class="n">返回 </a> 商户管理首页
						</p>
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
	<div id="interactive" class="hidden">add</div>
</body>
</html>


