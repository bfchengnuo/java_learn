package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 冰封承諾Andy on 5/11/2017.
 * 控制缓存的过滤器
 */
@WebFilter(filterName = "mCacheFilter",
        urlPatterns = {"*.jpg", "*.png", "*.css", "*.js"},
        initParams = {
                @WebInitParam(name = "jpg", value = "10"),
                @WebInitParam(name = "css", value = "10"),
                @WebInitParam(name = "js", value = "10")
        })
public class CacheFilter implements javax.servlet.Filter {
    private FilterConfig mConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        // 获取到用户访问的资源
        String uri = req.getRequestURI();
        // 获取资源的缓存时间
        int expires = 0;
        if (uri.endsWith(".jpg")) {
            expires = Integer.parseInt(this.mConfig.getInitParameter("jpg"));
        } else if (uri.endsWith(".js")) {
            expires = Integer.parseInt(this.mConfig.getInitParameter("js"));
        } else if (uri.endsWith(".css")) {
            expires = Integer.parseInt(this.mConfig.getInitParameter("css"));
        }
        // 设置缓存时间，注意格式
        resp.setDateHeader("expires", System.currentTimeMillis() + expires * 60 * 1000);

        // 放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        mConfig = config;
    }

}
