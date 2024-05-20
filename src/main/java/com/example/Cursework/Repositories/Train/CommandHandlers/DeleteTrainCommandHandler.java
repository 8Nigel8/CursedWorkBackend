package com.example.Cursework.Repositories.Train.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.Train.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteTrainCommandHandler implements Command<Integer, ResponseEntity> {
    @Autowired
    private TrainRepository trainRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(Integer id) {
        trainRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }
}
