<%--
  Created by IntelliJ IDEA.
  User: lvxue
  Date: 5/12/2017
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="username"><br>
    密  码：<input type="text" name="pwd"><br>
    有效期：
    <input type="radio" name="autologin" value="60">一分钟 &nbsp;&nbsp;
    <input type="radio" name="autologin" value="300">五分钟 &nbsp;&nbsp;
    <input type="radio" name="autologin" value="600">十分钟 &nbsp;&nbsp;
    <br>
    <input type="submit" value="提交">
</form>

</body>
</html>
