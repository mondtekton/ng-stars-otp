package com.mondtekton.otp_service.service;

public interface OtpGenerator {
  /**
   * Generate a random OTP code based on OtpConfig
   *
   * @return String: Generated OTP code
   */
  public String generate();
}
