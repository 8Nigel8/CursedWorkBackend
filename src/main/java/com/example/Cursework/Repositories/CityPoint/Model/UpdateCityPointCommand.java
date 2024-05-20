package com.example.Cursework.Repositories.CityPoint.Model;

import lombok.Data;

@Data
public class UpdateCityPointCommand {
    private int id;
    private CityPoint point;

    public UpdateCityPointCommand(Integer id, CityPoint point) {
        this.id = id;
        this.point = point;
    }
}
