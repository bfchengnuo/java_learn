<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2018/6/5
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-table.css" rel="stylesheet"/>

</head>
<body>
    <%--查询区域--%>
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true"
                       aria-controls="collapseOne">
                        条件查询
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                <div class="panel-body">
                    <form class="form-inline" role="form">
                        <div class="form-group">
                            <label for="name">姓名：</label>
                            <input type="text" class="form-control" id="name" placeholder="请输入姓名">
                        </div>
                        <div class="form-group">
                            <label for="sid">所在学校：</label>
                            <select class="form-control" id="sid" name="sid"></select>
                        </div>
                        <%--type button 不会自动提交（我们使用异步）--%>
                        <button type="button" class="btn btn-primary" onclick="queryByPara()">搜索</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <table id="tb"></table>
    <%--<div style="height: 250px;">--%>
    <%--</div>--%>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-table-zh-CN.js"></script>

    <script>
        var tb;

        $(function () {
            queryData();
            querySchool();
        });

        function queryByPara() {
            tb.bootstrapTable("refresh");
        }

        function querySchool() {
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/querySchool",
                dataType: "json",
                success: function (data) {
                    var $sel = $("select#sid");
                    $sel.append("<option value='0'>===选择===</option>");
                    $.each(data, function (index, e) {
                        var opt1 = $("<option></option>");
                        var opt2 = $("<option></option>");
                        opt1.val(e.id).text(e.name);
                        opt2.val(e.id).text(e.name);
                        $sel.append(opt1);
                    });
                }
            })
        }

        var start = 0;

        function queryData() {
            tb = $("#tb").bootstrapTable({
                url: "querySome_stu.action",
                pagination: true, // 显示页码
                sidePagination: "server", // 真分页
                pageNumber: 1,
                pageSize: 4,
                striped: true,
                pageList: [4, 5, 6],
                queryParamsType: "undefined", // 不使用 limit 作为参数，从哪开始
                queryParams: function (params) {
                    var new_params = {
                        'page.pageNumber': params.pageNumber,
                        'page.pageSize': params.pageSize
                    };
                    // 组装条件
                    var name = $("#name").val();
                    var sid = $("#sid").val();
                    if (name != null || name.length !== 0) {
                        new_params.name = name;
                    }
                    if (sid != null || sid !== 0) {
                        new_params.sid = sid;
                    }

                    start = (params.pageNumber - 1) * params.pageSize;
                    return new_params;
                },
                columns: [{
                    title: "编号",
                    formatter: function (value, row, index) {
                        // console.log(row);
                        return start + index + 1;
                    }
                }, {
                    field: "name",
                    title: "学生姓名"
                }, {
                    field: "age",
                    title: "学生年龄"
                }, {
                    field: "birth",
                    title: "学生生日"
                }, {
                    field: "email",
                    title: "学生邮箱"
                }, {
                    field: "school.name",
                    title: "所在学校"
                }, {
                    field: "school.loc",
                    title: "学校地址"
                }, {
                    title: "操作",
                    formatter: function (val, row, index) {
                        var str = "<a href='javascript:void(0)' id='update'>更新</a>";
                        var str1 = "<a href='javascript:void(0)' id='del'>删除</a>";
                        // return str + " | " + str1;
                        return str1;
                    },
                    events: evn
                }]
            });
        }

        window.evn = {
            'click #del': function (event, value, row, index) {
                console.log(row);
                delStu(row.id);
            }
        }

        function delStu(sid) {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/delStu_stu.action",
                data: "id=" + sid,
                dataType: "json",
                success: function (data) {
                    if (data.flag === 'suc') {
                        tb.bootstrapTable("refresh");
                    }
                }
            })
        }
    </script>
</body>
</html>
