package com.example.Cursework.Repositories.City.QueryHandlers;

import com.example.Cursework.Query;
import com.example.Cursework.Repositories.City.CityRepository;
import com.example.Cursework.Repositories.City.Model.City;
import com.example.Cursework.Repositories.City.Model.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllCitiesQueryHandler implements Query<Void, List<CityDTO>> {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public ResponseEntity<List<CityDTO>> execute(Void input) {
        List<CityDTO> citiesDTOs = cityRepository.findAll().stream()
                .map(city -> new CityDTO(city)) // використання лямбда-виразу
                .collect(Collectors.toList());

        return ResponseEntity.ok(citiesDTOs);
    }
}
