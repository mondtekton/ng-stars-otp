package tg.ngstars.email.controller;

import lombok.AllArgsConstructor;
import tg.ngstars.email.interfaces.EmailInterface;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tg.ngstars.entities.EmailRequest;
import tg.ngstars.entities.EmailResponse;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {

  private EmailInterface emailService;

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
