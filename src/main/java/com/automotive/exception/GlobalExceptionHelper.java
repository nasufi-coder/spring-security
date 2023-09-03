package com.automotive.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHelper {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleDefaultException(Exception e) {
        log.error("Exception", e);
        return new ResponseEntity<>(
                new ErrorResponse(INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.name(), e.getMessage()),
                INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e) {
        log.error("Exception", e);
        return new ResponseEntity<>(
                new ErrorResponse(INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.name(), e.getMessage()),
                INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("Template Exception", e);
        return new ResponseEntity<>(
                new ErrorResponse(BAD_REQUEST.value(), BAD_REQUEST.name(), e.getMessage()),
                BAD_REQUEST);
    }

    @ExceptionHandler(value = {ServletRequestBindingException.class})
    public ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException e) {
        log.error("Template Exception", e);
        return new ResponseEntity<>(
                new ErrorResponse(BAD_REQUEST.value(), BAD_REQUEST.name(), e.getMessage()),
                BAD_REQUEST);
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("Template Exception", e);
        return new ResponseEntity<>(
                new ErrorResponse(BAD_REQUEST.value(), BAD_REQUEST.name(), e.getMessage()),
                BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpMessageConversionException.class})
    public ResponseEntity<Object> handleHttpMessageConversionException(HttpMessageConversionException e) {
        log.error("Template Exception", e);
        return new ResponseEntity<>(
                new ErrorResponse(BAD_REQUEST.value(), BAD_REQUEST.name(), e.getMessage()),
                BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("Template Exception", e);
        return new ResponseEntity<>(
                new ErrorResponse(BAD_REQUEST.value(), BAD_REQUEST.name(), e.getMessage()),
                BAD_REQUEST);
    }

}
