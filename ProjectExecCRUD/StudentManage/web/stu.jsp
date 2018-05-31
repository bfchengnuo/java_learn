<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2018/5/28
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/${empty requestScope.student ?'add':'update'}">
        <input type="hidden" value="${requestScope.student.id}" name="student.id">
        <table>
            <tr>
                <td>学生姓名：</td>
                <td>
                    <input type="text" name="student.name" value="${requestScope.student.name}"/>
                </td>
            </tr>

            <tr>
                <td>年龄：</td>
                <td><input type="number" name="student.age" value="${requestScope.student.age}"></td>
            </tr>
            <tr>
                <td>生日：</td>
                <td>
                    <input type="date" name="student.birth"
                           value="<fmt:formatDate value="${ requestScope.student.birth}" pattern='yyyy-MM-dd'/>">
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</body>
</html>
