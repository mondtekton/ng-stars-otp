package tg.ngstars.otp.webclient;

import tg.ngstars.otp.dto.EmailRequest;
import tg.ngstars.otp.dto.EmailResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EmailService {

  private final WebClient webClient;

  public EmailService(WebClient.Builder builder) {
    this.webClient = builder.baseUrl("http://localhost:8082/").build();
  }

  public Mono<EmailResponse> send(EmailRequest emailRequest) {
    return webClient
        .post()
        .uri("/email/send")
        .bodyValue(emailRequest)
        .retrieve()
        .bodyToMono(EmailResponse.class);
  }
}
