package com.mondtekton.otp_service.repository;

import com.mondtekton.otp_service.model.Otp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {

  Optional<Otp> findTopByIdentifierAndOrganizationAndIsUsedFalseOrderByCreatedAtDesc(
      String identifier, String organization);

  default Optional<Otp> findLatestUnusedOtp(String identifier, String organization) {
    return findTopByIdentifierAndOrganizationAndIsUsedFalseOrderByCreatedAtDesc(
        identifier, organization);
  }

}
