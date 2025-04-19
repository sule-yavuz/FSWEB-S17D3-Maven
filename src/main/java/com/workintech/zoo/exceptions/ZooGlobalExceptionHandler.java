package com.workintech.zoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ZooGlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ZooGlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleException(ZooException exception) {
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getHttpStatus().value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        log.error("Exception occurred", exception);

        return new ResponseEntity<>(zooErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
