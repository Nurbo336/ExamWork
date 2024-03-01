package com.example.ExamWork.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParkingStatus {
    FREE("Свободно"),
    BUSY("Занято"),
    RESERVE("Бронирован")
    ;
    String DESCRIPTION;
}
