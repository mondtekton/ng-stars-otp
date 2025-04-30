package com.mondtekton.email_service.service;

import com.mondtekton.email_service.dto.EmailRequest;

public interface EmailService {

    public void sendEmail(EmailRequest request);
}
