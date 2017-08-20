package test.com.bfchengnuo.domain;

import com.bfchengnuo.domain.Student;
import com.bfchengnuo.domain.Teacher;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Student Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>08/20/2017</pre>
 */
public class StudentTest {

    @Test
    public void save() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        // 开启事务
        em.getTransaction().begin();

        Student student = new Student("佳芷");
        Teacher teacher = new Teacher("冰封承諾");

        em.persist(student);
        em.persist(teacher);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    // 建立学生与老师之间的关系，也就是在中间表中添加记录
    // 只有关系维护端才有权利
    @Test
    public void buildBind() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        // 开启事务
        em.getTransaction().begin();

        Student student = em.find(Student.class, 1);
        student.getTeachers().add(em.getReference(Teacher.class, 1));
        // 解除关系的话
        // student.getTeachers().remove(em.getReference(Teacher.class, 1));

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    // 删除学生，会自动删除相关的“关系”
    // 如果是删除老师，没有权利删除关系，所以要先解除关系再删除
    @Test
    public void delStudent() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaDemo");
        EntityManager em = factory.createEntityManager();
        // 开启事务
        em.getTransaction().begin();

        Student student = em.find(Student.class, 1);

        em.remove(student);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

} 
