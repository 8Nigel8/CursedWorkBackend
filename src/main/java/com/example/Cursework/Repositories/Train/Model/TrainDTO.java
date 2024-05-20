package com.example.Cursework.Repositories.Train.Model;

import lombok.Data;

@Data
public class TrainDTO {
        private String trainNumber;
        private String type;

        public TrainDTO(Train train){
            trainNumber = train.getTrainNumber();
            type = train.getType();
        }
}

