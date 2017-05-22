package web.listener;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ListIterator;
import java.util.TimerTask;

/**
 * Created by 冰封承諾Andy on 5/19/2017.
 * 要执行的任务类
 * 每 5 分钟遍历一次，找出不活跃的 删除掉
 */
public class MyTask extends TimerTask {
    private List<HttpSession> mSessionList;
    // 加锁是为了避免在遍历的时候，那边往 List 插入 Session
    private Object lock;

    public MyTask(List<HttpSession> sessionList, Object lock) {
        mSessionList = sessionList;
        this.lock = lock;
    }

    @Override
    public void run() {
        // 因为是链表结构，只能使用迭代器迭代
        // 使用 ListIterator 可以在迭代的过程中实现删除，而不会出现并发修改错误
        synchronized (lock) {
            System.out.println("定时器开启...");
            ListIterator<HttpSession> iterator = mSessionList.listIterator();
            while (iterator.hasNext()) {
                HttpSession session = iterator.next();
                // 当前时间 - Session 的最后访问时间；如果一分钟没有活跃 就移除
                if (System.currentTimeMillis() - session.getLastAccessedTime() >= 60 * 1000) {
                    session.invalidate(); // 销毁 Session
                    iterator.remove();
                }
            }
        }
        // mSessionList.removeIf(session -> System.currentTimeMillis() - session.getLastAccessedTime() >= 60 * 1000);
    }
}
