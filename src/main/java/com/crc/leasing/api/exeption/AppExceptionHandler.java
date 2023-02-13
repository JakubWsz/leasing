package com.crc.leasing.api.exeption;

import com.crc.leasing.domain.exception.DateConflictException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;

@ControllerAdvice
@Slf4j
public class AppExceptionHandler {
    @ExceptionHandler(DateConflictException.class)
    public ResponseEntity<Error> handleDomainException(DateConflictException exception) {
        log.error("DateConflictException occurred", exception);
        HttpStatus httpStatus = HttpStatus.valueOf(exception.getCode().getStatus());
        Error body = new Error(httpStatus.value(), exception.getMessage());
        return new ResponseEntity<>(body, httpStatus);
    }

    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    @Getter
    public static class Error {
        int status;
        String message;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<String> details;
        Instant timestamp = Instant.now();

        public Error(int status, String message) {
            this.status = status;
            this.message = message;
            details = null;
        }

        public Error(int status, String message, List<String> details) {
            this.status = status;
            this.message = message;
            this.details = details;
        }
    }
}
