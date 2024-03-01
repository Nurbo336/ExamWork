package com.example.ExamWork.entity;

import com.example.ExamWork.enums.ParkingStatus;
import com.example.ExamWork.enums.TypeParkingPlace;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
@Builder

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ParkingStatus status;
    private TypeParkingPlace typeParkingPlace;
}
