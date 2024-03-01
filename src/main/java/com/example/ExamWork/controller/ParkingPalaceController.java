package com.example.ExamWork.controller;

import com.example.ExamWork.entity.ParkingPlace;
import com.example.ExamWork.service.ParkingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/parkingPalace")
public class ParkingPalaceController {
    private final ParkingPlaceService service;

    @GetMapping("/all")
    public List<ParkingPlace> getAllParkingPlace() {
        return service.getAll();
    }
    @GetMapping("findById/{id}")
    public Optional<ParkingPlace> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        service.deleteById(id);
    }

}
