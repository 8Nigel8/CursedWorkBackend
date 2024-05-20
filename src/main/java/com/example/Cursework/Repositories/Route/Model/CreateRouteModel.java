package com.example.Cursework.Repositories.Route.Model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CreateRouteModel {
    private Long trainID;
    private Timestamp departureTime;
    private Long departureCityId;
    private List<Long> citiesIDs;
}
