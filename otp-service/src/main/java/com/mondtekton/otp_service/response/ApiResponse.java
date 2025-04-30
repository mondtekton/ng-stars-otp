package com.mondtekton.otp_service.response;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/** A wrapper for the API responses */
@Data
@Builder
public class ApiResponse<T> {
  private boolean success;
  private HttpStatus httpStatus;
  private String message;
  private LocalDateTime timestamp;
  private T data;

  public static <T> ApiResponse<T> success(HttpStatus httpStatus, String message, T data) {
    return new ApiResponseBuilder<T>()
        .success(true)
        .httpStatus(httpStatus)
        .message(message)
        .timestamp(LocalDateTime.now(ZoneOffset.UTC))
        .data(data)
        .build();
  }

  public static <T> ApiResponse<T> ok(String message, T data) {
    return ApiResponse.success(HttpStatus.OK, message, data);
  }
}
