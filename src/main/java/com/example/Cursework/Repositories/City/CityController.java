package com.example.Cursework.Repositories.City;

import com.example.Cursework.Repositories.City.CommandHandlers.CreateAllCitiesCommandHendler;
import com.example.Cursework.Repositories.City.CommandHandlers.CreateCityCommandHandler;
import com.example.Cursework.Repositories.City.CommandHandlers.DeleteCityCommandHandler;
import com.example.Cursework.Repositories.City.CommandHandlers.UpdateCityCommandHandler;
import com.example.Cursework.Repositories.City.Model.City;
import com.example.Cursework.Repositories.City.Model.UpdateCityCommand;
import com.example.Cursework.Repositories.City.QueryHandlers.GetAllCitiesLazyQueryHandler;
import com.example.Cursework.Repositories.City.QueryHandlers.GetAllCitiesQueryHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired private GetAllCitiesQueryHandler getAllCitiesQueryHandler;
    @Autowired private GetAllCitiesLazyQueryHandler getAllCitiesLazyQueryHandler;
    @Autowired private CreateCityCommandHandler createCityCommandHandler;
    @Autowired private UpdateCityCommandHandler updateCityCommandHandler;
    @Autowired private DeleteCityCommandHandler deleteCityCommandHandler;
    @Autowired private CreateAllCitiesCommandHendler createAllCitiesCommandHendler;

    @GetMapping("/get_all")
    public ResponseEntity getAllCities() {
        return getAllCitiesQueryHandler.execute(null);
    }
    @GetMapping("/get_lazy_all")
    public ResponseEntity getAllCitiesLazy() {
        return getAllCitiesLazyQueryHandler.execute(null);
    }
    @PostMapping
    public ResponseEntity createCity(@Valid @RequestBody City city) {
        return createCityCommandHandler.execute(city);
    }

    @PostMapping("/save_all")
    public ResponseEntity createAllCities(@Valid @RequestBody List<City> cities)
    {
        return createAllCitiesCommandHendler.execute(cities);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCity(@Valid @PathVariable Integer id, @RequestBody City city) {
        UpdateCityCommand command = new UpdateCityCommand(id, city);
        return updateCityCommandHandler.execute(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCity(@PathVariable Integer id) {
        return deleteCityCommandHandler.execute(id);
    }
}
