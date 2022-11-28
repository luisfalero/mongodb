package com.redhat.wom.migration.exception.response;

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
