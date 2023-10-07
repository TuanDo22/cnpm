package com.example.projectse.service.impl;

import com.example.projectse.dto.UserDTO;
import com.example.projectse.entity.UserEntity;
import com.example.projectse.reponsitory.UserRepository;
import com.example.projectse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public boolean findEandP(String email, String password) {
        List<UserEntity> user = userRepository.findByEmailAndPassword(email, password);
        return !user.isEmpty();

    }
}
