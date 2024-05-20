package com.example.Cursework.Repositories.Route;

import com.example.Cursework.Repositories.Route.Model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Integer> {

}
