package com.example.demo.exception;

public class GeneralException extends Exception{
    private String message;
    private int errorCode;

    public GeneralException(String message) {
        super();
        this.message=message;
    }

    public GeneralException(String message, int errorCode) {
        super();
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
    public int getErrorCode(){
        return errorCode;
    }
}
