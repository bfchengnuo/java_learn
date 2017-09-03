package com.bfchengnuo.serviceImpl;

import com.bfchengnuo.entity.UsersEntity;
import com.bfchengnuo.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/8/31.
 * 省略 dao 层了，所以 sessionFactory 就写在这里了
 */
@Transactional
public class UserServiceImpl implements UserService {
    private SessionFactory sessionFactory;

    @Override
    public void save(UsersEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(UsersEntity entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public UsersEntity find(String userName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UsersEntity where name=?").setParameter(0, userName);
        return (UsersEntity) query.uniqueResult();
    }

    @Override
    public void delete(String... userName) {
        for (String s : userName) {
            Object o = sessionFactory.getCurrentSession().createQuery("from UsersEntity where name=?").setParameter(0, s).uniqueResult();
            sessionFactory.getCurrentSession().remove(o);
        }
    }

    @Override
    // @SuppressWarnings("unchecked")
    // @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<UsersEntity> list() {
        return (List<UsersEntity>) sessionFactory.getCurrentSession().createQuery("from UsersEntity").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
