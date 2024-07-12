package az.atlacademy.customer.model.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorDto {

    int errorCode;

    String errorMessage;

    LocalDateTime localDateTime;
}
