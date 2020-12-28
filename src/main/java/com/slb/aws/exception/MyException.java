package com.slb.aws.exception;

public class MyException extends RuntimeException {

    public static final String MY_BUSINESS_EXCEPTION_MESSAGE = "My Business Exception";
    public static final int MY_BUSINESS_EXCEPTION_CODE = 800;

    public MyException() {
        super(MY_BUSINESS_EXCEPTION_MESSAGE);
    }

    public MyException(String message) {
        super(MY_BUSINESS_EXCEPTION_MESSAGE);
    }

    public MyException(String message, Throwable cause) {
        super(MY_BUSINESS_EXCEPTION_MESSAGE, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    protected MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MY_BUSINESS_EXCEPTION_MESSAGE, cause, enableSuppression, writableStackTrace);
    }
}
