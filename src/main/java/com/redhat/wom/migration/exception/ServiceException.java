package com.redhat.wom.migration.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ServiceException extends RuntimeException {

    private String code;
    private String literal;
    private HttpStatus status;

    public ServiceException(String code, String literal, HttpStatus status) {
        this.code = code;
        this.literal = literal;
        this.status = status;
    }

}