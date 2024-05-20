package com.example.Cursework.Repositories.Route.Model;

import com.example.Cursework.Repositories.City.Model.CityDTO;
import com.example.Cursework.Repositories.City.Model.LazyCityDTO;
import com.example.Cursework.Repositories.Train.Model.TrainDTO;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class RouteDTO {
    private TrainDTO train;
    private Timestamp departureTime;
    private List<LazyCityDTO> cities;
    private LazyCityDTO departureCity;
    public RouteDTO(Route route){
//        departureCity = new LazyCityDTO(route.getDepartureCity());
        train = new TrainDTO(route.getTrain());
        departureTime = route.getDepartureTime();
        cities = route.getCities().stream().map(city -> new LazyCityDTO(city)).toList();
    }
}
