<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>打印乘法表</title>
    
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
    <%!
    	String printCFB(){
    		String str = "";
    		for(int i = 1;i<=9;i++){
    			for(int j = 1;j<=i;j++){
    				//最后是打印三个空格
    				str += i+"*"+j+"="+(i*j)+"&nbsp;&nbsp;&nbsp;";
    			}
    			str += "<br>";
    		}
    		return str;
    	}
    	//利用脚本方式打印
    	void printCFB1(JspWriter out) throws Exception{
    		
    		for(int i = 1;i<=9;i++){
    			for(int j = 1;j<=i;j++){
    				//最后是打印三个空格
    				out.println(i+"*"+j+"="+(i*j)+"&nbsp;&nbsp;&nbsp;");
    			}
    			out.println("<br>");
    		}
    	}
     %>
     <h1>打印乘法表</h1>
     <%=printCFB() %>
     <h1>第二种方式</h1>
     <% printCFB1(out); %>
  </body>
</html>
