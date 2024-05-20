package com.example.Cursework.Repositories.City.Model;

import lombok.Data;

@Data
public class UpdateCityCommand {
    private int id;
    private City city;

    public UpdateCityCommand(Integer id, City city) {
        this.id = id;
        this.city = city;
    }
}
