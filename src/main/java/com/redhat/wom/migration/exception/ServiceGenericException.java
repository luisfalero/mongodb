package com.redhat.wom.migration.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceGenericException extends RuntimeException {

    private String code;
    private String literal;
    private String error;

    public ServiceGenericException(String code, String literal, String error) {
        this.code = code;
        this.literal = literal;
        this.error = error;
    }

}
