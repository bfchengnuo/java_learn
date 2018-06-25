<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hans">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<form id="user-form">
		用户名： <input type="text" name="username" /> <br />
		密码： <input type="password" name="password" /> <br />
		昵称： <input type="text" name="nickname" /> <br />
		邮箱： <input type="email" name="email" /> <br />
		联系方式： <input type="number" name="tel" /> <br />
		状态： <select name="state">
			<option value="0">冻结</option>
			<option value="1" selected="selected">启用</option>
		</select>
		<br />
		
		<input type="button"  value="提交" onclick="add()"/>
		
	</form>
	
	<script type="text/javascript" src="${ pageContext.request.contextPath }/skin/js/commons/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		function add() {
			$.ajax({
				url: '${ pageContext.request.contextPath }/user/add',
				type: 'post',
				data: $('#user-form').serialize(),
				dataType: 'json',
				success: function (data) {
					if(data.code === 200){
						alert(data.msg);
					}
				}
			});
		}
	</script>
</body>
</html>