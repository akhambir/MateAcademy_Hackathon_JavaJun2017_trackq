package com.mate.trackq.service;

import com.mate.trackq.model.User;

public interface UserService {
    void confirmPassword(String id);

    void sendInvitation(String email);

    User findByEmail(String email);

    void create(User user);
}
