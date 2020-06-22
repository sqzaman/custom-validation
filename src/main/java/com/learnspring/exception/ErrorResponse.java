package com.learnspring.exception;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private List<String> errors;
    
    public ErrorResponse() {
        super();
    }

    public ErrorResponse(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ErrorResponse(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

}

