package com.example.ExamWork.service.impl;

import com.example.ExamWork.entity.ParkingPlace;
import com.example.ExamWork.repo.ParkingPlaceRepo;
import com.example.ExamWork.service.ParkingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingPlaceService {
    private final ParkingPlaceRepo repo;

    @Override
    public List<ParkingPlace> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<ParkingPlace> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
         repo.deleteById(id);
    }

    @Override
    public ParkingPlace save(ParkingPlace parkingPlace) throws NullPointerException {
        return repo.save(parkingPlace);
    }
}
