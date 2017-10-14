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
    public void confirmEmail(String id) {
        userDao.confirmEmail(id);
    }

    @Override
    public void resetPassword(User user) {
        userDao.resetPassword(user);
    }
}
