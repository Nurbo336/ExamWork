package com.example.ExamWork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
}
