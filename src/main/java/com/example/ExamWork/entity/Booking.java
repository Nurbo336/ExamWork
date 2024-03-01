package com.example.ExamWork.entity;

import com.example.ExamWork.enums.ParkingStatus;
import com.example.ExamWork.enums.TypeParkingSpots;
import jakarta.persistence.*;
import lombok.*;

@Builder

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ParkingStatus status;
    private TypeParkingSpots typeParkingSpots;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_id")
    private ParkingSpots parkingSpots;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;
}
