package com.ngstars.email_service.service.impl;

import com.ngstars.email_service.dto.EmailRequest;
import com.ngstars.email_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendEmail(EmailRequest request) {

            SimpleMailMessage message = new SimpleMailMessage();

            // It's optional: Some SMTP Server will reject message if not provided
            message.setFrom("katohdavid@gmail.com");
            message.setTo(request.getTo());
            message.setSubject(request.getSubject());
            message.setText(request.getMessage());

            // Send the email to the user
            emailSender.send(message);


    }
}
