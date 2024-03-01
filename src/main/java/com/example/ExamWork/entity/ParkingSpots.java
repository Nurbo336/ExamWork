package com.example.ExamWork.entity;

import com.example.ExamWork.enums.ParkingStatus;
import com.example.ExamWork.enums.TypeParkingSpots;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ParkingStatus status;
    @Enumerated(value = EnumType.STRING)
    private TypeParkingSpots typeParkingSpots;
    private Integer parkingNum;
    @OneToMany(cascade = CascadeType.ALL)
    private List <Booking> booking;


}
