package tg.ngstars.otp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class OtpGenerateRequest {
  @NotBlank(message = "identifier is required. But not provided!")
  private String identifier;

  @NotBlank(message = "organization is required. But not provided!")
  private String organization;
}
