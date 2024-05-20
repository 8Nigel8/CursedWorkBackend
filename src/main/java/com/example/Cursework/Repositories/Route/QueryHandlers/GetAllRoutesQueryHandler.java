package com.example.Cursework.Repositories.Route.QueryHandlers;

import com.example.Cursework.Query;
import com.example.Cursework.Repositories.Route.Model.Route;
import com.example.Cursework.Repositories.Route.Model.RouteDTO;
import com.example.Cursework.Repositories.Route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllRoutesQueryHandler implements Query<Void, List<RouteDTO>> {
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public ResponseEntity<List<RouteDTO>> execute(Void input){
        List<RouteDTO>routeDTOs = routeRepository.findAll().stream().map(route -> new RouteDTO(route)).toList();
        return ResponseEntity.ok(routeDTOs);
    }
}
