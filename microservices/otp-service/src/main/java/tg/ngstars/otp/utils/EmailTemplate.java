package tg.ngstars.otp.utils;

public class EmailTemplate {

  public static String subject() {
    return "Votre code de connexion sécurisé (OTP)";
  }

  public static String content(String otp, int expiresIn, String senderOrg) {
    return """
       Bonjour,

       Voici votre mot de passe à usage unique (OTP) pour vous connecter en toute sécurité :

       🔐 Code OTP : %s

       Ce code est valable pendant %d minutes.
       Ne le partagez avec personne — même pas avec nos équipes.

       Si vous n'avez pas demandé ce code, veuillez ignorer ce message.

       Merci de votre confiance.

       —
       L'équipe %s
       """
        .formatted(otp, expiresIn, senderOrg);
  }
}
