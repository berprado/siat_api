package com.freddyaguilar.facturador.application.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author freddyar
 */
@Getter
@Setter
public class ExceptionResponse {

    private String message;
    private List<String> details;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public ExceptionResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }
}
