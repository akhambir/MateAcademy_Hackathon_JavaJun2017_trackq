package com.mate.trackq.dao;

import com.mate.trackq.model.User;

public interface UserDao {

    User findById(Long id);

    User findByUsername(String username);

    User create(User user);

    void resetPassword(User user);
}