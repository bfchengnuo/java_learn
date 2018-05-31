<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2018/5/30
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息</title>
</head>
<body>

    <div style="width: 600px;margin: 0 auto;">
        姓名： <input id="name" type="text" name="name">
        <button onclick="querySome()">查询</button>
        <button onclick="window.location.href='addEmployee.jsp'">添加</button>
        <button onclick="toUpdate()">修改</button>
        <button onclick="delSelect()">删除</button>

    </div>
    <hr>
    <table border="1px" cellspacing="0" style="width: 600px;margin: 0 auto;">
        <thead>
        <tr>
            <th>
                <input type="checkbox" id="checkAll" onclick="checkedAll(this.checked)">
                <label for="checkAll">全选</label>
            </th>
            <th>序号</th>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>所属机构名称</th>
            <th>性别</th>
            <th>年龄</th>
        </tr>
        </thead>

        <tbody style="text-align: center;" id="tb"></tbody>
    </table>

    <div style="width: 600px;margin: 0 auto;">
        <button onclick="change('first')">首页</button>
        <button onclick="change('pre')">上一页</button>
        <button onclick="change('next')">下一页</button>
        <button onclick="change('last')">尾页</button>
    </div>

    <script src="../js/jquery-1.10.2.js"></script>
    <script>
        var tj = "";
        var pageNumber;
        var total;
        var pageCount;
        var next;
        var pre;

        $(function () {
            show(1);
        });

        function show(page) {
            $.ajax({
                type: "get",
                url: "getEmp.action",
                data: "pageNumber=" + page + tj,
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    var tb = $("tbody#tb");
                    tb.html('');
                    pageNumber = data.page.pageNumber;
                    total = data.page.total;
                    pageCount = data.page.pageCount;
                    next = data.page.next;
                    pre = data.page.pre;

                    $.each(data.page.rows, function (index, e) {
                        var tr = $("<tr></tr>");
                        tr.append('<td><input value="' + e.empId + '" type="checkbox"></td>');
                        tr.append('<td>' + (data.page.start + index + 1) + '</td>');
                        tr.append('<td>' + e.empCode + '</td>>');
                        tr.append('<td>' + e.empName + '</td>>');
                        tr.append('<td>' + e.organizationByOrgaId.orgaName + '</td>>');
                        tr.append('<td>' + e.sex + '</td>>');
                        tr.append('<td>' + e.age + '</td>>');

                        tb.append(tr);
                    });

                    tb.append("<tr><td colspan='7'>共" + total + "条数据；当前第" +
                        pageNumber + "页，共" + pageCount + "页</td></tr>");

                    flushBtn();
                }
            })
        }

        function delSelect() {
            var para = [];
            var secs = $('table td input:checked');
            if (secs.length === 0) {
                alert('您没选择任何项！');
                return;
            }
            $.each(secs, function (index, e) {
                para.push('id=' + e.value);
                para.push('&');
            });
            para.pop();
            para = para.join('').toString();
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/delEmp.action",
                data: para,
                success: function (data) {
                    show(pageNumber);
                    checkedAll(false);
                }
            })
        }
        
        function toUpdate() {
            var secs = $('table td input:checked');
            if (secs.length === 0) {
                alert('您没选择任何项！');
                return;
            }
            if (secs.length !== 1) {
                alert('您选择了多项！');
                return;
            }
            window.location.href = "${pageContext.request.contextPath}/toUpdateEmp.action?pageNumber=" + pageNumber + "&id=" + secs[0].value;
        }

        function change(flag) {
            switch (flag) {
                case 'first':
                    show(1);
                    break;
                case 'pre':
                    show(pre);
                    break;
                case 'next':
                    show(next);
                    break;
                case 'last':
                    show(pageCount);
                    break;
                default:
                    show(1);
            }
        }

        function flushBtn() {
            var btns = $('button:contains("页")');
            btns.removeAttr("disabled");
            if (pageNumber === 1) {
                btns[0].disabled = true;
                btns[1].disabled = true;
            } else if (pageNumber === pageCount) {
                btns[2].disabled = true;
                btns[3].disabled = true;
            }
        }

        function querySome() {
            tj = "";
            var name = $("input#name").val();
            if (name !== null && name.length !== 0) {
                tj += "&name=" + name;
            }

            show(1);
        }

        function checkedAll(flag) {
            if (flag) {
                $(":checkbox").prop("checked", "true");
            } else {
                $(":checkbox").removeAttr("checked");
            }
        }
    </script>
</body>
</html>
