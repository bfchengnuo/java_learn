<%--
  Created by IntelliJ IDEA.
  User: 冰封承諾Andy
  Date: 2018/5/19
  Time: 9:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <form class="form-horizontal" role="form" method="post" action="addStu_stu.action">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">学生名字：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="name" name="stu.name" placeholder="输入学生名字">
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">学生年龄：</label>
            <div class="col-sm-5">
                <%--onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')"--%>
                <input type="text" class="form-control" id="age" name="stu.age" placeholder="输入学生年龄">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">邮箱：</label>
            <div class="col-sm-5">
                <input type="email" class="form-control" id="email" name="stu.email" placeholder="输入邮箱">
            </div>
        </div>
        <div class="form-group">
            <label for="date" class="col-sm-2 control-label">生日：</label>
            <div class="col-sm-5">
                <input type="date" class="form-control" id="date" name="stu.birth">
            </div>
        </div>
        <div class="form-group">
            <label for="sid" class="col-sm-2 control-label">学校：</label>
            <div class="col-sm-5">
                <select id="sid" class="form-control" name="stu.school.id"></select>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-5 text-center">
                <button type="submit" class="btn btn-default">添加</button>
            </div>
        </div>

    </form>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/querySchool",
                dataType: "json",
                success: function (data) {
                    var $sel = $("select#sid");
                    $.each(data, function (index, e) {
                        var opt1 = $("<option></option>");
                        var opt2 = $("<option></option>");
                        opt1.val(e.id).text(e.name);
                        opt2.val(e.id).text(e.name);
                        $sel.append(opt1);
                    });
                }
            })
        });

        function submit2ajax() {
            // var $form = $("form").serializeArray();
            var  data = new FormData($("form")[0]);
            $.ajax({
                type: "post",
                url: "BookServlet",
                data: data,
                cache: false,
                processData: false,
                contentType: false,
                success: function (data) {
                    $("span#msg").text(data);
                    clear();
                }

            })
        }

        function clear() {
            $("form")[0].reset();
            $("#pics").html('');
            i = 0;
        }
    </script>
</body>
</html>
