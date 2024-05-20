package com.example.Cursework.Repositories.Route.CommandHandlers;

import com.example.Cursework.Command;
import com.example.Cursework.Repositories.Route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteRouteCommandHandler implements Command<Integer, ResponseEntity> {
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(Integer id) {
        routeRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }
}
