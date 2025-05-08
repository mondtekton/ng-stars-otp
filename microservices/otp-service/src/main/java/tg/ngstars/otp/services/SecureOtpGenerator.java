package tg.ngstars.otp.services;

import tg.ngstars.otp.configs.OtpConfig;
import tg.ngstars.otp.interfaces.OtpGenerator;
import java.security.SecureRandom;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class SecureOtpGenerator implements OtpGenerator {
  private final SecureRandom secureRandom = new SecureRandom();

  @Override
  public String generate(OtpConfig config) {
    String charset = config.getCharset();
    int charsetLength = charset.length();

    int length = config.getLength(); // OTP length.
    StringBuilder otpCodeBuilder = new StringBuilder(length);

    for (int i = 0; i < length; i++) {
      int charIndex = secureRandom.nextInt(charsetLength);
      otpCodeBuilder.append(charset.charAt(charIndex));
    }
    return otpCodeBuilder.toString();
  }
}
