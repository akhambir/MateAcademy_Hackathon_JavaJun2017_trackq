package com.mate.trackq.dao;

import com.mate.trackq.model.User;
import com.mate.trackq.model.UserConfirmation;
import com.mate.trackq.util.DateUtils;
import com.mate.trackq.util.Hasher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

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
        UserConfirmation confirmation = new UserConfirmation();
        confirmation.setConfirmationID(Hasher.getSha256(user.getEmail()));
        confirmation.setTimestamp(DateUtils.addDay(new Timestamp(System.currentTimeMillis())));
        confirmation.setUser(user);
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public void resetPassword(User user) {

    }

    @Override
    public boolean confirmEmail(String hashedEmail, Long id) {
        UserConfirmation confirmation = sessionFactory.getCurrentSession().get(UserConfirmation.class, id);
        if(confirmation != null && hashedEmail.equals(confirmation.getConfirmationID())) {
            if(confirmation.getTimestamp().after(new Timestamp(System.currentTimeMillis()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByEmail(String email) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User where email=:email")
                .setParameter("email", email)
                .uniqueResult();
    }
}
