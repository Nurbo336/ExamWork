package com.example.ExamWork.repo;

import com.example.ExamWork.dto.ParkingSpotsDto;
import com.example.ExamWork.entity.ParkingSpots;
import com.example.ExamWork.enums.TypeParkingSpots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotsRepo extends JpaRepository<ParkingSpots,Long> {
    ParkingSpots findByParkingNum(Integer parkingSpotNum);
    List<ParkingSpotsDto> findByTypeParkingSpots(TypeParkingSpots type);

}
