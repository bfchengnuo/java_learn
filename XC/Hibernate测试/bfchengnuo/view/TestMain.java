package com.bfchengnuo.view;

import com.bfchengnuo.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by 冰封承諾Andy on 2017/6/28.
 * 虚拟测试，当作是界面类了
 */
public class TestMain {
    public static void main(String[] args) {
        // 1. 创建 Configuration，用来读取配置文件，并完成初始化
        // 如果文件名没按照规范，可以手动指定
        Configuration configuration = new Configuration().configure();

        // 2. 创建 SessionFactory 会话工厂，很重要，要保证只有一个
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // 3. 创建会话（Session），相当于 JDBC 中的 connection
        Session session = sessionFactory.openSession();

        // 4. 开启事务，对 Hibernate 而言，要求程序猿在进行 增删改 的时候使用事务
        Transaction transaction = session.beginTransaction();

        // 添加一条数据
        User user = new User();
        user.setName("佳芷");
        user.setAge(12);
        user.setEmail("loli@163.com");
        user.setHiredate(new Date());

        session.save(user);
        transaction.commit();
        session.close();
    }
}
