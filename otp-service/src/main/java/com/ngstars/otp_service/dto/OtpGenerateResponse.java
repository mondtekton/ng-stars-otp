package com.ngstars.otp_service.dto;

import lombok.*;

@Builder
@Data
public class OtpGenerateResponse {
  private String identifier;
  private String organization;
  private String expiresIn;
  private String code;
}
