package com.example.Cursework.Repositories.Route;

import com.example.Cursework.Repositories.Route.CommandHandlers.CreateRouteCommandHandler;
import com.example.Cursework.Repositories.Route.CommandHandlers.DeleteRouteCommandHandler;
import com.example.Cursework.Repositories.Route.CommandHandlers.UpdateRouteCommandHandler;
import com.example.Cursework.Repositories.Route.Model.Route;
import com.example.Cursework.Repositories.Route.Model.RouteDTO;
import com.example.Cursework.Repositories.Route.QueryHandlers.GetAllRoutesQueryHandler;
import com.example.Cursework.Repositories.Route.Model.UpdateRouteCommand;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired private GetAllRoutesQueryHandler getAllRoutesQueryHandler;
    @Autowired private CreateRouteCommandHandler createRouteCommandHandler;
    @Autowired private UpdateRouteCommandHandler updateRouteCommandHandler;
    @Autowired private DeleteRouteCommandHandler deleteRouteCommandHandler;

    @GetMapping("/get_all")
    public ResponseEntity<List<RouteDTO>> getAllCities() {
        return getAllRoutesQueryHandler.execute(null);
    }

    @PostMapping
    public ResponseEntity createCity(@Valid @RequestBody Route route) {
        return createRouteCommandHandler.execute(route);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCity(@Valid @PathVariable Integer id, @RequestBody Route route) {
        UpdateRouteCommand command = new UpdateRouteCommand(id, route);
        return updateRouteCommandHandler.execute(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCity(@PathVariable Integer id) {
        return deleteRouteCommandHandler.execute(id);
    }
}
