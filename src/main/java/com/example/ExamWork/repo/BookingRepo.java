package com.example.ExamWork.repo;

import com.example.ExamWork.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository <Booking,Long> {
}
