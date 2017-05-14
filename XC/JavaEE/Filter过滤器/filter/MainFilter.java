package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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

    /**
     * 使用装饰模式增强 Request 来真正解决乱码问题
     * 针对 Post 和 Get 方式分别进行处理
     */
    class MyRequest extends HttpServletRequestWrapper {
        HttpServletRequest mRequest;

        public MyRequest(HttpServletRequest request) {
            super(request);
            mRequest = request;
        }

        @Override
        public String getParameter(String name) {
            String value = mRequest.getParameter(name);
            // 非 Get 方式直接返回，不处理
            if (!mRequest.getMethod().equalsIgnoreCase("get")) {
                return value;
            }
            if (value == null) {
                return null;
            }

            try {
                return value = new String(value.getBytes("iso-8859-1"),mRequest.getCharacterEncoding());
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
