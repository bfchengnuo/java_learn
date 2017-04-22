<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" uri="http://bfchengnuo.com" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

Hello World! <br>
<input type="radio" name="sex" ${user != null?'checked':''}>测试 <br>
<input type="radio" name="sex" ${user == null?'checked':''}>测试
<br>

<%
    request.setAttribute("key", "test");
%>

${key}

<%-- EL 表达式执行函数 --%>
${my:test("loli")}

</body>
</html>
