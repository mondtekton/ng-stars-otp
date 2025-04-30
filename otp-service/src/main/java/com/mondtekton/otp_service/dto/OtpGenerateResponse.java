package com.mondtekton.otp_service.dto;

import lombok.*;

@Builder
@Data
public class OtpGenerateResponse {
  private String identifier;
  private String organization;
  private String expiresAt;
  private String code;
}
