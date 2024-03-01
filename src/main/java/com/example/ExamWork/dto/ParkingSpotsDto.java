package com.example.ExamWork.dto;

import com.example.ExamWork.enums.ParkingStatus;
import com.example.ExamWork.enums.TypeParkingSpots;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.boot.model.internal.XMLContext;

@Builder

@Data
@AllArgsConstructor
public class ParkingSpotsDto {
    private Long id;
    private ParkingStatus status;
    private TypeParkingSpots typeParkingSpots;
    private Integer parkingNum;

}
