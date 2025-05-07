package com.ngstars.otp_service.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class Response {
  private boolean success;
  private HttpStatus httpStatus;
  private String message;
  private Object data;

  public static Response success(HttpStatus httpStatus, String message, Object data) {
    return new ResponseBuilder()
        .success(true)
        .httpStatus(httpStatus)
        .message(message)
        .data(data)
        .build();
  }

  public static <T> Response ok(String message, Object data) {
    return Response.success(HttpStatus.OK, message, data);
  }
}
