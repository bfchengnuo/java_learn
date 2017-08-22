package test.com.bfchengnuo.domain;

import com.bfchengnuo.domain.Stu;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Stu Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>08/21/2017</pre>
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
