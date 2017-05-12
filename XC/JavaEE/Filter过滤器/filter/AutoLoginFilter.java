package filter;

import com.bfchengnuo.domain.User;
import com.bfchengnuo.service.BusinessService;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 冰封承諾Andy on 5/12/2017.
 * 自动登陆的过滤器
 */
@WebFilter(filterName = "mAutoLoginFilter", urlPatterns = "/*")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 1.先检查用户是否已经登陆
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            // 用户已经是登陆状态，放行
            chain.doFilter(request, response);
            return;
        }

        // 2.没登了，执行自动登陆的逻辑

        // 获取用户携带的 cookie
        Cookie autoLoginCookie = null;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("autologin")) {
                autoLoginCookie = cookies[i];
            }
        }
        // 如果没有携带 Cookie 可能是第一次登陆，放行
        if (autoLoginCookie == null) {
            chain.doFilter(request, response);
            return;
        }

        // 用户携带了自动登陆的 Cookie ，然后判断有效期
        String[] split = autoLoginCookie.getValue().split(":");
        // 如果长度不为 3 说明被修改过，直接放行，不执行登陆
        if (split.length != 3) {
            chain.doFilter(request, response);
        }

        long expiresTime = Long.parseLong(split[1]);
        // 如果 cookie 有效期到了，放行，不执行登陆
        if (System.currentTimeMillis() > expiresTime) {
            chain.doFilter(request, response);
            return;
        }

        // 时间有效，判断 cookie 的有效性
        String name = split[0];
        String client_md5 = split[2];

        // 根据 cookie 带的用户名，获取到用户数据
        BusinessService businessService = new BusinessService();
        user = businessService.find(name);
        // 校验 cookie 里的加密内容的合法性
        String server_md5 = md5(user.getUsername(), user.getPwd(), expiresTime);
        if (!client_md5.equals(server_md5)) {
            // 不合法，放行,不执行登陆
            chain.doFilter(request, response);
            return;
        }

        // 执行自动登陆逻辑
        request.getSession().setAttribute("user",user);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    /**
     * 将 cookie 进行 md5 加密，然后用 base64 编码返回
     * cookie 的格式确定  name:pwd:time
     * 应该抽取到工具类中，这里懒得搞了
     *
     * @param username 用户名
     * @param pwd      密码
     * @param time     失效时间
     * @return 加密后的字串
     */
    private String md5(String username, String pwd, long time) {
        String value = username + ":" + pwd + ":" + time;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] digest = md.digest(value.getBytes());
            // 进行 Base64 编码，防止出现乱码
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
