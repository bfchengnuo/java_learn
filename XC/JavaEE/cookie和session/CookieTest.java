package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by 冰封承諾Andy on 2017/3/28 0028.
 * cookie 存储相关
 */
@WebServlet(name = "CookieTest", value = "/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("上次访问时间：");  // 是一个字符流

        // 获取用户的cookie
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("time")){
                long time = Long.parseLong(cookies[i].getValue());
                Date date = new Date(time);
                writer.println(date.toLocaleString());
            }
        }

        // 设置新的 cookie
        Cookie cookie = new Cookie("time",System.currentTimeMillis()+"");
        cookie.setMaxAge(24*3600);  // 设置有效期 单位：秒  如果设为 0 表示清除，path一定要一致

        response.addCookie(cookie);
    }
}
