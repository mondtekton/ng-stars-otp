package com.mondtekton.otp_service.service.impl;

import com.mondtekton.otp_service.dto.OtpGenerateResponse;
import com.mondtekton.otp_service.model.Otp;
import com.mondtekton.otp_service.repository.OtpRepository;
import com.mondtekton.otp_service.service.OtpGenerator;
import com.mondtekton.otp_service.service.OtpService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {
  private final OtpRepository otpRepository;
  private final OtpGenerator otpGenerator;

  @Override
  public OtpGenerateResponse generate(String identifier, String organization) {
    String code = otpGenerator.generate(); // Generate OTP code

    Otp otp = Otp.builder().identifier(identifier).organization(organization).code(code).build();
    Otp savedOtp = otpRepository.save(otp); // Save the OTP in DB

    return OtpGenerateResponse.builder()
        .identifier(savedOtp.getIdentifier())
        .organization(savedOtp.getOrganization())
        .expiresAt(formatDateTime(savedOtp.getExpiresAt()))
        .code(savedOtp.getCode())
        .build();
  }

  @Override
  @Transactional
  public boolean validate(String identifier, String organization, String code) {
    // Find the otp with this identifier and organization;
    Optional<Otp> optionalOtp = otpRepository.findLatestUnusedOtp(identifier, organization);
    boolean isValid = optionalOtp.filter(otp -> isValidOtp(otp, code)).isPresent();

    if (isValid) {
      Otp otp = optionalOtp.get();
      otp.setUsed(true);
      otpRepository.save(otp);
    }
    return isValid;
  }

  @Override
  public boolean validate(Otp otp) {
    return this.validate(otp.getIdentifier(), otp.getOrganization(), otp.getCode());
  }

  private boolean isValidOtp(Otp otp, String code) {
    return otp.getExpiresAt().isAfter(LocalDateTime.now()) && otp.getCode().equals(code);
  }

  private String formatDateTime(LocalDateTime dateTime) {
    return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }
}
