package com.mate.trackq.service;

import com.mate.trackq.dao.UserDao;
import com.mate.trackq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void confirmEmail(String hashedEmail) {
        userDao.confirmEmail(hashedEmail);
    }

    @Override
    public void resetPassword(User user) {
        userDao.resetPassword(user);
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
