package com.ngstars.otp_service.configs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * OTP generation configuration -- Defines parameters for generating the otp
 *
 * <ul>
 *   <li><i style="color: orange">length</i>: OTP's length
 *   <li><i style="color: orange">charset</i>: Set of otp characters
 *   <li><i style="color: orange">expiryMin</i>: Expiration time in minutes
 *   <li><i style="color: orange">maxAttempts</i>: Maximum generation attempts
 * </ul>
 */
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

  private int maxAttempts = 10;
}
