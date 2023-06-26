package com.ues21.fundacionsoles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<String> handleBaseException(BaseException e) {
        String mensaje = e.getMessage();
        HttpStatus estado = e.getStatus();

        return ResponseEntity.status(estado).body(mensaje);
    }

    @ExceptionHandler(Unauthorized.class)
    public ResponseEntity<String> handleUnauthorizedException(Unauthorized e) {
        String mensaje = e.getMessage();
        HttpStatusCode estado = e.getStatusCode();

        HttpStatus estado2 = HttpStatus.valueOf(estado.value());

        return ResponseEntity.status(estado).body(mensaje);
    }

}
