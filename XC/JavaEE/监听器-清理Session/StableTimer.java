package web.listener;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 冰封承諾Andy on 5/19/2017.
 * 定时执行任务
 */
public class StableTimer {
    private void test() {
        Timer timer = new Timer();
        // 设定日期
        Calendar calendar = Calendar.getInstance();
        // 月份是从 0 开始的
        calendar.set(2017, Calendar.MAY,19,18,35);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行了.....");
            }
        },calendar.getTime());
    }
}
