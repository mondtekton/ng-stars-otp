package com.ngstars.otp_service.dto;

import lombok.*;

@Builder
@Data
public class OtpValidateResponse {
  private String code;
  private boolean isValid;
}
