package com.example.Cursework.Repositories.City.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.City.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCityCommandHandler implements Command<Integer, ResponseEntity> {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(Integer id) {
        cityRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }
}
