package tg.ngstars.otp.controllers;

import lombok.AllArgsConstructor;
import tg.ngstars.entities.EmailRequest;
import tg.ngstars.otp.clients.EmailClient;
import tg.ngstars.otp.configs.OtpConfig;
import tg.ngstars.otp.dto.*;
import tg.ngstars.otp.entities.Otp;
import tg.ngstars.otp.interfaces.OtpInterface;
import tg.ngstars.otp.response.Response;
import tg.ngstars.otp.utils.EmailTemplate;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
@AllArgsConstructor
public class OtpController {

  private final OtpInterface otpService;
  private final OtpConfig config;
  private EmailClient emailClient;

  @GetMapping("/value")
  private String getValue(){
    return new EmailRequest("mondodev88@gmail.com", "Test", "ok ok ok").getTo();
  }

  @PostMapping("/generate")
  public Response generate(@Valid @RequestBody OtpGenerateRequest request) {
    Otp otp = otpService.generate(request.getIdentifier(), request.getOrganization());

    OtpGenerateResponse data =
        OtpGenerateResponse.builder()
            .identifier(otp.getIdentifier())
            .organization(otp.getOrganization())
            .expiresIn(Integer.toString(config.getExpiryMin()))
            .code(otp.getCode())
            .build();

    // Send the generated otp
    String subject = EmailTemplate.subject();
    String message = EmailTemplate.content(otp.getCode(), config.getExpiryMin(), "NG-Stars");
    EmailRequest email = EmailRequest.builder().to(otp.getIdentifier()).subject(subject).message(message).build();

    System.out.println("Sending email...");
    // emailClient.sendEmail(emailRequest);
    emailClient.send(email);
    System.out.println("Email sent");

    return Response.ok("OTP generated successfully and sent to your inbox!", data);
  }

  @PostMapping("/validate")
  public Response validate(@Valid @RequestBody OtpValidateRequest request) {
    boolean isValid =
        otpService.validate(request.getIdentifier(), request.getOrganization(), request.getCode());

    OtpValidateResponse response =
        OtpValidateResponse.builder().isValid(isValid).code(request.getCode()).build();

    // When it's not valid
    if(!isValid){
      return Response.failure("OTP validation failed", response);
    }
    return Response.ok("OTP validated with success!", response);
  }
}
