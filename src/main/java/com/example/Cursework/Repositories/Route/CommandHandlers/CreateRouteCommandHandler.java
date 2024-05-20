package com.example.Cursework.Repositories.Route.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.Route.Model.Route;
import com.example.Cursework.Repositories.Route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateRouteCommandHandler implements Command<Route, ResponseEntity> {
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public ResponseEntity execute(Route route) {
        routeRepository.save(route);
        return ResponseEntity.ok().build();
    }
}
