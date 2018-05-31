<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2018/5/28
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <a href="stu.jsp">添加用户</a>
    <hr>
    <table border="1px" cellspacing="0" style="width: 600px;margin: 0 auto">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
            <th>操作</th>
        </tr>

        <c:forEach var="s" items="${requestScope.list}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.age}</td>
                <td>${s.birth}</td>
                <td>
                    <button onclick="del('${s.id}')">删除</button>
                    <button onclick="update('${s.id}')">修改</button>
                </td>
            </tr>
        </c:forEach>

    </table>

    <script>
        function del(sid) {
            window.location.href = "${pageContext.request.contextPath}/del.action?student.id=" + sid;
        }

        function update(sid) {
            window.location.href = "${pageContext.request.contextPath}/getUpdatePage.action?student.id=" + sid;
        }
    </script>
</body>
</html>
