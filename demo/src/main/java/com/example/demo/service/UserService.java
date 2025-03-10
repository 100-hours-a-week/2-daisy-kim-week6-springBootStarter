package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // User Entity를 UserDto로 변환
    private UserDto convertToDto(User user) {
        return new UserDto(user.getUserId(), user.getUserName(), user.getUserPassword(),
                user.getUserEmail(), user.getUserProfileImgUrl());
    }

    // 전체 사용자 조회 (User -> UserDto 변환 후 반환)
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
