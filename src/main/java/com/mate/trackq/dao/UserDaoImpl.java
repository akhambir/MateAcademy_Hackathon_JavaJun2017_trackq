package com.mate.trackq.dao;

import com.mate.trackq.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User where username=:username")
                .setParameter("username", username)
                .uniqueResult();
    }

    @Override
    public User create(User user) {
        sessionFactory.getCurrentSession().persist(user);
        return user;
    }

    @Override
    public void resetPassword(User user) {

    }
}
