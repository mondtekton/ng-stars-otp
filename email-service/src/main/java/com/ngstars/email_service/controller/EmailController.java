package com.ngstars.email_service.controller;

import com.ngstars.email_service.dto.EmailRequest;
import com.ngstars.email_service.dto.EmailResponse;
import com.ngstars.email_service.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

  @Autowired private EmailService emailService;

  @PostMapping("/send")
  public ResponseEntity<EmailResponse> sendEmail(@Valid @RequestBody EmailRequest request) {
    try {
      emailService.sendEmail(request);
      EmailResponse response = new EmailResponse("SUCCESS", "Email Sent Successfully!");
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.notFound().build();
    }
  }
}
