package com.redhat.wom.migration.exception.impl;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HandleExceptionResponse {

    private String code;
    private String literal;

}