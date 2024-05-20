package com.example.Cursework.Repositories.City.Model;

import com.example.Cursework.Repositories.CityPoint.Model.CityPoint;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class LazyCityDTO {
    private Long id;
    private String name;
    public LazyCityDTO(City city) {
        id = city.getId();
        name = city.getName();
    }

}
