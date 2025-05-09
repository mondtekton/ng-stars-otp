package tg.ngstars.email.service;

import tg.ngstars.entities.EmailRequest;

public interface EmailService {

    public void sendEmail(EmailRequest request);
}
