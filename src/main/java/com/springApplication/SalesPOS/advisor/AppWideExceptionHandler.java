package com.springApplication.SalesPOS.advisor;

import com.springApplication.SalesPOS.exception.NotFoundException;
import com.springApplication.SalesPOS.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(404, "Error",e.getMessage()),
                HttpStatus.NOT_FOUND
        );
        return response;
    }
}
