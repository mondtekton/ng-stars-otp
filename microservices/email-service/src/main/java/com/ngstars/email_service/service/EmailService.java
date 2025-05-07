package com.ngstars.email_service.service;

import com.ngstars.email_service.dto.EmailRequest;

public interface EmailService {

    public void sendEmail(EmailRequest request);
}
