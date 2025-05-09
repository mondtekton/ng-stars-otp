package tg.ngstars.otp.interfaces;

import tg.ngstars.otp.configs.OtpConfig;

public interface OtpGenerator {

  /**
   * Generate a random OTP code based on OtpConfig
   *
   * @return String: Generated OTP code
   */
  public String generate(OtpConfig config);
}
