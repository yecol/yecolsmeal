<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
        <s:form action="merchant-acts!register" >
            <s:textfield name="merchant.username" label="User Name" />
             <s:textfield name="merchant.pwd" label="Password" />
             <s:textfield name="merchant.email" label="Email" />
             <s:textfield name="merchant.phone" label="Phone" />
             <s:textfield name="merchant.companyName" label="companyName" />
             <s:textfield name="merchant.address" label="Address" />
            <s:submit />
        </s:form>
    </body>
</html>
