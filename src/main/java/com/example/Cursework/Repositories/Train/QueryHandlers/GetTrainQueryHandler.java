package com.example.Cursework.Repositories.Train.QueryHandlers;

import com.example.Cursework.Exceptions.TrainNotFoundException;
import com.example.Cursework.Query;
import com.example.Cursework.Repositories.Train.Model.Train;
import com.example.Cursework.Repositories.Train.Model.TrainDTO;
import com.example.Cursework.Repositories.Train.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetTrainQueryHandler implements Query<Integer, TrainDTO> {
    @Autowired
    private TrainRepository trainRepository;
    @Override
    public ResponseEntity<TrainDTO> execute(Integer id) throws TrainNotFoundException {
        Optional<Train> train = trainRepository.findById(id);
        if (train.isEmpty()){

            throw new TrainNotFoundException();
        }
        return ResponseEntity.ok(new TrainDTO(train.get()));
    }
}
