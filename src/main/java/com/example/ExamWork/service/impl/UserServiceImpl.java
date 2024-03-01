package com.example.ExamWork.service.impl;

import com.example.ExamWork.entity.User;
import com.example.ExamWork.repo.UserRepo;
import com.example.ExamWork.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepo repo;

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public User save(User user) throws NullPointerException {
        return repo.save(user);
    }
}
