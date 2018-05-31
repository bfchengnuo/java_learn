<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2018/5/28
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <a href="stu.jsp">添加用户</a>
    <hr>
    <form action="querySome.action" method="post" style="width: 600px;margin: 0 auto">
        <input type="hidden" name="pageNumber" value="1">
        查询条件： <br>
        姓名：<input type="text" name="student.name" value="${requestScope.student.name}">
        年龄：<input type="number" name="student.age" value="${requestScope.student.age}">
        <input type="submit" onclick="querySome()" value="查询">
    </form>
    <hr>
    <table border="1px" cellspacing="0" style="width: 600px;margin: 0 auto">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
            <th>操作</th>
        </tr>

        <c:forEach var="s" items="${requestScope.page.rows}">
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

        <tr>
            <td colspan="5">
                共${requestScope.page.total}条数据，当前第${requestScope.page.pageNumber}页，共${requestScope.page.pageCount}页
            </td>
        </tr>

    </table>
    <div style="width: 600px;margin: 0 auto">
        <button onclick="chang('1')"> 首页 </button>
        <button onclick="chang('${requestScope.page.pre}')"> 上一页 </button>
        <button onclick="chang('${requestScope.page.next}')"> 下一页 </button>
        <button onclick="chang('${requestScope.page.pageCount}')"> 尾页 </button>
    </div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        function del(sid) {
            window.location.href = "${pageContext.request.contextPath}/del.action?student.id=" + sid;
        }

        function update(sid) {
            window.location.href = "${pageContext.request.contextPath}/getUpdatePage.action?student.id=" + sid;
        }

        function chang(pn) {
            querySome();
            if (tj != null && tj.length !== 0){
                window.location.href = "querySome.action?pageNumber=" + pn + tj;
            } else {
                window.location.href = "querySome.action?pageNumber=" + pn;
            }
        }

        var tj = "";
        function querySome() {
            tj = "";
            var name = $("input[name='student.name']").val();
            var age = $("input[name='student.age']").val();

            if (name != null && name.length !== 0){
                tj += "&student.name=" + name;
            }

            if (age != null && age.length !== 0){
                tj += "&student.age=" + age;
            }
        }

    </script>
</body>
</html>
