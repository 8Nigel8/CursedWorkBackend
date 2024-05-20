package com.example.Cursework.Repositories.City.Model;

import com.example.Cursework.Repositories.CityPoint.Model.CityPoint;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CityDTO {
    private Long id;
    private String name;
    private CityPoint point;
    private List<Long> citiesIDs;

    public CityDTO(City city) {
        id = city.getId();
        name = city.getName();
        point = city.getPoint();
        citiesIDs = city.getConnectedCities().stream()
                .map(City::getId)
                .collect(Collectors.toList());
    }
}

