<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2017/6/13
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form namespace="/ognl" action="OgnlAction" method="POST">
        <s:textfield name="names" label="names"/>
        <s:textfield name="names[0]" label="names[0]"/>
        <s:textfield name="names[1]" label="names[1]"/>
        <s:textfield name="nameList[0].name" label="nameList-name"/>
        <s:textfield name="nameList[0].age" label="nameList-age"/>
        <%-- map 的 key 如果是字符串可以直接用 . ：map.key.name --%>
        <s:textfield name="nameMap" label="Map-conver"/>
        <s:textfield name="nameMap.key.name" label="Map-name"/>
        <s:submit/>
    </s:form>
</body>
</html>
