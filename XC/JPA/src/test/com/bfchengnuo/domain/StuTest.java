package test.com.bfchengnuo.domain;

import com.bfchengnuo.domain.Stu;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Stu Tester.
 *
 * 测试联合主键
 *      使用到的类为：Stu 和 StuPK
 */
public class StuTest {


    @Test
    public void testSetName() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Stu stu = new Stu("佳芷", 1, 12);

        em.persist(stu);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

} 
