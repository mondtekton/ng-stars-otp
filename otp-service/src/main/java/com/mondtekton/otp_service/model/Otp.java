package com.mondtekton.otp_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "otps",
    indexes = {
      @Index(name = "idx_identifier_org", columnList = "identifier, organization"),
      @Index(name = "idx_otp", columnList = "code")
    })
public class Otp {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Telephone or email
  @Column(nullable = false)
  private String identifier;

  // Otp value: This is a hashed value
  @Column(nullable = false)
  private String code;

  @Column(nullable = false)
  private String organization;

  private boolean isUsed = false;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column() private LocalDateTime validatedAt;

  @Column(nullable = false)
  private LocalDateTime expiresAt;

  @PrePersist
  public void prePersist() {
    if (expiresAt == null) {
      expiresAt = LocalDateTime.now().plusMinutes(10);
    }
  }
}
