package com.example.Cursework.Repositories.City.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.City.CityRepository;
import com.example.Cursework.Repositories.City.Model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateAllCitiesCommandHendler implements Command<List<City>, ResponseEntity> {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public ResponseEntity execute(List<City> cities) {
        cityRepository.saveAll(cities);
        ResponseEntity responseEntity = ResponseEntity.ok().build();
        return responseEntity;
    }
}
