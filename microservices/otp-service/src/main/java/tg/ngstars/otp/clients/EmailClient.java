package tg.ngstars.otp.clients;

import tg.ngstars.otp.dto.EmailRequest;
import tg.ngstars.otp.dto.EmailResponse;
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
