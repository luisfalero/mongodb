package com.redhat.wom.migration.exception.impl;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class HandleArgumentNotValidResponse {

    private String code;
    private String literal;
    private List<String> errors;
}
