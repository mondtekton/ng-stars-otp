package tg.ngstars.otp.dto;

import lombok.*;

@Builder
@Data
public class OtpGenerateResponse {
  private String identifier;
  private String organization;
  private String expiresIn;
  private String code;
}
