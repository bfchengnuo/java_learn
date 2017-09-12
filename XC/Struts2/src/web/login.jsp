<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2017/6/12
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登陆测试</title>
</head>
<body>
    <s:debug/> <br>
    <s:form action="Login_reg" name="login">
        <s:textfield name="name" label="用户名"/>
        <s:submit/>
    </s:form>
</body>
</html>
