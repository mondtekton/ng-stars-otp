package com.mondtekton.otp_service.config;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "otp")
@Data
@Validated
public class OtpConfig {
    @Min(value = 4, message = "OTP length must be at least 4")
    private int length;

    @NotEmpty(message = "OTP charset can't be empty")
    private String charset;

    @Min(value = 1, message = "Expiration time must be at least 1min")
    private int expiryMin;

    private int maxAttemps = 10;
}


