package tg.ngstars.email.service.impl;

import tg.ngstars.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tg.ngstars.entities.EmailRequest;

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
