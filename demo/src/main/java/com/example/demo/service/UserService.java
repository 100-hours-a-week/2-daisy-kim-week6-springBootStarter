package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserDto> getUserList() {
        return userRepository.findAll();
    }
}
