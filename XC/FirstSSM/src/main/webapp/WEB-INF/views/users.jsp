<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2017/10/10
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试界面</title>
</head>
<body>
    Hello world！ <br>
    <c:forEach items="${userList}" var="user" >
        id:${user.id} ------- name:${user.name} <br>
    </c:forEach>
</body>
</html>
