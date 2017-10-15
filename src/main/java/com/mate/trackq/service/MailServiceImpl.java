package com.mate.trackq.service;

import com.mate.trackq.model.User;
import com.mate.trackq.util.Hasher;
import com.mate.trackq.util.HtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendInviteInProject(String email, Integer projectId, String hostname) {
        String confirmationLink = hostname + "/" + projectId + "?userEmail=" + email;
        String subject = "E-Mail confirmation TrackQ";
        String messageText = "Hello, you're invited to the project. Please, confirm, your E-Mail, by link below" +
                HtmlUtils.buildHrefTag(confirmationLink) + " Regards  TrackQ team!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(messageText);
        mailSender.send(message);

    }

    @Override
    public void sendConfirmRegistrationEmail(User user, String hostname) {
        String confirmationLink = hostname + "/confirm-registration/" + Hasher.getSha256(user.getEmail()) + "?id=" + user.getId();
        String emailReceiver = user.getEmail();
        String subject = "E-Mail confirmation TrackQ";
        String messageText = "Hello, " + user.getUsername() + " please, confirm, your E-Mail, by link below\n" +
                confirmationLink + "\n Regards  TrackQ team!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailReceiver);
        message.setSubject(subject);
        message.setText(messageText);
        mailSender.send(message);
    }

    @Override
    public void sendNewPasswordEmail(User user, String hostname) {
        String confirmationLink = hostname + "/change-password/" + getHashAndUsername(user.getUsername());
        String subject = "Set new password";
        String messageText = "Please, set your new password, by link below " +
                HtmlUtils.buildHrefTag(confirmationLink) + " Regards  TrackQ team!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject(subject);
        message.setText(messageText);
        mailSender.send(message);
    }

    private String getHashAndUsername(String username) {
        return String.format("%s&%s", Hasher.getSha256(username), username);
    }
}