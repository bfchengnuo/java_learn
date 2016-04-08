<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>我的第一个网页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%!//这是Java的声明代码标签
	String name = "张三";

	//定义一个函数的示例
	int add(int a, int b) {
		return a + b;
	}%>
	<p>欢迎来到我的第一个网页</p>
	<!-- 引用变量的标签   -->
	你好，<%= name %>!
	<br>
	<%
	//标签写Java代码
	out.print("4+5="+add(4,5));
	 %>
</body>
</html>
