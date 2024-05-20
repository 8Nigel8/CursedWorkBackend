package com.example.Cursework.Repositories.Train.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.Train.Model.Train;
import com.example.Cursework.Repositories.Train.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateTrainCommandHandler implements Command<Train, ResponseEntity> {
    @Autowired
    private TrainRepository trainRepository;
    @Override
    public ResponseEntity execute(Train train) {
        trainRepository.save(train);
        return ResponseEntity.ok().build();
    }
}
