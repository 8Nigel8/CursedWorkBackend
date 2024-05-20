package com.example.Cursework.Repositories.CityPoint.Model;

import com.example.Cursework.Repositories.City.Model.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "city_point")
public class CityPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "x")
    private Double x;
    @Column(name = "y")
    private Double y;
}
