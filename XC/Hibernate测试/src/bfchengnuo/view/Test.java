package com.bfchengnuo.view;

import com.bfchengnuo.domain.Message;
import com.bfchengnuo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by 冰封承諾Andy on 2017/7/8.
 * 测试注解？
 */
public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();

        Message message = new Message();
        // message.setId(1);  // 如果使用了主键生成策略就别指定 id 了
        message.setMsg("我是一条消息");
        message.setName("Loli");
        session.save(message);

        // Message msg = session.load(Message.class,1);
        // System.out.println(msg.getName() +"---"+ msg.getMsg());

        transaction.commit();
        session.close();
        System.exit(0);
    }
}
