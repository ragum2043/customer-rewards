package com.demo.customerrewardsapp.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
