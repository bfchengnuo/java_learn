<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2017/6/3
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>验证框架测试</title>
</head>
<body>
    <s:debug /> <br>
    <s:actionerror/> <br>
    <s:form namespace="/md" action="MdAction_reg" method="POST">
        <%-- 获取栈中的第二个对象，在这里也就是 Action --%>
        <%--<s:textfield name="[1].user.name" label="用户名"/>--%>
        <s:textfield name="name" label="用户名"/>
        <s:textfield name="age" label="年龄"/>
        <s:submit value="提交"/>
    </s:form>
</body>
</html>
