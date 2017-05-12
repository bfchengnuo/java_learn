package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 冰封承諾Andy on 5/11/2017.
 * 全局过滤器
 */
public class MainFilter implements Filter {
    private FilterConfig mConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        mConfig = filterConfig;
        System.out.println("初始化成功！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 设置统一的编码
        String charset = mConfig.getInitParameter("charset");
        if (charset.isEmpty())
            charset = "utf-8";

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        req.setCharacterEncoding(charset);
        // 下面两句是设置输出的编码，不设置也可以，因为一般不会在 Servlet 中进行输出，而是跳到 JSP 进行输出
        resp.setCharacterEncoding(charset);
        resp.setContentType("text/html;charset=UTF-8");

        // 放行
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("关闭....");
    }
}
