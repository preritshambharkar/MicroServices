package com.car.service.exception;


public class ResouceNotFoundException extends RuntimeException {

    public ResouceNotFoundException () {
        super("Resource Not Found Exception!!");
    }

    public ResouceNotFoundException(String message) {
        super(message);
    }

}
