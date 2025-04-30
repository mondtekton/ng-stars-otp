package com.mondtekton.otp_service.service.impl;

import com.mondtekton.otp_service.config.OtpConfig;
import com.mondtekton.otp_service.service.OtpGenerator;
import java.security.SecureRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpGeneratorImpl implements OtpGenerator {
  private final SecureRandom secureRandom = new SecureRandom();
  private final OtpConfig otpConfig;

  @Override
  public String generate() {
    String charset = otpConfig.getCharset();
    int charsetLen = charset.length();

    int otpLen = otpConfig.getLength();

    StringBuilder codeBuilder = new StringBuilder(otpLen);

    for (int i = 0; i < otpLen; i++) {

      int charIndex = secureRandom.nextInt(charsetLen);
      codeBuilder.append(charset.charAt(charIndex));
    }
    return codeBuilder.toString();
  }
}
