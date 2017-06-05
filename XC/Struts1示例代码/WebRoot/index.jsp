<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <a href="${pageContext.request.contextPath }/registerUI.do">注册</a>
    <br/><br/>
    
    在超链接后面带一个参数
    <% 
    	request.setAttribute("name","aaa");
    %>	
    <html:link action="/registerUI" paramId="name" paramName="name">注册</html:link>
     <br/><br/>
    
     在超链接后面带多个参数
    <%	
    	Map map = new HashMap();
    	map.put("name","aaa");
    	map.put("password","123");
    	request.setAttribute("map",map);
    %>
    
    
    <html:link action="/registerUI" name="map">注册</html:link>
    
     <br/><br/>
     
     
    <html:link action="/bookAction?method=add">增加书籍</html:link>
   	<html:link action="/bookAction?method=update">修改书籍</html:link>
  	<html:link action="/bookAction?method=find">查找书籍</html:link>   	
	<html:link action="/bookAction?method=delete">删除书籍</html:link>
     <br/><br/>
     
    <html:link action="/addbook">增加书籍</html:link>
   	<html:link action="/updatebook">修改书籍</html:link>
  	<html:link action="/findbook">查找书籍</html:link>   	
	<html:link action="/deletebook">删除书籍</html:link>
      
     
  </body>
</html>
