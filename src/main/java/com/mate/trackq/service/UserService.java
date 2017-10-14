package com.mate.trackq.service;

public interface UserService {
    void confirmPassword(String id);

    void sendInvitation(String email);
}
