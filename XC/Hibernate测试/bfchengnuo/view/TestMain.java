package com.bfchengnuo.view;

import com.bfchengnuo.domain.User;
import com.bfchengnuo.util.MySessionFactory;
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
        // addUser();
        // updateUser();
        // delUser();


    }

    // 删除用户
    private static void delUser() {
        Session session = MySessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            // 删除也是先查找，后删除
            User user = session.load(User.class,3);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (transaction != null && session.isOpen()) {
                session.close();
            }
        }
    }

    // 更新用户
    private static void updateUser() {
        // 获取一个会话
        Session session = MySessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        // 修改用户信息的步骤一般是：1.查询  2.修改
        // load 方法是通过主键属性获取该对象的实例，和数据表中的记录相对应
        User user = session.load(User.class,1);
        user.setName("凝萱"); // 自动进行 update
        transaction.commit();
        session.close();
    }

    // 添加一个用户
    private static void addUser() {
        // 1. 创建 Configuration，用来读取配置文件，并完成初始化
        // 如果文件名没按照规范，可以手动指定
        Configuration configuration = new Configuration().configure();

        // 2. 创建 SessionFactory 会话工厂，重量级，耗资源，最好要保证只有一个
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
