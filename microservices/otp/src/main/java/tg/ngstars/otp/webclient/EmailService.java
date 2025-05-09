package tg.ngstars.otp.webclient;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tg.ngstars.entities.EmailRequest;
import tg.ngstars.entities.EmailResponse;

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
