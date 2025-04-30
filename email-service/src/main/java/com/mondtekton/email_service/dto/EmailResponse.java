package com.mondtekton.email_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailResponse {

    private String status;
    private String message;
}
