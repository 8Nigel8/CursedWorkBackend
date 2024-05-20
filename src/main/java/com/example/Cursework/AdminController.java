package com.example.Cursework;

import com.example.Cursework.Exceptions.TrainNotFoundException;
import com.example.Cursework.Repositories.Train.CommandHandlers.CreateTrainCommandHandler;
import com.example.Cursework.Repositories.Train.CommandHandlers.DeleteTrainCommandHandler;
import com.example.Cursework.Repositories.Train.CommandHandlers.UpdateTrainCommandHandler;
import com.example.Cursework.Repositories.Train.Model.Train;
import com.example.Cursework.Repositories.Train.Model.TrainDTO;
import com.example.Cursework.Repositories.Train.Model.UpdateTrainCommand;
import com.example.Cursework.Repositories.Train.QueryHandlers.GetAllTrainsQueryHandler;
import com.example.Cursework.Repositories.Train.QueryHandlers.GetTrainQueryHandler;
import com.example.Cursework.Repositories.Train.TrainRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @Autowired private TrainRepository trainRepository;
    @Autowired private GetAllTrainsQueryHandler getAllTrainsQueryHandler;
    @Autowired private GetTrainQueryHandler getTrainQueryHandler;
    @Autowired private CreateTrainCommandHandler createTrainCommandHandler;
    @Autowired private UpdateTrainCommandHandler updateTrainCommandHandler;
    @Autowired private DeleteTrainCommandHandler deleteTrainCommandHandler;


    @GetMapping("/get_all")
    public ResponseEntity<List<Train>> getTrains() {
        return getAllTrainsQueryHandler.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainDTO> getTrain(@PathVariable Integer id) throws TrainNotFoundException {
        return getTrainQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity createTrain(@Valid @RequestBody Train train) {
        return createTrainCommandHandler.execute(train);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTrain(@Valid @PathVariable Integer id, @RequestBody Train train) {
        UpdateTrainCommand command = new UpdateTrainCommand(id, train);
        return updateTrainCommandHandler.execute(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTrain(@PathVariable Integer id) {
        return deleteTrainCommandHandler.execute(id);
    }
}
