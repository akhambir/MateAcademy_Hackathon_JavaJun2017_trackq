package com.mate.trackq.service;

import com.mate.trackq.dao.RoleDao;
import com.mate.trackq.dao.UserDao;
import com.mate.trackq.exception.EmailExistsException;
import com.mate.trackq.exception.UsernameExistsException;
import com.mate.trackq.model.Role;
import com.mate.trackq.model.User;
import com.mate.trackq.util.Hasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private MailService mailService;

    @Override
    public boolean confirmEmail(String hashedEmail, Long id) {
        return userDao.confirmEmail(hashedEmail, id);
    }

    @Override
    public User addNewUser(User user) throws UsernameExistsException, EmailExistsException {
        if (usernameExists(user.getUsername())) {
            throw new UsernameExistsException("Username is already exist.");
        }
        if (emailExists(user.getEmail())) {
            throw new EmailExistsException("Email is already exist");
        }
        setDefaultRole(user);
        encodePassword(user);
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

    private void setDefaultRole(User user) {
        Role userRole = roleDao.getByRoleName("ROLE_USER");
        if (userRole != null) {
            user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        }
    }

    @Override
    public void sendConfirmationEmail(User user, String serverName) {
        mailService.sendConfirmRegistrationEmail(user, serverName);
    }

    private void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User retrieveUserFromSecret(String hashAndEmail) {
        String emailInput = hashAndEmail.split("&")[1];
        User user = findByEmail(emailInput);
        if (getHashAndEmail(user.getEmail()).equals(hashAndEmail)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void changePassword(User user, String newPassword) {
        encodePassword(user);
        userDao.update(user);
    }

    private String getHashAndEmail(String email) {
        return String.format("%s&%s", Hasher.getSha256(email), email);
    }
}
