package com.example.ExamWork.service.impl;

import com.example.ExamWork.entity.Booking;
import com.example.ExamWork.repo.BookingRepo;
import com.example.ExamWork.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepo repo;

    @Override
    public List<Booking> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
         repo.deleteById(id);
    }

    @Override
    public Booking save(Booking booking) throws NullPointerException {
        return repo.save(booking);
    }
}
