package com.slb.aws.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleErrors(Exception ex, WebRequest wr) {
        return new ResponseEntity<Object>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Object> handleNullPointer(Exception ex, WebRequest wr) {
        return new ResponseEntity<Object>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<ExceptionResponse> handleMyException(MyException ex, WebRequest wr) {
        ExceptionResponse er = ExceptionResponse.builder().code(MyException.MY_BUSINESS_EXCEPTION_CODE)
                .message(ex.getLocalizedMessage())
                .type("ERROR")
                .time(LocalDateTime.now())
                .build();
        return new ResponseEntity<ExceptionResponse>(er, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
