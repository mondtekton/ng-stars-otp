package tg.ngstars.otp.dto;

import lombok.*;

@Builder
@Data
public class OtpValidateResponse {
  private String code;
  private boolean isValid;
}
