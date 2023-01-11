package com.demo.customerrewardsapp.exception;
/**
 * 
 * Custom ResourceNotFoundException
 * @author Ragu
 *
 */
public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
