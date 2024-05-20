package com.example.Cursework.Repositories.CityPoint.Model;

import com.example.Cursework.Repositories.City.Model.CityDTO;

public class CityPointDTO {
    private Double x;
    private Double y;

    public CityPointDTO(CityPoint point) {
        x = point.getX();
        y = point.getY();
    }
}
