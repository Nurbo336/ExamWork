package com.example.ExamWork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder

@Data
@AllArgsConstructor
public class ParkingPlaceDto {
    private Long id;
    private String status;
    private String typeParkingPlace;
    private Integer parkingNum;

}
