<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>wait</title>
    <%--模拟头，每隔两秒刷新，地址是当前的 url--%>
    <meta http-equiv="refresh" content="2;url=<s:url/>"/>
</head>
<body>
    处理中....
</body>
</html>