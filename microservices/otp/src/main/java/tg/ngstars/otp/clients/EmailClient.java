package tg.ngstars.otp.clients;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import tg.ngstars.entities.EmailRequest;

@HttpExchange
public interface EmailClient {
  @PostExchange("/email/send")
   void send(@Valid @RequestBody EmailRequest request);
}
