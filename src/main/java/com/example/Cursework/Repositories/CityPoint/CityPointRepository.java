package com.example.Cursework.Repositories.CityPoint;

import com.example.Cursework.Repositories.CityPoint.Model.CityPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityPointRepository extends JpaRepository<CityPoint,Integer> {
}
