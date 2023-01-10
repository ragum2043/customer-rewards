package com.demo.customerrewardsapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleResourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        ExceptionResponse er = new ExceptionResponse();
        er.setErrorMessage(exception.getMessage());
        er.setRequestedURI(request.getRequestURI());
        return er;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleException(Exception exception, HttpServletRequest request) {

        ExceptionResponse er = new ExceptionResponse();
        er.setErrorMessage(exception.getMessage());
        er.setRequestedURI(request.getRequestURI());
        return er;
    }
}

