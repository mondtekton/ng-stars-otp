package com.ngstars.otp_service.clients;

import com.ngstars.email_service.dto.EmailRequest;
import com.ngstars.email_service.dto.EmailResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface EmailClient {
  @PostExchange("/email/send")
  public ResponseEntity<EmailResponse> sendEmail(@Valid @RequestBody EmailRequest request);
}
