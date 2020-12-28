package com.slb.aws.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionResponse {
    String message  ;
    int code  ;
    String type  ;
    LocalDateTime time  ;
}
