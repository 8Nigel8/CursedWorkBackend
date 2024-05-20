package com.example.Cursework.Repositories.City.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.City.CityRepository;
import com.example.Cursework.Repositories.City.Model.City;
import com.example.Cursework.Repositories.City.Model.UpdateCityCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateCityCommandHandler implements Command<UpdateCityCommand, ResponseEntity> {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateCityCommand command) {
        City city = command.getCity();
        city.setId(Long.valueOf(command.getId()));
        cityRepository.save(city);
        return ResponseEntity.ok().build();
    }
}
