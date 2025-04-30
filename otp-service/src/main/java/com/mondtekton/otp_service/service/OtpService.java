package com.mondtekton.otp_service.service;

import com.mondtekton.otp_service.dto.OtpGenerateResponse;
import com.mondtekton.otp_service.model.Otp;

public interface OtpService {

  // Responsible for generating the otp
  public OtpGenerateResponse generate(String identifier, String organization);

  // Validate a given otp
  public boolean validate(Otp otp);

  public boolean validate(String identifier, String organization, String code);
}
