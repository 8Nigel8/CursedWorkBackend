package com.example.Cursework.Repositories.CityPoint.CommandHandlers;

import com.example.Cursework.Repositories.CityPoint.CityPointRepository;
import com.example.Cursework.Repositories.CityPoint.Model.CityPoint;
import com.example.Cursework.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCityPointCommandHandler implements Command<CityPoint, ResponseEntity> {
    @Autowired
    private CityPointRepository cityPointRepository;

    @Override
    public ResponseEntity execute(CityPoint point) {
        cityPointRepository.save(point);
        return ResponseEntity.ok().build();
    }
}
