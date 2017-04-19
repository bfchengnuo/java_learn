<%--
  Created by IntelliJ IDEA.
  User: lvxue
  Date: 4/19/2017
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://bfchengnuo.com" prefix="custTag" %>
<html>
<head>
    <title>自定义标签测试</title>
</head>
<body>
    您的 IP 是：
    <custTag:ViewIP>
        <br>我是标签体内的内容
    </custTag:ViewIP>
</body>
</html>
