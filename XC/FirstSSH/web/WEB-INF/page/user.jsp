<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2017/8/30
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>UserList</title>
</head>
<body>
    <s:iterator value="#request.userList">
        <s:property value="id"/> ||
        <s:property value="name"/> ||
        <s:property value="password"/> <br>
    </s:iterator>
</body>
</html>
