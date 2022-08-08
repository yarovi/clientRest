package com.demorest.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.json.JSONObject;

@ControllerAdvice
public class ClienteExceptionHandle extends ResponseEntityExceptionHandler {

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#
     * handleHttpMessageNotReadable(org.springframework.http.converter.HttpMessageNotReadableException,
     * org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
     * org.springframework.web.context.request.WebRequest)
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
            final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        return new ResponseEntity<>(this.prepareErrorJSON(status, ex), status);
    }


    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#
     * handleExceptionInternal(java.lang.Exception, java.lang.Object,
     * org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
     * org.springframework.web.context.request.WebRequest)
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(final Exception ex, final Object body,
            final HttpHeaders headers,
            final HttpStatus status, final WebRequest request) {

        return new ResponseEntity<>(this.prepareErrorJSON(status, ex), status);
    }


    private String prepareErrorJSON(final HttpStatus status, final Exception ex) {
        final JSONObject erroJson = new JSONObject();
        erroJson.put("status", status.value());
        erroJson.put("error", status.getReasonPhrase());
        erroJson.put("message", ex.getMessage());

        return erroJson.toString();
    }

}
