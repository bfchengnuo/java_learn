<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>OUT内置对象</title>
    
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
    <%
    	out.println("<h1>loli</h1>");
    	out.println("第一行啊啊啊<br>");
    	out.flush();
    	//out.clear(); 写在flush后面会抛异常
    	out.clearBuffer();//不会抛异常
    	out.println("第二行啊啊啊<br>");
    	out.println("第三行啊啊啊<br>");
     %>
     <!-- 使用引用变量标签，不加分号结尾 -->
      缓冲区的大小：<%= out.getBufferSize() %> <br>
     缓冲区剩余大小：<%= out.getRemaining() %> <br>
     是否自动清空：<%= out.isAutoFlush() %> <br>
  </body>
</html>
