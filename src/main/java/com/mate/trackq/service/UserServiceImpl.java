package com.mate.trackq.service;

import com.mate.trackq.dao.UserDao;
import com.mate.trackq.exception.EmailExistsException;
import com.mate.trackq.exception.UsernameExistsException;
import com.mate.trackq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void confirmEmail(String hashedEmail) {
        userDao.confirmEmail(hashedEmail);
    }

    @Override
    public void resetPassword(User user) {
        userDao.resetPassword(user);
    }

    @Override
    public User create(User user) throws UsernameExistsException, EmailExistsException {
        if (usernameExists(user.getUsername())) {
            throw new UsernameExistsException();
        }
        if (emailExists(user.getEmail())) {
            throw new EmailExistsException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.create(user);
    }

    @Override
    public boolean usernameExists(String username) {
        return userDao.findByUsername(username) != null;
    }

    @Override
    public boolean emailExists(String email) {
        return userDao.findByEmail(email) != null;
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
