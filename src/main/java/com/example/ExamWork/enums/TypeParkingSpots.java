package com.example.ExamWork.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeParkingSpots {
    STANDART("Стандартное"),
    DISABLED("Инвалидное"),
    FAMILIES("Семейное"),
    ELECTRO_CAR("Электро мобиль"),
    ;
    String DESCRIPTION;
}
