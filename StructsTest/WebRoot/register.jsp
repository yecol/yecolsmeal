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
        <s:form action="user-acts!register" >
            <s:textfield name="user.username" label="User Name" />
             <s:textfield name="user.pwd" label="Password" />
             <s:textfield name="user.email" label="Email" />
             <s:textfield name="user.phone" label="Phone" />
             <s:textfield name="user.address" label="Address" />
            <s:submit />
        </s:form>
    </body>
</html>
