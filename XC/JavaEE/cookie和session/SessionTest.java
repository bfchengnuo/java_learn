package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by 冰封承諾Andy on 2017/3/28 0028.
 * Session 服务于没个会话，就是浏览器窗体，
 * 请求页面遇到 get 方法才会创建
 * 随 浏览器关闭而销毁，其实是一段时间不活跃后服务器自动销毁
 */
@WebServlet(name = "SessionTest", value = "/SessionTest")
public class SessionTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        // 还可以接受一个参数，表示没有的话是否创建
        // request.getSession(false);

        // session 域传递参数，数据存在服务器
        session.setAttribute("key","data");
        session.setAttribute("token","base64-md5");

        /*
          当浏览器禁用 Cookie 的时候，使用 URL 进行传输 Session ID
          第一次请求会返回一个带 SessionID 的URL，
          当检测到下一次请求带有Cookie的时候，表示Cookie没有被禁用，以后就不再更改URL
         */
        String strURL = response.encodeURL("/JavaWeb/xx");

        // session.invalidate();  手动销毁

        response.getWriter().println("lalalala");
    }

    private void getUID(){
        String uid = String.valueOf(UUID.randomUUID());
    }
}
