package com.example.Cursework.Repositories.CityConnections;

import com.example.Cursework.Repositories.CityConnections.Model.CityConnections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/city_connections")
public class CityConnectionsController {
    @Autowired private CityConnectionsRepository cityConnectionsRepository;
    @PostMapping("/save_all")
    public ResponseEntity saveAllCityConnections(@RequestBody List<CityConnections> cityConnections){
        cityConnectionsRepository.saveAll(cityConnections);
        return ResponseEntity.ok().build();
    }
}
