package com.demo.customerrewardsapp.exception;

import lombok.Data;
/**
 * 
 * Exception response
 * @author Ragu
 *
 */
@Data
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
}
