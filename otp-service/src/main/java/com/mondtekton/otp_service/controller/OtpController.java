package com.mondtekton.otp_service.controller;

import com.mondtekton.otp_service.dto.OtpGenerateRequest;
import com.mondtekton.otp_service.dto.OtpGenerateResponse;
import com.mondtekton.otp_service.dto.OtpValidateRequest;
import com.mondtekton.otp_service.dto.OtpValidateResponse;
import com.mondtekton.otp_service.response.ApiResponse;
import com.mondtekton.otp_service.service.OtpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
@RequiredArgsConstructor
public class OtpController {

  private final OtpService otpService;

  @PostMapping("/generate")
  public ResponseEntity<ApiResponse<OtpGenerateResponse>> generate(
      @Valid @RequestBody OtpGenerateRequest request) {
    OtpGenerateResponse response =
        otpService.generate(request.getIdentifier(), request.getOrganization());

    return ResponseEntity.ok(ApiResponse.ok("OTP generated successfully!", response));
  }

  @PostMapping("/validate")
  public ResponseEntity<ApiResponse<OtpValidateResponse>> validate(
      @Valid @RequestBody OtpValidateRequest request) {
    boolean isValid =
        otpService.validate(request.getIdentifier(), request.getOrganization(), request.getCode());

    OtpValidateResponse response =
        OtpValidateResponse.builder().isValid(isValid).code(request.getCode()).build();

    // When it's not valid
    return ResponseEntity.ok(ApiResponse.ok("OTP is valid!", response));
  }
}
