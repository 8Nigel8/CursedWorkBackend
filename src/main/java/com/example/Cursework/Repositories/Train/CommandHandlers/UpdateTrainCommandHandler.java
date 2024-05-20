package com.example.Cursework.Repositories.Train.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.Train.Model.Train;
import com.example.Cursework.Repositories.Train.TrainRepository;
import com.example.Cursework.Repositories.Train.Model.UpdateTrainCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateTrainCommandHandler implements Command<UpdateTrainCommand, ResponseEntity> {
    @Autowired
    private TrainRepository trainRepository;
    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateTrainCommand command) {
        Train train = command.getTrain();
        train.setId(Long.valueOf(command.getId()));
        trainRepository.save(train);
        return ResponseEntity.ok().build();
    }
}
