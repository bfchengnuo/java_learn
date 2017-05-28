package cn.itcast.web.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		

		final HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		request.setCharacterEncoding("UTF-8");   //post  get   request.getParameter()
		
		//servlet----> requestProxy.getCookie requestProxy.get
		chain.doFilter((ServletRequest) Proxy.newProxyInstance(CharacterEncodingFilter.class.getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if(!method.getName().equals("getParameter")){
					return method.invoke(request, args);
				}
				if(!request.getMethod().equalsIgnoreCase("get")){
					return method.invoke(request, args);
				}
				
				String value = (String) method.invoke(request, args);
				if(value==null){
					return null;
				}
				
				
				return new String(value.getBytes("iso8859-1"),"UTF-8");
			}
			
		}), response);
	}
	

	public void destroy() {
		// TODO Auto-generated method stub

	}

	

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
