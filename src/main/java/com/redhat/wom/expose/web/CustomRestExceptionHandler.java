package com.redhat.wom.expose.web;

import com.redhat.wom.migration.exception.ServiceException;
import com.redhat.wom.migration.exception.ServiceGenericException;
import com.redhat.wom.migration.exception.impl.HandleArgumentNotValidResponse;
import com.redhat.wom.migration.exception.impl.HandleExceptionGenericResponse;
import com.redhat.wom.migration.exception.impl.HandleExceptionResponse;
import com.redhat.wom.migration.uti.CommonsContants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<HandleExceptionResponse> handleException(ServiceException exception) {
        HandleExceptionResponse response = new HandleExceptionResponse();
        response.setCode(exception.getCode());
        response.setLiteral(exception.getLiteral());
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler(ServiceGenericException.class)
    public ResponseEntity<HandleExceptionGenericResponse> handleExceptionGeneric(ServiceGenericException exception) {
        HandleExceptionGenericResponse response = new HandleExceptionGenericResponse();
        response.setCode(exception.getCode());
        response.setLiteral(exception.getLiteral());
        response.setError(exception.getError());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        HandleArgumentNotValidResponse notValidResponse = new HandleArgumentNotValidResponse();
        notValidResponse.setCode(CommonsContants.TL00001);
        notValidResponse.setLiteral(CommonsContants.TL00001_LITERAL);
        notValidResponse.setErrors(errors);

        return handleExceptionInternal(ex, notValidResponse, headers, HttpStatus.BAD_REQUEST, request);
    }
}
