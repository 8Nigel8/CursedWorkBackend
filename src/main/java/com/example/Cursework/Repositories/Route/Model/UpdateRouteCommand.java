package com.example.Cursework.Repositories.Route.Model;

import com.example.Cursework.Repositories.Route.Model.Route;
import lombok.Data;

@Data
public class UpdateRouteCommand {
    private int id;
    private Route route;

    public UpdateRouteCommand(Integer id, Route route) {
        this.id = id;
        this.route = route;
    }
}
