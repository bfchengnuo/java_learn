<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.struts.action.ActionErrors"%>
<%@page import="org.apache.struts.action.ActionMessage"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'register.jsp' starting page</title>
  </head>
  
  <body>
    
    <%  
    	/* 
    	ActionErrors errors = (ActionErrors)pageContext.findAttribute(&quot;org.apache.struts.action.ERROR&quot;); 
    	if(errors!=null){ 
    		Iterator it = errors.get(&quot;username&quot;); 
    		if(it.hasNext()){ 
    			ActionMessage message = (ActionMessage)it.next(); 
    			String info = message.getKey(); 
    			out.write(info); 
    		} 
    	} 
    	*/ 
    %>
   
    <form action="${pageContext.request.contextPath }/register.do" method="post">
    	用户名：<input type="text" name="username" value="${param.username }"> <html:errors property="username"/><br/>
    	密码：<input type="password" name="password" value="${param.password }"> <html:errors property="password"/><br/>
    	电子邮箱：<input type="text" name="email"><br/>
    	<input type="submit" value="注册">
    </form>
    
     <br/>

	<html:form action="/register" enctype="multipart/form-data">
		用户名：<html:text property="username"/><html:errors property="username"/><br/>
		密码：<html:password property="password"/><html:errors property="password"/><br/>
		电子邮箱：<html:text property="email"/><br/>
		大头照：<input type="file" name="file"><br/>
		<input type="submit" value="注册"><br/>
	</html:form>
    
    
    <br/>
    
    <html:javascript formName="register2Form"/>
    <html:errors/>
    
    <html:form action="/register2" onsubmit="return validateRegister2Form(this)">
    	用户名：<input type="text" name="username"> <br/>
    	密码：<input type="password" name="password"> <br/>
    	电子邮箱：<input type="text" name="email"><br/>
    	<input type="submit" value="注册">
    </html:form>
    
  </body>
</html>
