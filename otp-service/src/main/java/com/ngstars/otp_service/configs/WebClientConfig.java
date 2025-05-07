package com.ngstars.otp_service.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Autowired private LoadBalancedExchangeFilterFunction filterFunction;

  @Bean
  WebClient emailWebClient() {
    return WebClient.builder()
        .baseUrl("http://localhost:8082/")
        // .filter(filterFunction)
        .build();
    // return WebClient.builder().baseUrl("http://email-service").filter(filterFunction).build();
  }

  //  @Bean
  //  public EmailClient emailClient() {
  //    HttpServiceProxyFactory httpServiceProxyFactory =
  //        HttpServiceProxyFactory.builder()
  //            .exchangeAdapter(WebClientAdapter.create(emailWebClient()))
  //            .build();
  //
  //    return httpServiceProxyFactory.createClient(EmailClient.class);
  //  }

}
