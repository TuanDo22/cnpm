package com.example.projectse.service;

import com.example.projectse.dto.UserDTO;
import com.example.projectse.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean findEandP(String email, String password);

}
