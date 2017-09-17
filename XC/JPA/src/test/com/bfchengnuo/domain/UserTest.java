package test.com.bfchengnuo.domain;

import com.bfchengnuo.domain.Order;
import com.bfchengnuo.domain.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by 冰封承諾Andy on 2017/8/17.
 *
 * 一对多/多对一 测试用例
 * 以用户和订单的关系为例
 */
public class UserTest {

    @Test
    public void save() {
        // 这句话执行后就会创建相应的表，前提是配置了相关配置（auto）;相当于 SessionFactory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        // 开启事务
        em.getTransaction().begin();

        User user = new User();
        user.setName("佳芷");
        user.setId(123);

        Order order1 = new Order();
        order1.setOrderName("测试项1");
        Order order2 = new Order();
        order2.setOrderName("测试项2");
        user.addItem(order1);
        user.addItem(order2);

        em.persist(user);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    @Test
    public void select() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();

        User user = em.find(User.class, 123);
        System.out.println(user.getName());

        em.close();
        factory.close();
    }
}
