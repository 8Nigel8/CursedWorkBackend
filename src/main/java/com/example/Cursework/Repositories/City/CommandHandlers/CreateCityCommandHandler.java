package com.example.Cursework.Repositories.City.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.City.CityRepository;
import com.example.Cursework.Repositories.City.Model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCityCommandHandler implements Command<City, ResponseEntity> {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public ResponseEntity execute(City city) {
        cityRepository.save(city);
        return ResponseEntity.ok().build();
    }
}
