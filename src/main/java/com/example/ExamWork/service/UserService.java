package com.example.ExamWork.service;

import com.example.ExamWork.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
    User save(User user) throws NullPointerException;


}
