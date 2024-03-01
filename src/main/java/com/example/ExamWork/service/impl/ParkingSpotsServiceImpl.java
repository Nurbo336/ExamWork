package com.example.ExamWork.service.impl;

import com.example.ExamWork.dto.ParkingSpotsDto;
import com.example.ExamWork.entity.ParkingSpots;
import com.example.ExamWork.enums.TypeParkingSpots;
import com.example.ExamWork.repo.ParkingSpotsRepo;
import com.example.ExamWork.service.ParkingSpotsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpotsServiceImpl implements ParkingSpotsService {
    private final ParkingSpotsRepo repo;

    @Override
    public List<ParkingSpotsDto> getAll() {
        List<ParkingSpots> parkingSpots = repo.findAll();
        List<ParkingSpotsDto> parkingSpotsDtos = new ArrayList<>();
        for(ParkingSpots parkingSpot : parkingSpots) {
            ParkingSpotsDto parkingSpotsDto = ParkingSpotsDto.builder()
                    .id(parkingSpot.getId())
                    .typeParkingSpots(parkingSpot.getTypeParkingSpots())
                    .parkingNum(parkingSpot.getParkingNum())
                    .status(parkingSpot.getStatus())
                    .build();
            parkingSpotsDtos.add(parkingSpotsDto);
        }
        return parkingSpotsDtos;
    }

    @Override
    public ParkingSpotsDto findById(Long id) {
        ParkingSpots parkingSpots = repo.findById(id).orElseThrow(()->new EntityNotFoundException("Parking place not found with id " + id));
        ParkingSpotsDto parkingSpotsDto = ParkingSpotsDto.builder()
                .id(parkingSpots.getId())
                .typeParkingSpots(parkingSpots.getTypeParkingSpots())
                .parkingNum(parkingSpots.getParkingNum())
                .status(parkingSpots.getStatus())
                .build();
        return parkingSpotsDto;
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }

    @Override
    public Long save(ParkingSpotsDto parkingSpotsDto) throws NullPointerException {
        ParkingSpots parkingSpots = ParkingSpots.builder()
                .parkingNum(parkingSpotsDto.getParkingNum())
                .typeParkingSpots(parkingSpotsDto.getTypeParkingSpots())
                .status(parkingSpotsDto.getStatus())
                .build();
        ParkingSpots savedParkingSpots = repo.save(parkingSpots);
        return savedParkingSpots.getId();
    }
    public List<ParkingSpotsDto> getParkingSpotsByType(TypeParkingSpots type) {
        return repo.findByTypeParkingSpots(type);
    }

}
