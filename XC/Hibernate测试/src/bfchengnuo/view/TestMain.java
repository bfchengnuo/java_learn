package com.bfchengnuo.view;

import com.bfchengnuo.domain.User;
import com.bfchengnuo.util.HibernateUtil;
import com.bfchengnuo.util.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/6/28.
 * 虚拟测试，当作是界面类了
 */
public class TestMain {

    public static void main(String[] args) {
        // addUser();
        // updateUser();
        // delUser();
        // queryUser();
        // pageQuery(3);

        parameterBind2();


        System.exit(0);
    }

    // 分页查询；超出不会报错，会返回空
    private static void pageQuery(int pageSize) {
        // int pageNow = 1;
        int pageCount = 1; // 需要计算，每页有多少
        int rowCount = 1; // 一共多少条数据，需要查数据库
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getCurrentSession();
            transaction = session.beginTransaction();

            // 查询出 rowCount；因为知道返回的一定是一条数据，可以使用 uniqueResult ;这样返回的就是对象而不是 List
            rowCount = Integer.parseInt(session.createQuery("select count(*) from User").uniqueResult().toString());
            // 计算 pageCount
            pageCount = (rowCount-1)/pageSize + 1;

            // 循环取出每一页
            for (int i = 1; i <= pageSize; i++) {
                System.out.println("**********第" + i + "页**********");
                List<User> list = session.createQuery("from User ").setFirstResult((i-1)*pageCount).setMaxResults(pageCount).list();
                for (User user : list) {
                    System.out.println(user.getName() + "----" + user.getAge());
                }
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    // 参数绑定 1
    private static void parameterBind() {
        Session session = HibernateUtil.openSession();
        // :xxx 形式，xxx 是自定义的，一般和前面保持一致
        Query query = session.createQuery("from User where id=:id")
                .setParameter("id",1);
        // query.executeUpdate();  执行更新、删除操作
        // 可以使用泛型，会被自动封装
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user.getName() + "---" + user.getAge());
        }
    }

    // 参数绑定 2
    private static void parameterBind2() {
        Session session = HibernateUtil.openSession();
        // 和 JDBC 中保存一致，使用 ？ 占位符
        Query query = session.createQuery("from User where id=?")
                .setParameter(0,1);
        // 可以使用泛型，会被自动封装
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user.getName() + "---" + user.getAge());
        }
    }

    // 简单的查找操作
    private static void queryUser() {
        Session session = HibernateUtil.openSession();
        // 获取 Query 引用，使用 hql 语句， User 是实体类名不是表名，id 是属性不是字段
        // id 位置也可以使用字段名，但是推荐使用属性
        Query query = session.createQuery("select distinct name from User where id=1");
        // 可以使用泛型，会被自动封装
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user.getName() + "---" + user.getAge());
        }
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
        // session.get(User.class,1); 使用 get
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
