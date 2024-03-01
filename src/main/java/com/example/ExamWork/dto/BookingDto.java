package com.example.ExamWork.dto;

import com.example.ExamWork.enums.ParkingStatus;
import com.example.ExamWork.enums.TypeParkingPlace;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private String status;
    private String typeParkingPlace;
}
