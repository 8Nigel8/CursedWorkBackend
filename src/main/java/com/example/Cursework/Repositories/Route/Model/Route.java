package com.example.Cursework.Repositories.Route.Model;

import com.example.Cursework.Repositories.City.Model.City;
import com.example.Cursework.Repositories.Train.Model.Train;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainID")
    private Train train;

//    @ManyToOne()
//    @JoinColumn(name = "departureCityID")
//    private City departureCity;

    @Column(name = "departuretime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Future(message = "Departure time must be a future")
    private Timestamp departureTime;

    @ManyToMany()
    @JoinTable(
            name = "route_city",
            joinColumns = @JoinColumn(name = "routeID"),
            inverseJoinColumns = @JoinColumn(name = "cityID")
    )
    private Set<City> cities = new HashSet<>();

}
