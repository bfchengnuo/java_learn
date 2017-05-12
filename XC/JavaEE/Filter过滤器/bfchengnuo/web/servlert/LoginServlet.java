package com.bfchengnuo.web.servlert;

import com.bfchengnuo.domain.User;
import com.bfchengnuo.service.BusinessService;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 冰封承諾Andy on 5/12/2017.
 * 过滤器演示，登陆界面处理
 */
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        BusinessService service = new BusinessService();
        User user = service.login(username, pwd);
        if (user == null) {
            request.setAttribute("msg", "密码错误，登陆失败！");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("user", user);
        Cookie cookie = makeCookie(user, Integer.parseInt(request.getParameter("autologin")));

        response.addCookie(cookie);
        response.sendRedirect("/JavaWeb/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 产生 Cookie 值要经过处理
     *
     * @param user 用户实体
     * @param time 过期时间
     * @return 返回做好的 Cookie
     */
    private Cookie makeCookie(User user, int time) {
        // 具体的 cookie 的值，用户名、时间、以及加密后的字串
        String cookieValue = user.getUsername() + ":" + (System.currentTimeMillis() + time * 1000) +
                ":" + md5(user.getUsername(), user.getPwd(), System.currentTimeMillis() + time * 1000);
        Cookie cookie = new Cookie("autologin", cookieValue);
        // 设置有效期
        cookie.setMaxAge(time);
        cookie.setPath("/JavaWeb");
        return cookie;
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
