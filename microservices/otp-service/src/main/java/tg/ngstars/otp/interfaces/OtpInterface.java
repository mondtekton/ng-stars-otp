package tg.ngstars.otp.interfaces;

import tg.ngstars.otp.entities.Otp;

public interface OtpInterface {

  // Responsible for generating otps
  public Otp generate(String identifier, String organization);

  // Validate a given otp
  public boolean validate(Otp otp);

  public boolean validate(String identifier, String organization, String code);
}
