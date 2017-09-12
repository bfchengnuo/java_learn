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
    <title>注册的测试页</title>
</head>
<body>
    <s:debug />
    这是一个测试页面 <br>
    <s:form namespace="/reg" action="RegAction_reg" method="POST" enctype="multipart/form-data">
        <s:textfield name="name" label="用户名"/>
        <s:textfield name="age" label="年龄"/>
        <s:file name="img" label="上传文件"/>
        <s:submit value="提交"/>
    </s:form>
</body>
</html>
