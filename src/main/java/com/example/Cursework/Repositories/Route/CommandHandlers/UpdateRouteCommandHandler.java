package com.example.Cursework.Repositories.Route.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.Route.Model.Route;
import com.example.Cursework.Repositories.Route.Model.UpdateRouteCommand;
import com.example.Cursework.Repositories.Route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateRouteCommandHandler implements Command<UpdateRouteCommand, ResponseEntity> {
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateRouteCommand command) {
        Route route = command.getRoute();
        route.setId(Long.valueOf(command.getId()));
        routeRepository.save(route);
        return ResponseEntity.ok().build();
    }
}
