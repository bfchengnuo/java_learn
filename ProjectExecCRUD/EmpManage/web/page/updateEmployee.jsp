<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2018/5/30
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
    <form action="updateEmp.action" method="post">
        <input type="hidden" name="employee.empId" value="${requestScope.employee.empId}">
        <table border="1px" cellspacing="0">
            <tr>
                <td>员工编码：</td>
                <td>
                    <input type="number" name="employee.empCode" value="${requestScope.employee.empCode}">
                </td>
            </tr>
            <tr>
                <td>员工姓名：</td>
                <td>
                    <input type="text" name="employee.empName" value="${requestScope.employee.empName}">
                </td>
            </tr>
            <tr>
                <td>所属机构：</td>
                <td>
                    <select id="orga" name="orga"></select>
                </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>
                    <select id="sex" name="employee.sex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td>
                    <input type="number" name="employee.age" value="${requestScope.employee.age}">
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>

        <script src="../js/jquery-1.10.2.js"></script>
        <script>
            var sex = '${requestScope.employee.sex}';
            var orga = ${requestScope.orga};
            $(function () {
                var sel = $("#orga");
                $.ajax({
                    type: "get",
                    url: "getOrgan.action",
                    dataType: "json",
                    success: function (data) {
                        $.each(data.organs, function (index, o) {
                            sel.append("<option value='" + o.orgaId + "'>" + o.orgaName + "</option>")
                        });

                        $("option[value='" + sex + "']").attr("selected", "selected");
                        $("option[value='" + orga + "']").attr("selected", "selected");
                    }
                })
            })
        </script>
</body>
</html>
