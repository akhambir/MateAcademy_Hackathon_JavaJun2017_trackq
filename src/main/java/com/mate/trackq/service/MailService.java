package com.mate.trackq.service;

import com.mate.trackq.model.User;

public interface MailService {
    void sendConfirmRegistrationEmail(User user, String hostname);
    void sendNewPasswordEmail(String email, String hostname);
    void sendInviteInProject(String email, Integer projectId, String hostname);
}
