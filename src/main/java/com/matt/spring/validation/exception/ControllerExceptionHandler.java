package com.matt.spring.validation.exception;

import com.matt.spring.validation.dto.CommonResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<CommonResponseData> handleException(Exception e) {
        log.error(e.getMessage(), e);
        CommonResponseData responseData = new CommonResponseData(false);
        responseData.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CommonResponseData> handleException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        CommonResponseData responseData = new CommonResponseData(false);
        responseData.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
    }
}
