package com.ngstars.otp_service.services;

import com.ngstars.otp_service.configs.OtpConfig;
import com.ngstars.otp_service.entities.Otp;
import com.ngstars.otp_service.interfaces.*;
import com.ngstars.otp_service.repositories.OtpRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpService implements OtpInterface {
  private final OtpRepository repository;
  private final OtpGenerator generator; // Generation Strategy
  private final OtpConfig config; // OTP configuration

  @Override
  public Otp generate(String identifier, String organization) {
    String otpCode = generator.generate(config); // Generate OTP code

    Otp otp = Otp.builder().identifier(identifier).organization(organization).code(otpCode).build();

    return repository.save(otp); // Save and return otp;
  }

  @Override
  @Transactional
  public boolean validate(String identifier, String organization, String code) {
    Optional<Otp> optionalOtp = repository.findLatestUnsedOtp(identifier, organization);
    boolean isValid = optionalOtp.filter(otp -> isValidOtpCode(otp, code)).isPresent();

    if (isValid) {
      Otp otp = optionalOtp.get();
      otp.setUsed(true);
      repository.save(otp);
    }
    return isValid;
  }

  @Override
  @Transactional
  public boolean validate(Otp otp) {
    return this.validate(otp.getIdentifier(), otp.getOrganization(), otp.getCode());
  }

  private boolean isValidOtpCode(Otp otp, String code) {
    return otp.getExpiresAt().isAfter(LocalDateTime.now()) && otp.getCode().equals(code);
  }

  private String formatDateTime(LocalDateTime dateTime) {
    return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }
}
