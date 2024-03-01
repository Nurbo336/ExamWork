package com.example.ExamWork.service.impl;

import com.example.ExamWork.dto.BookingDto;
import com.example.ExamWork.dto.ParkingSpotsDto;
import com.example.ExamWork.entity.Booking;
import com.example.ExamWork.entity.ParkingSpots;
import com.example.ExamWork.entity.User;
import com.example.ExamWork.enums.ParkingStatus;
import com.example.ExamWork.enums.TypeParkingSpots;
import com.example.ExamWork.repo.BookingRepo;
import com.example.ExamWork.repo.ParkingSpotsRepo;
import com.example.ExamWork.repo.UserRepo;
import com.example.ExamWork.service.BookingService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepo repo;
    private final ParkingSpotsRepo parkingSpotsRepo;
    private final UserRepo userRepo;


    @Override
    public List<BookingDto> getAll() {
        List<Booking> bookingList = repo.findAll();
        List<BookingDto> bookingDtos = new ArrayList<>();
        for (Booking booking : bookingList) {
            BookingDto bookingDto = BookingDto.builder()
                    .id(booking.getId())
                    .status(booking.getStatus())
                    .userId(booking.getUserId().getId())
                    .parkingSpotId(booking.getParkingSpots().getId())
                    .typeParkingSpots(booking.getTypeParkingSpots())
                    .build();
            bookingDtos.add(bookingDto);
        }
        return bookingDtos;
    }

    @Override
    public BookingDto bookingParkingSpot(Long userId, Long parkingSpotId) {
        ParkingSpots parkingSpot = parkingSpotsRepo.findById(parkingSpotId)
                .orElseThrow(() -> new EntityNotFoundException("Parking spot not found with id " + parkingSpotId));
        if (parkingSpot.getStatus() != ParkingStatus.FREE) {
            throw new IllegalStateException("Parking spot is not available for booking");
        }
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));
        parkingSpot.setStatus(ParkingStatus.RESERVE);
        parkingSpotsRepo.save(parkingSpot);

        Booking booking = Booking.builder()
                .status(ParkingStatus.RESERVE)
                .typeParkingSpots(parkingSpot.getTypeParkingSpots())
                .parkingSpots(parkingSpot)
                .userId(user)
                .build();
        Booking savedBooking = repo.save(booking);

        return BookingDto.builder()
                .id(savedBooking.getId())
                .status(savedBooking.getStatus())
                .typeParkingSpots(savedBooking.getTypeParkingSpots())
                .parkingSpotId(savedBooking.getParkingSpots().getId())
                .userId(savedBooking.getUserId().getId())
                .build();

    }

    @Override
    public BookingDto findById(Long id) {
        Booking booking = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Booking not found with id " + id));
        BookingDto bookingDto = BookingDto.builder()
                .id(booking.getId())
                .status(booking.getStatus())
                .typeParkingSpots(booking.getTypeParkingSpots())
                .build();
        return bookingDto;
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void releaseBooking(Integer parkingSpotNum) {
            ParkingSpots parkingSpot = parkingSpotsRepo.findByParkingNum(parkingSpotNum);

            if (parkingSpot == null) {
                throw new EntityNotFoundException("Parking spot not found with number: " + parkingSpotNum);
            }

            parkingSpot.setStatus(ParkingStatus.FREE);

            parkingSpotsRepo.save(parkingSpot);
        }


    @Override
    public Long save(BookingDto bookingDto) throws NullPointerException {
        User user = userRepo.findById(bookingDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + bookingDto.getUserId()));
        Booking booking = Booking.builder()
                .userId(user)
                .typeParkingSpots(bookingDto.getTypeParkingSpots())
                .status(bookingDto.getStatus())
                .build();

        Booking savedBooking = repo.save(booking);
        return savedBooking.getId();
    }
}
