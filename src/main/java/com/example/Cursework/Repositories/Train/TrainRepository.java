package com.example.Cursework.Repositories.Train;

import com.example.Cursework.Repositories.Train.Model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {

}
