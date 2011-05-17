<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib uri="/struts-tags" prefix="s" %>
<jsp:include page="/WEB-INF/INCLUDE/HTMLHead.jsp" />
<body onload="init()">
	<div id="wrapper">
		<jsp:include page="/WEB-INF/INCLUDE/Head.jsp" />
		<!--head-->
		<div id="PageBody">
			<div id="sidebar">
				<div id="logo"></div>
				<div id="sidebar_body">
					<div id="index" class="sidebar_block">
						这是一个定餐网站，你可以在这里订餐和查询你的订餐情况。我们希望能改善你的订餐体验。这是一个定餐网站，你可以在这里订餐和查询你的订餐情况。我们希望能改善你的订餐体验。这是一个定餐网站，你可以在这里订餐和查询你的订餐情况。我们希望能改善你的订餐体验。这是一个定餐网站，你可以在这里订餐和查询你的订餐情况。我们希望能改善你的订餐体验。
					</div>
					<div id="index_opt1" class="sidebar_block">
						将标记拖曳到右边告诉我们你的位置
					</div>
					<div id="index_opt2" class="sidebar_block">
						<h1>hello <s:property value="availableBranches.size" />+<s:property value="availableBranches[1]" /></h1>
