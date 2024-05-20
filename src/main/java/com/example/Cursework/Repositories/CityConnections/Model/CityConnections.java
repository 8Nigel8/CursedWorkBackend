package com.example.Cursework.Repositories.CityConnections.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cities_connection")
public class CityConnections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cityAName")
    private String cityAName;

    @Column(name = "cityBName")
    private String cityBName;
}
