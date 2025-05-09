package tg.ngstars.otp.configs;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import tg.ngstars.otp.clients.EmailClient;

@Configuration
@AllArgsConstructor
public class WebClientConfig {

    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    WebClient emailWebClient() {
        return WebClient.builder()
                .baseUrl("http://email")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public EmailClient emailClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder()
                        .exchangeAdapter(WebClientAdapter.create(emailWebClient()))
                        .build();

        return httpServiceProxyFactory.createClient(EmailClient.class);
    }

}