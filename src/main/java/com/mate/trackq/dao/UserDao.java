package com.mate.trackq.dao;

import com.mate.trackq.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User findById(Long id);

    User findByUsername(String username);

    User create(User user);
}