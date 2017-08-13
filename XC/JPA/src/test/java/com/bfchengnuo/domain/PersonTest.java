package test.java.com.bfchengnuo.domain;


import com.bfchengnuo.domain.Person;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Person Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>08/13/2017</pre>
 */
public class PersonTest {


    /**
     * Method: getId()
     */
    @Test
    public void save() throws Exception {
        // 这句话执行后就会创建相应的表，前提是配置了相关配置;相当于 SessionFactory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        // 开启事务
        em.getTransaction().begin();
        // 和 save 是一样的，只不过这个名字更规范
        em.persist(new Person("佳芷"));
        em.getTransaction().commit();
        em.close();
        factory.close();
    }



} 
