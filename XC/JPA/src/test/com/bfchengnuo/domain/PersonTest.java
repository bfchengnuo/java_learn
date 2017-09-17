package test.com.bfchengnuo.domain;


import com.bfchengnuo.domain.Person;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Person Tester.
 *
 * JPA 入门测试栗子
 * 进行简单的 CRUD 操作，以及 JPQL 的使用
 * 只用到了一个实体类：Person
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

    @Test
    public void select() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();

        // 相当于 hibernate 中的 get
        // Person person = em.find(Person.class, 1);
        // 相当于 hibernate 中的 load ，延迟加载
        Person person = em.getReference(Person.class, 1);
        System.out.println(person.getName());

        em.close();
        factory.close();
    }

    @Test
    public void update() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Person person = em.find(Person.class, 1);
        // 托管状态下提交事务时修改会自动更新到数据库
        person.setName("沛凝");

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    @Test
    public void del() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Person person = em.find(Person.class, 3);
        em.remove(person);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    @Test
    public void jpqlTest() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        // 推荐使用指定结果集，这样就不用强转了
        TypedQuery<Person> query =
                em.createQuery("SELECT e FROM Person e where e.id=?",
                        Person.class); // 指定索引从0开始： ?0
        query.setParameter(0,1);
        // 获取单个数据，第一条
        Person singleResult = query.getSingleResult();
        System.out.println(singleResult.getName());
        // 获取全部的数据集
        // List<Person> list = query.getResultList();

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

} 
