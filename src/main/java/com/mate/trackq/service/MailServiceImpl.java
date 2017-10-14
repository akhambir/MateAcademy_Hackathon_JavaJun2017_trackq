package com.mate.trackq.service;

import com.mate.trackq.dao.UserDao;
import com.mate.trackq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private UserService userService;

    @Override
    public void sendSimpleEmail(User user) {

    }

    @Override
    public void sendInviteInProject(User user) {

    }

    @Override
    public void sendConfirmRegistrationEmail(User user, String hostname) {
        String confirmationLink = hostname + "/confirm-registration?u_id=" + user.getId() * 17;
        String emailReceiver = user.getEmail();
        String subject = "E-Mail confirmation TrackQ";
        String messageText = "Hello, " + user.getUsername() + " please, confirm, your E-Mail, by link below" +
                confirmationLink + " Regards  TrackQ team!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailReceiver);
        message.setSubject(subject);
        message.setText(messageText);
        mailSender.send(message);
    }

    @Override
    public void sendNewPasswordEmail(User user) {
        userService.resetPassword(user);
        String emailReceiver = user.getEmail();
        String subject = "Your new password";
        String messageText = user.getUsername()+ ", here is your new password " + user.getPassword();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailReceiver);
        message.setSubject(subject);
        message.setText(messageText);
        mailSender.send(message);
    }
}