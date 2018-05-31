package com.bfchengnuo.dao;

import com.bfchengnuo.factory.SF;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/5/30.
 */
public class EmpDaoImpl<T> implements EmpDao<T> {
    private Session session = null;
    private Transaction tx = null;

    @Override
    public void add(T emp) {
        try {
            session = SF.getSession();
            tx = session.beginTransaction();
            session.save(emp);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void del(T emp) {
        try {
            session = SF.getSession();
            tx = session.beginTransaction();
            session.delete(emp);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delEmpById(int id) {
        try {
            session = SF.getSession();
            tx = session.beginTransaction();
            String hql = "delete from Employee where empId=?";
            Query query = session.createQuery(hql);
            query.setInteger(0, id);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(T emp) {
        try {
            session = SF.getSession();
            tx = session.beginTransaction();
            session.update(emp);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public T queryById(Class<T> cls, Integer id) {
        try {
            session = SF.getSession();
            tx = session.beginTransaction();
            T t = (T) session.get(cls, id);
            tx.commit();
            return t;
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<T> queryAll(Class<T> cls) {
        try {
            session = SF.getSession();
            tx = session.beginTransaction();
            String hql = "from " + cls.getName();
            Query query = session.createQuery(hql);
            List<T> list = query.list();
            tx.commit();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<T> querySome(Class<T> cls, String name, int start, int max) {
        try {
            session = SF.getSession();
            tx = session.beginTransaction();
            String hql = "from " + cls.getName() + " where 1=1";
            if (name != null) {
                hql += " and empName like '%" + name + "%'";
            }
            Query query = session.createQuery(hql);
            query.setFirstResult(start);
            query.setMaxResults(max);
            List<T> list = query.list();
            tx.commit();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Integer querySomeCount(Class<T> cls, String name) {
        try {
            session = SF.getSession();
            tx = session.beginTransaction();
            String hql = "select count(*) from " + cls.getName() + " where 1=1";
            if (name != null) {
                hql += " and empName like '%" + name + "%'";
            }
            Query query = session.createQuery(hql);
            String count = query.uniqueResult().toString();
            tx.commit();
            return Integer.valueOf(count);
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return 0;
    }
}
