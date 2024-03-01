package com.example.ExamWork.service;

import com.example.ExamWork.dto.UserDto;
import com.example.ExamWork.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<UserDto> getAll();
    UserDto findById(Long id);
    void deleteById(Long id);
    Long save(UserDto userDto) throws NullPointerException;


}
