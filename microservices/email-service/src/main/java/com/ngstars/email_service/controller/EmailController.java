package com.ngstars.email_service.controller;

import com.ngstars.email_service.dto.EmailRequest;
import com.ngstars.email_service.dto.EmailResponse;
import com.ngstars.email_service.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

  @Value("${env}")
  private String env;

  @Value("${eureka.client.serviceUrl.defaultZone}")
  private String defaultZone;

  @Autowired private EmailService emailService;

  @GetMapping("env")
  public String getEmail(){
    return this.env;
  }

  @GetMapping("eureka")
  public String getEurekaEmail(){
    return this.defaultZone;
  }

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
