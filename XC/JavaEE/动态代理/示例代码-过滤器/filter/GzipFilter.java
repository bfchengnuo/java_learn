package cn.itcast.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GzipFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) resp;
		
		ResponseProxy proxy = new ResponseProxy(response);
		chain.doFilter(request, proxy.createProxy());   //ResponseProxy.get...
		
		byte[] out = proxy.getBuffer();  //得到目标资源的输出
		
		System.out.println(new String(out,"UTF-8"));
		
		
	}
	
	class ResponseProxy{
		private ByteArrayOutputStream bout = new ByteArrayOutputStream();
		private PrintWriter pw = null;
		
		public byte[] getBuffer(){
			if(pw!=null){
				pw.close();
			}
			return bout.toByteArray();
		}
		
		
		private HttpServletResponse response;
		public ResponseProxy(HttpServletResponse response){
			this.response = response;
		}
		public HttpServletResponse createProxy(){
			return (HttpServletResponse) Proxy.newProxyInstance(GzipFilter.class.getClassLoader(), response.getClass().getInterfaces(), new InvocationHandler(){
				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					if(!method.getName().equals("getWriter") && !method.getName().equals("getOutputStream")){
						method.invoke(response, args);
					}
					
					if(method.getName().equals("getWriter")){   //PrintWriter.write("中国");
						pw = new PrintWriter(new OutputStreamWriter(bout,"UTF-8"));
						return pw;
					}
					
					if(method.getName().equals("getOutputStream")){   //ServletOutputSttream.write()
						return new ServletOutputStream(){
							@Override
							public void write(int b) throws IOException {
								bout.write(b);
							}
						};
					}
					return null;
				}
			});
		}
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
