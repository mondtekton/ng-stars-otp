package com.mondtekton.email_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
    @NotBlank(message = "Recipient email must not be empty!")
    @Email(message = "Invalid email address!")
    private String to;
    @NotBlank(message = "Subject must not be empty!")
    private String subject;
    @NotBlank(message = "Message must not be empty!")
    private String message;


}
