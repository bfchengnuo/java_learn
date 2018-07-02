<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action=" ${ pageContext.request.contextPath }/goods/add" method="post">
		商品名称： <input type="text" name="name" />
		<br />
		商品价格： <input type="number" name="price" />
		<br />
		<input type="submit" value="提交" />
	</form>
</body>
</html>