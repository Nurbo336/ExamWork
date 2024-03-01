package com.example.ExamWork.service;

import com.example.ExamWork.dto.ParkingSpotsDto;
import com.example.ExamWork.enums.TypeParkingSpots;

import java.util.List;

public interface ParkingSpotsService {
    List<ParkingSpotsDto> getAll();
    ParkingSpotsDto findById(Long id);
    void deleteById(Long id);
    Long save(ParkingSpotsDto parkingSpotsDto) throws NullPointerException;

    List<ParkingSpotsDto> getParkingSpotsByType(TypeParkingSpots type);
}
