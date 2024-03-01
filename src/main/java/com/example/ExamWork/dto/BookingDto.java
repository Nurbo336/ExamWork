package com.example.ExamWork.dto;

import com.example.ExamWork.entity.ParkingSpots;
import com.example.ExamWork.entity.User;
import com.example.ExamWork.enums.ParkingStatus;
import com.example.ExamWork.enums.TypeParkingSpots;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;
    private ParkingStatus status;
    private TypeParkingSpots typeParkingSpots;
    private Long userId;
    private Long parkingSpotId;
}
