package com.ngstars.otp_service.interfaces;

import com.ngstars.otp_service.configs.OtpConfig;

public interface OtpGenerator {

  /**
   * Generate a random OTP code based on OtpConfig
   *
   * @return String: Generated OTP code
   */
  public String generate(OtpConfig config);
}
