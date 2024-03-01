package com.example.ExamWork.service;

import com.example.ExamWork.dto.BookingDto;
import com.example.ExamWork.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<BookingDto> getAll();
    BookingDto bookingParkingSpot(Long userId, Long parkingSpotId);
    BookingDto findById(Long id);
    void deleteById(Long id);
    void releaseBooking(Integer parkingSpotNumber);
    Long save(BookingDto bookingDto) throws NullPointerException;
}
