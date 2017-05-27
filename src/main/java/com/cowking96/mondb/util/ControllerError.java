package com.cowking96.mondb.util;

public class ControllerError {

    private String errorMessage;

    public ControllerError(Exception e){
        errorMessage = e.toString();
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
