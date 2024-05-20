package com.example.Cursework.Repositories.Train.Model;

import lombok.Data;

@Data
public class UpdateTrainCommand {
    private int id;
    private Train train;

    public UpdateTrainCommand(Integer id, Train train) {
        this.id = id;
        this.train = train;
    }
}
