package com.example.Cursework.Repositories.CityPoint.CommandHandlers;

import com.example.Cursework.Repositories.CityPoint.CityPointRepository;
import com.example.Cursework.Repositories.CityPoint.Model.CityPoint;
import com.example.Cursework.Repositories.CityPoint.Model.UpdateCityPointCommand;
import com.example.Cursework.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateCityPointCommandHandler implements Command<UpdateCityPointCommand, ResponseEntity> {
    @Autowired
    private CityPointRepository cityPointRepository;
    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateCityPointCommand command){
        CityPoint cityPoint = command.getPoint();
        cityPoint.setId(Long.valueOf(command.getId()));
        cityPointRepository.save(cityPoint);
        return ResponseEntity.ok().build();
    }
}
