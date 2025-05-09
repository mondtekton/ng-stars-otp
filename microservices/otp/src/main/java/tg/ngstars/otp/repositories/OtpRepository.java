package tg.ngstars.otp.repositories;

import tg.ngstars.otp.entities.Otp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OtpRepository extends JpaRepository<Otp, Long> {

  @Query(
"""
  SELECT o FROM Otp o
  WHERE o.identifier = :identifier
    AND o.organization = :organization
    AND o.isUsed = false
  ORDER BY o.createdAt DESC
""")
  Optional<Otp> findLatestUnsedOtp(
      @Param("identifier") String identifier, @Param("organization") String organization);
}
