package web.listener;
/**
 * Created by 冰封承諾Andy on 5/19/2017.
 * 自动扫描 Session 是否过期，然后自动清理
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

@WebListener()
public class SessionScannerListener implements HttpSessionListener, ServletContextListener {
    // 涉及到频繁操作使用链表结构
    private List<HttpSession> mSessionList = new LinkedList<>();
    private final Object lock = new Object(); // 加锁，避免并发出现

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Context 只创建一次，在这里开启人物
        Timer timer = new Timer();
        timer.schedule(new MyTask(mSessionList,lock),0,5*60*1000); // 每 5 分钟执行一次
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        synchronized (lock) {
            mSessionList.add(session);
        }
        System.out.println("Session 创建了！！");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session 销毁了！！");
    }
}
