package com.example.projectse.service.impl;

import com.example.projectse.reponsitory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;
    public void deleteE(long id){
        employeeRepository.deleteById(id);
    }
}
