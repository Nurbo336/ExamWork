package com.example.ExamWork.entity;

import com.example.ExamWork.enums.ParkingStatus;
import com.example.ExamWork.enums.TypeParkingPlace;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
@Builder
@Entity
@Data

public class ParkingPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ParkingStatus status;
    private TypeParkingPlace typeParkingPlace;
    private Integer parkingNum;
}
