package com.example.Cursework.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomBaseException extends Exception{
    private HttpStatus status;
    private SimpleResponse simpleResponse;

    public CustomBaseException(HttpStatus status, SimpleResponse simpleResponse){
        this.simpleResponse = simpleResponse;
        this.status = status;
    }

}
