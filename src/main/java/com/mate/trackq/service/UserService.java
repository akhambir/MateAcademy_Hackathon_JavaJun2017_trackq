package com.mate.trackq.service;

import com.mate.trackq.exception.EmailExistsException;
import com.mate.trackq.exception.UsernameExistsException;
import com.mate.trackq.model.User;

public interface UserService {

    User addNewUser(User user) throws UsernameExistsException, EmailExistsException;

    boolean usernameExists(String username);

    boolean emailExists(String email);

    boolean confirmEmail(String hashedEmail, Long id);

    void resetPassword(User user);

    User findByEmail(String email);

    void sendConfirmationEmail(User user, String serverName);

}
