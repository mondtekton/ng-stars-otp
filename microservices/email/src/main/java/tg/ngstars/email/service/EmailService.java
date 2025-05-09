package tg.ngstars.email.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import tg.ngstars.email.interfaces.EmailInterface;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tg.ngstars.entities.EmailRequest;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailInterface {
    private final JavaMailSender emailSender;

    @Value("${email.sender}")
    private String sender;

    @Override
    public void sendEmail(EmailRequest request) {

            SimpleMailMessage message = new SimpleMailMessage();

            // It's optional: Some SMTP Server will reject message if not provided
            message.setFrom(sender);
            message.setTo(request.getTo());
            message.setSubject(request.getSubject());
            message.setText(request.getMessage());

            // Send the email to the user
            emailSender.send(message);

    }
}
