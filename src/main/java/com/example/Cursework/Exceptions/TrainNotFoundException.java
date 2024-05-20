package com.example.Cursework.Exceptions;

import org.springframework.http.HttpStatus;

public class TrainNotFoundException extends CustomBaseException{
    public TrainNotFoundException(){
        super(HttpStatus.NOT_FOUND,new SimpleResponse("Train not found"));
    }
}
