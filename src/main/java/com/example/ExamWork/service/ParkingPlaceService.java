package com.example.ExamWork.service;

import com.example.ExamWork.entity.ParkingPlace;

import java.util.List;
import java.util.Optional;

public interface ParkingPlaceService {
    List<ParkingPlace> getAll();
    Optional<ParkingPlace> findById(Long id);
    void deleteById(Long id);
    ParkingPlace save(ParkingPlace parkingPlace) throws NullPointerException;

}
