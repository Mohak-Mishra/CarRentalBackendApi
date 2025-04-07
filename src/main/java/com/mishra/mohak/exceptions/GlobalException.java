package com.mishra.mohak.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ErrorDetails> carNotFound(CarNotFoundException e) {
       ErrorDetails ed= new ErrorDetails(e.getMessage(), LocalDateTime.now(),404);
       return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails>userNotFound(UserNotFoundException e) {
        ErrorDetails ed= new ErrorDetails(e.getMessage(), LocalDateTime.now(),404);
        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ErrorDetails> adminNotFound(AdminNotFoundException e) {
        ErrorDetails ed= new ErrorDetails(e.getMessage(), LocalDateTime.now(),404);
        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorDetails> bookingNotFound(BookingNotFoundException e) {
        ErrorDetails ed= new ErrorDetails(e.getMessage(), LocalDateTime.now(),404);
        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

}
