package com.example.ExamWork.service.impl;

import com.example.ExamWork.dto.UserDto;
import com.example.ExamWork.entity.User;
import com.example.ExamWork.repo.UserRepo;
import com.example.ExamWork.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepo repo;

    @Override
    public List<UserDto> getAll() {
        List<User> users = repo.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            UserDto userDto = UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .build();
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserDto findById(Long id) {
        User user = repo.findById(id).orElseThrow(()->new EntityNotFoundException("User not found with id " + id));
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
        return userDto;
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }

    @Override
    public Long save(UserDto userDto) throws NullPointerException {
        User user = User.builder()
                .name(userDto.getName())
                .build();
        User savedUser = repo.save(user);
        return savedUser.getId();
    }
}
