package com.example.Cursework.Repositories.CityPoint.CommandHandlers;

import com.example.Cursework.Repositories.CityPoint.CityPointRepository;
import com.example.Cursework.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCityPointCommandHandler implements Command<Integer, ResponseEntity> {
    @Autowired
    private CityPointRepository cityPointRepository;
    @Override
    public  ResponseEntity<ResponseEntity> execute(Integer id){
        cityPointRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
