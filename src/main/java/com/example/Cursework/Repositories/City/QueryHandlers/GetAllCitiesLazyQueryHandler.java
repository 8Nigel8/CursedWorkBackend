package com.example.Cursework.Repositories.City.QueryHandlers;

import com.example.Cursework.Query;
import com.example.Cursework.Repositories.City.CityRepository;
import com.example.Cursework.Repositories.City.Model.CityDTO;
import com.example.Cursework.Repositories.City.Model.LazyCityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllCitiesLazyQueryHandler implements Query<Void, List<LazyCityDTO>> {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public ResponseEntity<List<LazyCityDTO>> execute(Void input) {
        List<LazyCityDTO> citiesDTOs = cityRepository.findAll().stream()
                .map(city -> new LazyCityDTO(city)) // використання лямбда-виразу
                .collect(Collectors.toList());

        return ResponseEntity.ok(citiesDTOs);
    }
}
