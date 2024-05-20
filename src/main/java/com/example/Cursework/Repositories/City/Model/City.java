package com.example.Cursework.Repositories.City.Model;

import com.example.Cursework.Repositories.CityPoint.Model.CityPoint;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "City name can not be empty")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pointID")
    private CityPoint point;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cities_connection",
            joinColumns = @JoinColumn(name = "cityBName", referencedColumnName = "name"),
            inverseJoinColumns = @JoinColumn(name = "cityAName", referencedColumnName = "name")
    )
    private Set<City> connectedCities = new HashSet<>();
}
