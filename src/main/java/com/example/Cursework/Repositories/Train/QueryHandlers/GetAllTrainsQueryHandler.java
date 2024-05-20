package com.example.Cursework.Repositories.Train.QueryHandlers;

import com.example.Cursework.Query;
import com.example.Cursework.Repositories.Train.Model.Train;
import com.example.Cursework.Repositories.Train.Model.TrainDTO;
import com.example.Cursework.Repositories.Train.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTrainsQueryHandler implements Query<Void, List<Train>> {
    @Autowired
    private TrainRepository trainRepository;

    @Override
    public ResponseEntity<List<Train>> execute(Void input) {
        List<Train> trains = trainRepository
                .findAll();

        return ResponseEntity.ok(trains);
    }
}
