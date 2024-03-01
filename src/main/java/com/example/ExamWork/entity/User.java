package com.example.ExamWork.entity;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
@Builder

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
