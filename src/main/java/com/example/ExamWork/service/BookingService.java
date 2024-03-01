package com.example.ExamWork.service;

import com.example.ExamWork.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> getAll();
    Optional<Booking> findById(Long id);
    void deleteById(Long id);
    Booking save(Booking booking) throws NullPointerException;
}
