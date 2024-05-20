package com.example.Cursework.Repositories.CityPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city_point")
public class CityPointController {
    @Autowired
    private CityPointRepository cityPointRepository;
}
