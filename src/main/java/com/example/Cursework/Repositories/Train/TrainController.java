package com.example.Cursework.Repositories.Train;

import com.example.Cursework.Exceptions.TrainNotFoundException;
import com.example.Cursework.Repositories.Train.Model.Train;
import com.example.Cursework.Repositories.Train.QueryHandlers.GetAllTrainsQueryHandler;
import com.example.Cursework.Repositories.Train.QueryHandlers.GetTrainQueryHandler;
import com.example.Cursework.Repositories.Train.CommandHandlers.CreateTrainCommandHandler;
import com.example.Cursework.Repositories.Train.CommandHandlers.DeleteTrainCommandHandler;
import com.example.Cursework.Repositories.Train.CommandHandlers.UpdateTrainCommandHandler;
import com.example.Cursework.Repositories.Train.Model.TrainDTO;
import com.example.Cursework.Repositories.Train.Model.UpdateTrainCommand;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trains")
public class TrainController {

    @Autowired private TrainRepository trainRepository;
    @Autowired private GetAllTrainsQueryHandler getAllTrainsQueryHandler;
    @Autowired private GetTrainQueryHandler getTrainQueryHandler;
    @Autowired private CreateTrainCommandHandler createTrainCommandHandler;
    @Autowired private UpdateTrainCommandHandler updateTrainCommandHandler;
    @Autowired private DeleteTrainCommandHandler deleteTrainCommandHandler;

    @GetMapping("/get_all")
    public String getAllTrains(Model model) {
        List<Train> trains = getAllTrainsQueryHandler.execute(null).getBody();
        model.addAttribute("trains", trains);
        return "user_panel"; // Це ім'я вашого HTML-файлу без розширення
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
