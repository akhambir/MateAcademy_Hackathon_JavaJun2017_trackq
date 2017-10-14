package com.mate.trackq.service;

import com.mate.trackq.model.User;

public interface MailService {
    void sendConfirmRegistrationEmail(User user, String hostname);
    void sendNewPasswordEmail(User user);
    void sendSimpleEmail(User user);
    void sendInviteInProject(User user);
}
