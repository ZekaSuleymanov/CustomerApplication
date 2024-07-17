package az.atlacademy.customer.exception.handler;


import az.atlacademy.customer.exception.CustomerNotFoundException;
import az.atlacademy.customer.model.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.StubNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDto> handleNotFoundxEception(CustomerNotFoundException customerNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(404,
                        customerNotFoundException.getMessage(),
                        LocalDateTime.now()));
    }


    //@ExceptionHandler
    public ResponseEntity<ErrorDto> handleInternalServerError(NullPointerException nullPointerException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(400,
                        nullPointerException.getMessage(),
                        LocalDateTime.now()));
    }
}
