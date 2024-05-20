package com.example.Cursework;

import com.example.Cursework.Exceptions.TrainNotFoundException;
import org.springframework.http.ResponseEntity;

public interface Query <I,O>{
    ResponseEntity<O> execute(I input) throws TrainNotFoundException;
}
