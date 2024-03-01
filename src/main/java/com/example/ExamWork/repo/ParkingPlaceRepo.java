package com.example.ExamWork.repo;

import com.example.ExamWork.entity.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPlaceRepo extends JpaRepository<ParkingPlace,Long> {
}
