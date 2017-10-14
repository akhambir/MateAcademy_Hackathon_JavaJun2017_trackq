package com.mate.trackq.service;

import com.mate.trackq.dao.UserDao;
import com.mate.trackq.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void confirmPassword(String id) {

    }

    @Override
    public void sendInvitation(String email) {

    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }
}
