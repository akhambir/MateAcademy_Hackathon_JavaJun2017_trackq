package com.mate.trackq.service;

import com.mate.trackq.model.User;

public interface UserService {
    void confirmEmail(String id);

    void resetPassword(User user);
}
